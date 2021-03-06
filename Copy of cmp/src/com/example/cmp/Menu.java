package com.example.cmp;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.cmp.R;
import android.*;

public class Menu extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
     
   
    @Override
  public boolean onCreateOptionsMenu(android.view.Menu menu)
    {
    	super.onCreateOptionsMenu(menu);
    	menu.add("Item1");
        menu.add("Item2");
        return true;
       
    }
    
    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
    * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
         
        switch (item.getItemId())
        {
    /*
        case R.id.menu_bookmark:
            // Single menu item is selected do something
            // Ex: launching new activity/screen or show alert message
            Toast.makeText(Menu.this, "Bookmark is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        case R.id.menu_save:
            Toast.makeText(Menu.this, "Save is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        case R.id.menu_search:
            Toast.makeText(Menu.this, "Search is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        case R.id.menu_share:
            Toast.makeText(Menu.this, "Share is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        case R.id.menu_delete:
            Toast.makeText(Menu.this, "Delete is Selected", Toast.LENGTH_SHORT).show();
            return true;
 */
        case R.id.menu_preferences:
            Toast.makeText(Menu.this, "Preferences is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        default:
            return super.onOptionsItemSelected(item);
        }
    }    
  
}