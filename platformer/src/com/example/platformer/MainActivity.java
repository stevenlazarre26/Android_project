package com.example.platformer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.activity_main);
		
		final Button bt=(Button)findViewById(R.id.btn1);
	
		bt.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
				Intent intent1 = new Intent("com.example.platformer.Game");
				startActivity(intent1);
			}
		});
		
		final Button bt2=(Button)findViewById(R.id.btn2);
		
		bt2.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
				Intent intent2 = new Intent(MainActivity.this,Help.class);
				startActivity(intent2);
			}
		});	

		final Button bt3=(Button)findViewById(R.id.btn3);
		
		bt3.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
				finish();
			}
		});	
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
