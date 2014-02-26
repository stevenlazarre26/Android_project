package com.example.cmp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import com.example.cmp.R;


import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
        final Button bt=(Button) findViewById(R.id.show); 
     
	      
	     bt.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v){
                
                	Intent intent1= new Intent("com.example.cmp.Activitytwo");
                	startActivity(intent1);
               
                }
	         });

	}
}
    

	            
	        
