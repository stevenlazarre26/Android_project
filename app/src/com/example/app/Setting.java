package com.example.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.CheckBox;
import com.example.app.R;

public class Setting extends PreferenceActivity{
	CheckBox cb;
	CheckBox cb2;
	SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
		
		
		//sp= PreferenceManager.getDefaultSharedPreferences(this);
		//  cb=(CheckBox)findViewById(R.id.cbOption);
			//cb.setOnCheckedChangeListener(this);
			 //cb2=(CheckBox)findViewById(R.id.cbOption2);
				//cb2.setOnCheckedChangeListener(this);
				//cb.setChecked(sp.getBoolean("checked",cb.isChecked()));
				//cb2.setChecked(sp.getBoolean("checked",cb2.isChecked()));
				
	
	}
	
	
/*	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		
		if(cb.isChecked()==true){
			//savePrefs("CHECKBOX",cb.isChecked());
			Intent sintent= new Intent("com.example.app.MainActivity");
        	startActivity(sintent);
        	finish();
			}  
		if(cb2.isChecked()==true){
			Intent sintent= new Intent("com.example.app.Activitytwoatn");
        	startActivity(sintent);
        	finish();
			}  
}*/
}
