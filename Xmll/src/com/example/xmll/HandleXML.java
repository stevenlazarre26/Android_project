package com.example.xmll;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class HandleXML extends DefaultHandler {

	XMLData info = new XMLData ();

	public String getinformation() {
		
		return info.dataToString();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if(localName.equalsIgnoreCase("title")){
		String title = attributes.getValue("number");
		info.setTitle(title);
		
		}
	}

	
}
