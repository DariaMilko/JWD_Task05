package by.tc.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.tc.web.service.exception.ServiceException;

public interface ParsingService {
	List<String> parseDom(HttpServletRequest request) throws ServiceException;
	List<String> parseSax(HttpServletRequest request) throws ServiceException;
	List<String> parseStax(HttpServletRequest request) throws ServiceException;
	List<String> showNext() throws ServiceException;
}
