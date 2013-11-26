package model;

import com.zenin.cutegirl.R;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class MainSourceListItem {
	
	String title;
	public String URL;
	String imgURL;
	
	public MainSourceListItem(String title, String url, String imgURL) {
		this.title = title;
		this.URL = url;
		this.imgURL = imgURL;
	}
	
	public void init(View view, Context context) {
		TextView tvTitle = (TextView) view.findViewById(R.id.textViewSourceListItemTitle);
		tvTitle.setText(title);
	}

}