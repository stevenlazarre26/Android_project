package com.example.rssdatabase;

import java.util.List;
import com.example.rssdatabase.RSSitem;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class ListListener implements OnItemClickListener{
	List<RSSitem> listItems;
	Activity activity;
	
	public ListListener(List<RSSitem> listItems, Activity activity){
		this.listItems=listItems;
		this.activity=activity;
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int pos,
			long id) {
		
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(listItems.get(pos).getLink()));
		activity.startActivity(i);
	}

	
	
}
