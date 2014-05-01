package com.example.rssdatabase;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class RssParseHandler extends DefaultHandler{
private List<RSSitem> rssItems;

private RSSitem currentItem;
private boolean parsingTitle;
private boolean parsingLink;

public RssParseHandler(){
	
	rssItems=new ArrayList<RSSitem>();
}

List<RSSitem> getItems(){
	return rssItems;
	
}



@Override
public void startElement(String uri, String localName,String qName,Attributes attributes) throws SAXException{
if("content-item".equals(qName)){
	currentItem=new RSSitem();
}else if ("title".equals(qName)){
	parsingTitle=true;
	
}	else if("uri".equals(qName)){
	 parsingLink= true;
}

}


@Override
public void endElement(String uri, String localName,String qName) throws SAXException{
	
	if("content-item".equals(qName)){
		rssItems.add(currentItem);
		currentItem=null;
	}else if ("title".equals(qName)){
		parsingTitle=false;
		
	}	else if("uri".equals(qName)){
		 parsingLink= false;
	}
}

@Override
public void characters(char [] ch, int start,int length) throws SAXException{
	if(parsingTitle){
	if(currentItem!=null){
		currentItem.setTitle(new String(ch,start,length));
	}else if (parsingLink){
		if(currentItem!=null){
			currentItem.setLink(new String(ch,start,length));
			parsingLink=false;
		}
		
		
	}	
	}
}






}
