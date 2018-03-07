package by.tc.web.controller.elector;

import java.util.HashMap;
import java.util.Map;

import by.tc.web.controller.elector.impl.DomParserElector;
import by.tc.web.controller.elector.impl.SaxParserElector;
import by.tc.web.controller.elector.impl.ShowNextElector;
import by.tc.web.controller.elector.impl.StaxParserElector;

public class XmlParserElectorProvider {
	
	private static Map <XmlParserElectorName, XmlParserElector> commands;
	private static  XmlParserElectorProvider provider = new XmlParserElectorProvider();

	public static XmlParserElectorProvider getProvider() {
		return provider;
	}

	private XmlParserElectorProvider() {
		commands = new HashMap<XmlParserElectorName, XmlParserElector>();
		commands.put(XmlParserElectorName.SAX, new SaxParserElector());
		commands.put(XmlParserElectorName.STAX, new StaxParserElector());
		commands.put(XmlParserElectorName.DOM, new DomParserElector());
		commands.put(XmlParserElectorName.NEXT, new ShowNextElector());
	}
	
	public XmlParserElector getCommand (String key) {
		return commands.get(XmlParserElectorName.valueOf(key.toUpperCase()));
	}
}
