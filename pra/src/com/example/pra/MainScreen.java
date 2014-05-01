package com.example.pra;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainScreen extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.main_screen);
		
		final Button bt= (Button) findViewById(R.id.btn1);
		bt.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v) {
				Intent intent1 = new Intent(MainScreen.this, Main.class);
				startActivity(intent1);
			}
		});
		
	}
	

}
