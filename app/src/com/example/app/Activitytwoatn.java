
package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.app.R;


public class Activitytwoatn extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_twoatn);
	
	
	  Button btn11= (Button)findViewById(R.id.showss); 
     
	      
	     btn11.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v){
                
                	Intent intent34= new Intent("com.example.app.Activitythree");
                	startActivity(intent34);
               
                }
	         });
	

}
}
