package com.example.class_notes;

import com.example.class_notes.R;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        SharedPreferences getPrefs= PreferenceManager.getDefaultSharedPreferences(this);
        boolean check=getPrefs.getBoolean("checkbox1",false);
        if(check==true){
        	  setContentView(R.layout.activity_main2);
              
        	final Button btn = (Button) findViewById(R.id.shw);

     		btn.setOnClickListener(new Button.OnClickListener() {
     			public void onClick(View v) {
     				Intent intent1 = new Intent("com.example.class_notes.Activitytwo");
     				startActivity(intent1);
     			}
     		});
         
        	
        }
        else{
        final Button bt = (Button) findViewById(R.id.show);

		bt.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent1 = new Intent("com.example.class_notes.Activitytwo");
				startActivity(intent1);
			}
		});
    
    }
    }
     
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(this, "menu option selected", Toast.LENGTH_SHORT).show();
		if(item.getItemId() == R.id.action_settings){
			Intent intent = new Intent(this,SettingsActivity.class);
			startActivity(intent);
		}
		if(item.getItemId() == R.id.exit){
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
    
}