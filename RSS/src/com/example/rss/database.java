package com.example.rss;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database{

	public static final String KEY_NAME="Rss Title";
	public static final String KEY_ROWID="_id";
	public static final String KEY_Date="Dates";
	private static final int DATABASE_VERSION=1;
	private static final String DATABASE_NAME="Hot";
	private static final String DATABASE_TABLE="TABLE";
	private databasehelp ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	private static class databasehelp extends SQLiteOpenHelper{
	public databasehelp(Context context){
		
		super(context,DATABASE_NAME , null, DATABASE_VERSION);
		
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL("CREATE TBALE " + DATABASE_TABLE + " (" +
				KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				KEY_NAME + " TEXT NOT NULL, " +
				KEY_Date + " TEXT NOT NULL);"
				
			);	
	}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}
}
	
	public database(Context c){
		ourContext = c;
	}
	
	public database open(){
		ourHelper= new databasehelp(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}
	public void close(){
		ourHelper.close();
	}
	public long createEntry(String title){
		ContentValues cv= new ContentValues();
		cv.put(KEY_NAME,title);
		return ourDatabase.insert(DATABASE_TABLE,null,cv);
	}
}

