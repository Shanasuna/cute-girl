package model;

import com.zenin.cutegirl.R;

import controller.AsyncSetIMG;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

public class PagePhotoGridItem {
	
	String title;
	public String URL;
	String imgURL;
	
	public PagePhotoGridItem(String title, String url, String imgURL) {
		this.title = title;
		this.URL = url;
		this.imgURL = imgURL;
	}
	
	public void init(View view, Context context) {
		ImageView img = (ImageView) view.findViewById(R.id.imageViewPagePhotoGridItem);
		new AsyncSetIMG(img).execute(this.imgURL);
	}

}