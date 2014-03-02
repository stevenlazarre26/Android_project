package com.example.apps;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import com.example.apps.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 super.onCreateOptionsMenu(menu); 
		 //menu.add("Settings") ;
		// .setIntent(new Intent("com.example.Prefs")); 
		
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		 return true;
		
	}

	public boolean onOptionItemSelected(MenuItem item) {
		if(item.getItemId()!=R.id.action_settings){
Intent i= new Intent ("com.example.Prefs");
startActivity(i);			
		}
		return super.onOptionsItemSelected(item);

	}

}
	