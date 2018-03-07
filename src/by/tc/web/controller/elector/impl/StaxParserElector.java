package by.tc.web.controller.elector.impl;

import by.tc.web.controller.Logger;
import by.tc.web.controller.elector.XmlParserElector;
import by.tc.web.service.ServiceFactory;
import by.tc.web.service.exception.ServiceException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StaxParserElector implements XmlParserElector {
	
    public void execute(HttpServletRequest request, HttpServletResponse response) {
    	ServiceFactory factory = ServiceFactory.getInstance();
    	List<String> result = null;
    	try {
			result = factory.getParsingService().parseStax(request);
    	} catch (ServiceException e) {
			Logger.getLogger().printError(request, e);
		}
        request.setAttribute(DomParserElector.RESULT, result);
    }
}
