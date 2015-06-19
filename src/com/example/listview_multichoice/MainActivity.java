package com.example.listview_multichoice;

import com.example.listview_singlechoice.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	ListView lv;

	String[] cars={"Ferrari","BMW","Mercedes","Audi","Lamborghini","Ford","Rolls-Royce","Porsche","Volkswagen"};
			

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.listView1);
		
		//simple_list_item_multiple_choice - will make Listview with Multichoice Option
		ArrayAdapter<String> ad = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_multiple_choice, cars);
			
		lv.setAdapter(ad);
		
		//Making Listview with MultiChoice(Checkbox)
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		
		lv.setOnItemClickListener(new OnItemClickListener() 
		{

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3)
			
			{				
				/** For Getting Selected items are **/
				
				String itemselected = "Selected items are :\n";
				
				for (int i = 0; i< lv.getCount(); i++)
				{
					
					if (lv.isItemChecked(i))
					{
						itemselected += lv.getItemAtPosition(i) +"\n";
					}
				}
			
				Toast.makeText(MainActivity.this, itemselected, Toast.LENGTH_LONG).show();
			}
		});
	}

	

}
