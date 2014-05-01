package org.developerworks.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

 public class MyReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			Toast.makeText(arg0, "BroadCast Received Started", Toast.LENGTH_LONG).show();
			// TODO Auto-generated method stub
		arg0.startService(new Intent(arg0, NotifyService.class));
		}
		 
		 
	 }
	