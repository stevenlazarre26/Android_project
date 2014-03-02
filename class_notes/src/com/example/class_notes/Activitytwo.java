
package com.example.class_notes;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import com.example.class_notes.R;


public class Activitytwo extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_two);
	
	  SharedPreferences getPrefs= PreferenceManager.getDefaultSharedPreferences(this);
      boolean check=getPrefs.getBoolean("checkbox2",false);
      if(check==true){
      	  setContentView(R.layout.activity_two2);
            
      final	Button btn= (Button)findViewById(R.id.shws); 
        
	      
	     btn.setOnClickListener(new Button.OnClickListener() {
               public void onClick(View v){
               
               	Intent intent1= new Intent("com.example.class_notes.Activitythree");
               	startActivity(intent1);
              
               }
	         });
      	
      }
      else{
    	final  Button btn= (Button)findViewById(R.id.shows); 
    	     
	      
 	     btn.setOnClickListener(new Button.OnClickListener() {
                 public void onClick(View v){
                 
                 	Intent intent1= new Intent("com.example.class_notes.Activitythree");
                 	startActivity(intent1);
                
                 }
 	         });
  }
	  
	

}
}
