package com.example.calculator;

import com.example.calculator.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;




public class Splash extends Activity {
	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_splash);

	
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
        	Intent intent= new Intent("com.example.calculator.Main");
        	startActivity(intent);
        }
        }
        };
        timer.start();
	}


	


	
}

