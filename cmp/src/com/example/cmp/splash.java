
package com.example.cmp;

import com.example.cmp.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;




public class splash extends Activity {
	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_splash);

	
    Thread timer = new Thread()
    {
      public void run()
       {
        try{
        sleep(5000);	
        }
        catch(InterruptedException e){
        	e.printStackTrace();
        }
        finally {
        	Intent intent= new Intent("com.example.cmp.MainActivity");
        	startActivity(intent);
        }
        }
        };
        timer.start();
	}


	


	
}
