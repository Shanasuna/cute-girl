package com.zenin.cutegirl;

import com.zenin.cutegirl.R;

import controller.PagePhotoListAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.widget.GridView;

public class PagePhotoActivity extends Activity {
	
	GridView gridViewPagePhoto;
	PagePhotoListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page_photo);
		
		gridViewPagePhoto = (GridView) findViewById(R.id.gridViewPagePhoto);
		adapter = new PagePhotoListAdapter(this);
		adapter.init(getIntent().getStringExtra("json"));
		gridViewPagePhoto.setAdapter(adapter);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.page_photo, menu);
//		return true;
//	}

}
