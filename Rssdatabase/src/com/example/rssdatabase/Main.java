package com.example.rssdatabase;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main extends ListActivity {
	//String [] days = {"Sunday","Monday","Wednesday","Thursday","Friday","Saturday","Sunday"};
	ListView l;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	try{
		l=getListView();
		RssReader rssReader= new RssReader("http://feeds.ign.com/ign/all");
		ArrayAdapter<RSSitem> adapter= new ArrayAdapter<RSSitem>(this,android.R.layout.simple_list_item_1,rssReader.getItems());
		l.setAdapter(adapter);
		l.setOnItemClickListener(new ListListener(rssReader.getItems(),this));
	}catch(Exception e){
		Log.e("rssdatabase",e.getMessage());
	}
	}
}