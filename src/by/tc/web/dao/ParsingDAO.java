package by.tc.web.dao;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import by.tc.web.dao.exception.DAOException;

public interface ParsingDAO {
	File provideSource(HttpServletRequest request) throws DAOException;
}
