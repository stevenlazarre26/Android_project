
package com.example.app;

import com.example.app.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;




public class splash extends Activity  {
	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_splash);
	//PreferenceManager.setDefaultValues(this, R.xml.settings, false);
	
	
	
    Thread timer = new Thread()
    {
      public void run()
       {
        try{
        sleep(3000);	
        }
        catch(InterruptedException e){
        	e.printStackTrace();
        }
        finally {
        	Intent intent= new Intent("com.example.app.MainActivity");
        	startActivity(intent);
        }
        }
        };
        timer.start();
	}


	


	
}
