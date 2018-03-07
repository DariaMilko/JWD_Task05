package by.tc.web.dao.impl;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import by.tc.web.dao.ParsingDAO;
import by.tc.web.dao.exception.DAOException;

public class ParsingDAOimpl implements ParsingDAO{
	private static final String WEB_INF = "/WEB-INF";
	private static final String EXAMPLE = "/files/example.xml";
    
	public File provideSource(HttpServletRequest request) throws DAOException {
		return new File(request.getServletContext().getRealPath(WEB_INF).concat(EXAMPLE));
	}
}
