package by.tc.web.service;

import by.tc.web.service.impl.ParsingServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ParsingService parsingService = new ParsingServiceImpl();

    private ServiceFactory() {
    }

    public ParsingService getParsingService() {
        return parsingService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
