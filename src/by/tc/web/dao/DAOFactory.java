package by.tc.web.dao;

import by.tc.web.dao.impl.ParsingDAOimpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final ParsingDAO userDao = new ParsingDAOimpl();

    private DAOFactory() {
    }

    public ParsingDAO getParsingDAO() {
        return userDao;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
