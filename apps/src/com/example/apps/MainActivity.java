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
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.action_settings:
Intent i= new Intent (MainActivity.this,Prefs.class);
startActivity(i);			
break;
		}
		return false;

	}
}