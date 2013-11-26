package com.zenin.cutegirl;

import model.APIs;

import com.zenin.cutegirl.R;

import controller.MainSourceListAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	ListView listViewSource;
	MainSourceListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		new APIs();
		
		listViewSource = (ListView) findViewById(R.id.listViewMainSource);
		adapter = new MainSourceListAdapter(this);
		adapter.genSampleList();
		listViewSource.setAdapter(adapter);
		listViewSource.setOnItemClickListener(adapter);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

}
