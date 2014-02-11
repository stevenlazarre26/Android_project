package com.example.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TextView tv;
	private EditText et;


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		final Button bt=(Button) findViewById(R.id.show); 
		et = (EditText) findViewById(R.id.input_text);
	        tv = (TextView) findViewById(R.id.output_text);
	  
	     et.addTextChangedListener(new TextWatcher(){
				@Override
				public void afterTextChanged(Editable s) {

				}
				@Override
				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {

				}
				@Override
				public void onTextChanged(CharSequence s, int start, int before,
						int count) {
					tv.setText(s);
					tv.setVisibility(View.INVISIBLE);
				}});
	      
	     bt.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v){
                
                tv.setVisibility(View.VISIBLE);

                }
	         });

	        
	      
}

}
    

	            
	        
