
package com.example.cmp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.cmp.R;


public class Activitytwo extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_two);
	
	
	  Button btn= (Button)findViewById(R.id.shows); 
     
	      
	     btn.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v){
                
                	Intent intent1= new Intent("com.example.cmp.Activitythree");
                	startActivity(intent1);
               
                }
	         });
	

}
}
