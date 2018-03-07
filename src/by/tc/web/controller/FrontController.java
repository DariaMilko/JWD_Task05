package by.tc.web.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.web.controller.elector.XmlParserElector;
import by.tc.web.controller.elector.XmlParserElectorProvider;

import java.io.IOException;

public class FrontController extends HttpServlet {
    private static final String JSP_PACKAGE = "/WEB-INF/jsp/result.jsp";
    private static final String COMMAND = "command";

    public FrontController() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strCommand = request.getParameter(COMMAND);
        XmlParserElectorProvider provider = XmlParserElectorProvider.getProvider();
        XmlParserElector command = provider.getCommand(strCommand);
        command.execute(request, response);
        RequestDispatcher disp = request.getRequestDispatcher(JSP_PACKAGE);
        disp.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
