package org.developerworks.android;

import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.xmlpull.v1.XmlSerializer;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class DescriptionActivity extends ListActivity {


	private static String DBNAME = "RSS.db"; // THIS IS THE SQLITE DATABASE FILE
												// NAME.
	static String TABLE = "RSSTABLE5";
	static List<Message> messages=new ArrayList<Message>();
	static SQLiteDatabase mydb;
	Button dbRecordBtn;
	
     BroadcastReceiver mReceiver = new MyReceiver();
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		try {
		
			mydb = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
			mydb.execSQL("CREATE TABLE IF  NOT EXISTS " + TABLE
					+ " (ID INTEGER PRIMARY KEY,TitleName TEXT, DateRSS TEXT);");

		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Error in creating table",
					Toast.LENGTH_LONG).show();
		}
		
		//Intent intent = new Intent();
     //  intent.setAction("ax.androidexample.mybroadcast");
       // sendBroadcast(intent);
		
	    IntentFilter filter = new IntentFilter("android.intent.action.BOOT_COMPLETED");
	    filter.addAction("android.intent.action.USER_PRESENT");
       
        registerReceiver(mReceiver, filter);
	DescriptionActivity.this.startService(new Intent(DescriptionActivity.this, NotifyService.class));
		
		//registerReceiver(broad, new IntentFilter("android.intent.action.BOOT_COMPLETED"));
	
	
		  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					R.layout.row, getTitlesfromDatabse());
			this.setListAdapter(adapter);
		
		
		dbRecordBtn = (Button) findViewById(R.id.buttonDb);
		dbRecordBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				openDatabaseRecords();
			}

		});
	}
	   @Override
       protected void onResume() {
       
		  
	        super.onResume();
	        IntentFilter filter = new IntentFilter("android.intent.action.BOOT_COMPLETED");
		    filter.addAction("android.intent.action.USER_PRESENT");
	       
	        registerReceiver(mReceiver, filter);
       }
       
       @Override
       protected void onPause() {
    	   super.onPause();
    	   unregisterReceiver(mReceiver);
            // Unregister reciever if activity is not in front
           
           
       }
       

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(Menu.NONE, ParserType.ANDROID_SAX.ordinal(),
				ParserType.ANDROID_SAX.ordinal(), R.string.android_sax);
		menu.add(Menu.NONE, ParserType.SAX.ordinal(), ParserType.SAX.ordinal(),
				R.string.sax);
		menu.add(Menu.NONE, ParserType.DOM.ordinal(), ParserType.DOM.ordinal(),
				R.string.dom);
		menu.add(Menu.NONE, ParserType.XML_PULL.ordinal(),
				ParserType.XML_PULL.ordinal(), R.string.pull);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		super.onMenuItemSelected(featureId, item);
		ParserType type = ParserType.values()[item.getItemId()];
		ArrayAdapter<String> adapter = (ArrayAdapter<String>) this
				.getListAdapter();
		if (adapter.getCount() > 0) {
			adapter.clear();
		}
		NotifyService.loadFeed(type);
		return true;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		FeedParser parser = FeedParserFactory.getParser(ParserType.ANDROID_SAX);
		
		messages = parser.parse();
	
		Intent viewMessage = new Intent(Intent.ACTION_VIEW, Uri.parse(messages
				.get(position).getLink().toExternalForm()));
		this.startActivity(viewMessage);
	}



	

	@SuppressLint("NewApi")
	static void RssTitleAddToDatabase(List<String> titles) {
		// TODO Auto-generated method stub

		try {

			Calendar c = Calendar.getInstance();

			SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			String formattedDateInsert = df.format(c.getTime());

			ContentValues values = new ContentValues();
			long retvalue = 0;

			for (int i = 0; i < titles.size(); i++) {

				
				values.put("TitleName", titles.get(i).toString());
				values.put("DateRSS", formattedDateInsert);
				mydb.insertWithOnConflict(TABLE, null, values, 1);

			}

		} catch (Exception e) {

			//Toast.makeText(getBaseContext(), "" + e, Toast.LENGTH_LONG).show();
		}

	}

	private boolean openDatabaseRecords() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		String msgdate = null;
		

		Cursor c1 = mydb.rawQuery("SELECT * FROM " + TABLE, null);
		if (c1 != null && c1.getCount() != 0) {

			Intent nextAct = new Intent(DescriptionActivity.this,
					DatabaseRecords.class);
		
			startActivityForResult(nextAct, 1);

		}

		else {
			new AlertDialog.Builder(DescriptionActivity.this)
					.setMessage("There are no records.")
					.setNeutralButton("OK", null).setTitle("Error").show();
			return false;
		}

		return true;

	}

	

	
	static List<String>  getTitlesfromDatabse(){
	
		List<String> getListofTitles=new ArrayList<String>();
		
		Cursor  c1  = mydb.rawQuery("SELECT * FROM "+  TABLE, null);
		  if (c1 != null &&c1.getCount() != 0) {
		   if (c1.moveToFirst()) {
		    do {
		   
		 
		    
		    	getListofTitles.add(c1.getString(c1
		    	       .getColumnIndex("TitleName"))+"\n"+c1.getString(c1
				    	       .getColumnIndex("DateRSS")));
		      
		     
		    	 
		 
		    } while (c1.moveToNext());
		  
		  }
	}
		
		
		
		
		return getListofTitles;
		
		
		
	}
	
	

	
}