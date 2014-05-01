package com.example.rssdatabase;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.example.rssdatabase.RSSitem;

public class RssReader {

	private String rssUri;
	public RssReader(String rssUri){
		this.rssUri = rssUri;
		
	}


public List<RSSitem> getItems() throws Exception{
	
	SAXParserFactory factory= SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();

	RssParseHandler handler=new RssParseHandler();
	saxParser.parse(rssUri, handler);
	return handler.getItems();
}




}
