package by.tc.web.service.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.tc.web.service.exception.ServiceException;

public class StaxParser {	
	private static StringBuilder result=new StringBuilder();
    public static StringBuilder getParsedData() {
        return result;
    }

    public static void parseStax(File file) throws ServiceException {
        String level=ConstantForParsers.EMPTY_STRING;
        XMLStreamReader read=null;
        try{
            XMLInputFactory factory=XMLInputFactory.newInstance();
            read = factory.createXMLStreamReader(new FileInputStream(file));
            String text = null;
            while (read.hasNext()){
                int type=read.next();
                switch (type){
                    case XMLStreamConstants.START_ELEMENT: {
                        result.append(level).append(read.getLocalName().toUpperCase());
                        level+=ConstantForParsers.LEVEL;
                        int attributes = read.getAttributeCount();
                        for (int i = 0; i < attributes; i++) {
                            result.append(ConstantForParsers.SPACE).append(read.getAttributeLocalName(i)).append(ConstantForParsers.ATTRIBUTE_VALUE).append(read.getAttributeValue(i));
                        }
                        result.append(ConstantForParsers.LINE_BREAKER);
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS:{
                        text = read.getText().trim();
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT:{
                        if (text!=null && !text.isEmpty()) {
                        	result.append(level).append(text).append(ConstantForParsers.LINE_BREAKER);
                        	text=null;
                        }
                        level=level.substring(ConstantForParsers.PADDING);
                        break;
                    }

                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
        		throw new ServiceException(e);
        } 
        finally {
                if (read != null) {
                    try {
						read.close();
					} catch (XMLStreamException e) {
		        		throw new ServiceException(e);
					}
                }
        }
    }
}
