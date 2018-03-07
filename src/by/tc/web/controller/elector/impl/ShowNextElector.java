package by.tc.web.controller.elector.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.tc.web.controller.Logger;
import by.tc.web.controller.elector.XmlParserElector;
import by.tc.web.service.ServiceFactory;
import by.tc.web.service.exception.ServiceException;

public class ShowNextElector implements XmlParserElector {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ServiceFactory factory = ServiceFactory.getInstance();
    	List<String> result = null;
    	try {
			result = factory.getParsingService().showNext();
    	} catch (ServiceException e) {
			Logger.getLogger().printError(request, e);
		}
    	request.setAttribute(DomParserElector.RESULT, result);

	}

}
