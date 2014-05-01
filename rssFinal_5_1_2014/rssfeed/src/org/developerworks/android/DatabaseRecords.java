package org.developerworks.android;




import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class DatabaseRecords extends Activity {
ListView myList;
Button back;
private static String DBNAME = "RSS.db";    // THIS IS THE SQLITE DATABASE FILE NAME.
static String TABLE = "RSSTABLE5"; 
static SQLiteDatabase mydb;
ArrayList<String> dbList = new ArrayList<String>();
 static ArrayAdapter<String> adapter ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_database_records);
		 mydb = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE,null);
		Intent getVal=new Intent();
	
	
		  myList = (ListView) findViewById(R.id.listViewDB);
		  
		  
		  back = (Button) findViewById(R.id.btnBack);
		  
		  back.setOnClickListener(new OnClickListener() {

	            @Override
	            public void onClick(View view) {
	                  Intent intent=new Intent();
	        	     setResult(1, intent);
	                 finish();
	                
	            }
	  });
		  

		  
	
		Cursor  c1  = mydb.rawQuery("SELECT * FROM "+  TABLE, null);
		  if (c1 != null &&c1.getCount() != 0) {
		   if (c1.moveToFirst()) {
		    do {
		   
		 
		    
		      dbList.add("Title: "+c1.getString(c1
		    	       .getColumnIndex("TitleName"))+"\nDate: "+c1.getString(c1
				    	       .getColumnIndex("DateRSS")));
		      
		     
		    	 
		 
		    } while (c1.moveToNext());
		  
		  }
	}
		 
		  List<String> dbList2 = new ArrayList<String>();
		  try {
			
			  checkRecentDateFromDatabase();
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  dbList2=DescriptionActivity.  getTitlesfromDatabse();
		  adapter= new ArrayAdapter<String>(this,
			        android.R.layout.simple_list_item_1, dbList2);
		 myList.setAdapter(adapter);
		 adapter.notifyDataSetChanged();
			
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.database_records, menu);
		return true;
	}
	static void checkRecentDateFromDatabase()
			throws ParseException {
		// TODO Auto-generated method stub

		Calendar c = Calendar.getInstance();

		//SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		//String dateServ = df.format();
		//DateFormat inputFormat = new SimpleDateFormat("dd MM yyyy");

		Date dateServer = c.getTime();
		//Date dateServer = inputFormat.parse("29/05/2014");
		
	
		String formatted2 = null;

	

		Cursor c1 = mydb.rawQuery("SELECT * FROM " + TABLE, null);
		if (c1 != null && c1.getCount() != 0) {
			if (c1.moveToFirst()) {
				do {

					formatted2 = (c1.getString(c1.getColumnIndex("DateRSS")));

					// DateFormat outputFormat1 = new
					// SimpleDateFormat("dd MM yyyy");
					DateFormat inputFormat1 = new SimpleDateFormat(
							"dd-MMM-yyyy");

					Date dateDB = inputFormat1.parse(formatted2);

					try {

						if (dateDB.before(dateServer)) {

							SimpleDateFormat outputFormat1 = new SimpleDateFormat(
									"dd-MM-yyyy");

							String formattedDate1 = outputFormat1
									.format(dateDB);

							mydb.delete( TABLE, " ID" + "= " + c1.getPosition(), null);
						
				

						}
					} catch (Exception e) {

						String exception = "" + e;
					}

				} while (c1.moveToNext());

			}
		}

		
	

	}

}
