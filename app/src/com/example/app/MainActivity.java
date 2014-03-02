package com.example.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import com.example.app.R;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		final Button bt = (Button) findViewById(R.id.show);

		bt.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent1 = new Intent("com.example.app.Activitytwo");
				startActivity(intent1);
			}
		});
	}

	@Override
	 public boolean onCreateOptionsMenu(Menu menu) {
	 super.onCreateOptionsMenu(menu); 
	 getMenuInflater().inflate(R.menu.main, menu);
	 return true;
	 
	 }
	 

public boolean onOptionItemSelected(MenuItem item) {
	if(item.getItemId()==R.id.action_settings){
		Intent intent = new Intent(this,Setting.class);
		startActivity(intent);
	}			
	
	return super.onOptionsItemSelected(item);

}
}