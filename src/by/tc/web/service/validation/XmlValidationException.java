package by.tc.web.service.validation;

public class XmlValidationException extends Exception{	
	public XmlValidationException() {
		super();
	}

	public XmlValidationException(String message) {
        super(message);
    }
	
	public XmlValidationException(String message, Exception exception) {
        super(message, exception);
    }
	
	public XmlValidationException(Exception exception) {
        super(exception);
    }
}
