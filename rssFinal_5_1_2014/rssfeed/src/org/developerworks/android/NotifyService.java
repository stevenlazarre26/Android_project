package org.developerworks.android;


import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.xmlpull.v1.XmlSerializer;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.util.Log;
import android.util.Xml;
import android.widget.ArrayAdapter;
import android.widget.Toast;
 
public class NotifyService extends Service{
	@SuppressLint("NewApi")
	//public NotifyService() {
		//super("NotifyService");
		// TODO Auto-generated constructor stub
	//}

	static List<Message> messages;
    private static final String TAG = "MyService";
	private static String DBNAME = "RSS.db"; // THIS IS THE SQLITE DATABASE FILE
	// NAME.
static String TABLE = "RSSTABLE5";
static ArrayList<String> value=new ArrayList<String>();
static SQLiteDatabase mydb;
static boolean 	notifyboolean=false;
BroadcastReceiver mReceiver ;
 
   @SuppressLint("NewApi")
	@Override
    public IBinder onBind(Intent arg0) {
    	 Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
         Log.d(TAG, "onStart");
        
         mydb = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
         loadFeed(ParserType.SAX);
         if(notifyboolean==true){
        	 for(int i=0;i<value.size();i++){
 	        showNotification(value.get(i));
 	        
        	 }
 	       }
		return null;
    }
 
    @SuppressLint("NewApi")
	@Override
    public void onCreate() {
    	 
    	 Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
         Log.d(TAG, "onStart");
     
         mReceiver = new MyReceiver();
        IntentFilter filter = new IntentFilter("android.intent.action.BOOT_COMPLETED");
           filter.addAction("android.intent.action.USER_PRESENT");
           registerReceiver(mReceiver,filter);
         mydb = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
         loadFeed(ParserType.SAX);
         if(notifyboolean==true){
        	 for(int i=0;i<value.size();i++){
 	        showNotification(value.get(i));
 	        
        	 }
 	       }
    }
 
    @SuppressLint("NewApi")
	@Override
    public void onStart(Intent intent, int startId) {
        Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStart");
        Toast.makeText(this, "Congrats! MyService Created", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreate");
        mydb = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
        loadFeed(ParserType.SAX);
        if(notifyboolean==true){
       	 for(int i=0;i<value.size();i++){
	        showNotification(value.get(i));
	        
       	 }
	       }
        
    //Note: You can start a new thread and use it for long background processing from here.
    }
 
    @Override
    public void onDestroy() {
        Toast.makeText(this, "MyService Stopped", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroy");

	    IntentFilter filter = new IntentFilter("android.intent.action.BOOT_COMPLETED");
        filter.addAction("android.intent.action.USER_PRESENT");
        unregisterReceiver(mReceiver);
    }
    
    private static String writeXml() {
		XmlSerializer serializer = Xml.newSerializer();
		StringWriter writer = new StringWriter();
		try {
			serializer.setOutput(writer);
			serializer.startDocument("UTF-8", true);
			serializer.startTag("", "messages");
			serializer.attribute("", "number", String.valueOf(messages.size()));
			for (Message msg : messages) {
				serializer.startTag("", "message");
				serializer.attribute("", "date", msg.getDate());
				serializer.startTag("", "title");
				serializer.text(msg.getTitle());
				serializer.endTag("", "title");
				serializer.startTag("", "url");
				serializer.text(msg.getLink().toExternalForm());
				serializer.endTag("", "url");
				serializer.startTag("", "body");
				serializer.text(msg.getDescription());
				serializer.endTag("", "body");
				serializer.endTag("", "message");
			}
			serializer.endTag("", "messages");
			serializer.endDocument();
			return writer.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
    
	static void loadFeed(ParserType type) {
		try {
			Log.i("AndroidNews", "ParserType=" + type.name());
			FeedParser parser = FeedParserFactory.getParser(type);
			long start = System.currentTimeMillis();
			messages = parser.parse();
			long duration = System.currentTimeMillis() - start;
			Log.i("AndroidNews", "Parser duration=" + duration);
			String xml = writeXml();
			Log.i("AndroidNews", xml);
			List<String> titles = new ArrayList<String>(messages.size());
			String msgDate = null;
			for (Message msg : messages) {
				titles.add(msg.getTitle());
				msgDate = msg.getDate();
			}
	
		
			
			
			//if for the first time there is no data in database then return false and add values
			//otherwise if data exist in databse, inside checkDatabaseRecords there will be a check if titles exist in database. 
			//if titles updated then they will add in database
			
			
			if (checkDatabaseRecords(msgDate, titles) == false) {

				DescriptionActivity.RssTitleAddToDatabase(titles);
			}
			
			//put database value in listview
			
			
		} catch (Throwable t) {
			Log.e("AndroidNews", t.getMessage(), t);
		}
	}
	
	@SuppressLint("NewApi")
	static
	 boolean checkDatabaseRecords(String msgDate, List<String> titles)
			throws ParseException {
		
		
		
	
		// TODO Auto-generated method stub
List<String> dbcheckList=new ArrayList<String>();
dbcheckList=DescriptionActivity.getTitlesfromDatabse();
String dbString=dbcheckList.toString();

		// TODO Auto-generated method stub
Calendar c = Calendar.getInstance();

SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
String formattedDateInsert = df.format(c.getTime());
ContentValues values = new ContentValues();

		Cursor c1 = mydb.rawQuery("SELECT * FROM " + TABLE, null);
		if (c1 != null && c1.getCount() != 0) {
			
			for(int i=0;i<titles.size();i++){
			
				if(!dbString.contains(titles.get(i))){
					
					
				value.add(titles.get(i));
				notifyboolean=true;
						values.put("TitleName", titles.get(i).toString());
						
						values.put("DateRSS", formattedDateInsert);
						
						mydb.insertWithOnConflict(TABLE, null, values, 1);

				}
				}
				
				
			
		

			return true;
		}

		else {
		
			return false;
		}

	}

	@SuppressLint("NewApi")
	private  void showNotification(String value) {
		// TODO Auto-generated method stub
		NotificationManager notificationManager =
			    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
			
			CharSequence notiText = "New Feed: "+value;
			long meow = System.currentTimeMillis();

			Notification notification = new Notification(R.drawable.ic_launcher, notiText, meow);

			Context context = getApplicationContext();
			CharSequence contentTitle = "Feed Alert";
			CharSequence contentText = value;
			Intent notificationIntent = new Intent(this, DescriptionActivity.class);
			PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

			notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);

			int SERVER_DATA_RECEIVED = 1;
			notificationManager.notify(SERVER_DATA_RECEIVED, notification);
		
		
	}


	
	//@SuppressLint("NewApi")
	//@Override
	/*protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		 Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
	        Log.d(TAG, "onStart");
	        Toast.makeText(this, "Congrats! MyService Created", Toast.LENGTH_LONG).show();
	        Log.d(TAG, "onCreate");
	        mydb = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE, null);
	        loadFeed(ParserType.SAX);
	       if(notifyboolean==true){
	        showNotification(value);
	       }
	}
    
    */
    
}