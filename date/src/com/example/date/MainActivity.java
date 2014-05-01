package com.example.date;

import java.util.Calendar;
import java.util.Date;




import com.example.app.R;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		Date currentDateTimeString = new Date();

		// textView is the TextView view that should display it
	
		TextView tv= (TextView) findViewById(R.id.textView1);
		tv.setText((CharSequence) currentDateTimeString);
	}

}
