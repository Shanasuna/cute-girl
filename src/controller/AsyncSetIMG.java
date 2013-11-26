package controller;

import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class AsyncSetIMG extends AsyncTask<String, Void, Bitmap> {
	ImageView bmImage;
	Bitmap bitmap;
	ProgressBar loadingBar;
	
	public AsyncSetIMG(ImageView bmImage) {
		this.bmImage = bmImage;
		this.loadingBar = null;
	}

	public AsyncSetIMG(ImageView bmImage, ProgressBar loadingBar) {
		this.bmImage = bmImage;
		this.loadingBar = loadingBar;
	}

	protected Bitmap doInBackground(String... urls) {
		String urldisplay = urls[0];
		try {
            InputStream input = new java.net.URL(urldisplay).openStream();
            BitmapFactory.Options options = new BitmapFactory.Options();
//			options.inJustDecodeBounds = true;
//			BitmapFactory.decodeStream(input, null, options);
//			options.inSampleSize = calculateInSampleSize(options, 1024, 1024);
//			options.inJustDecodeBounds = false;
//			input = new java.net.URL(urldisplay).openStream();
            bitmap = BitmapFactory.decodeStream(input, null, options);
		} catch (Exception e) {
			Log.e("Error", e.toString()+"");
		}
		return null;
	}

	protected void onPostExecute(Bitmap result) {
		Handler refresh = new Handler(Looper.getMainLooper());
		refresh.post(new Runnable() {
		    public void run()
		    {
				try {
					bmImage.setImageBitmap(bitmap);
					if (loadingBar != null) {
						loadingBar.setVisibility(View.GONE);
					}
				} catch (Exception e) {
					Log.e("ERROR in SetIMG", e.toString()+"");
				}
		    }
		});
	}
	
	protected int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
		int height = options.outHeight;
		int width = options.outWidth;
		int inSampleSize = 1;
		if (height > reqHeight || width > reqWidth) {
			if (width < height) {
				inSampleSize = Math.round((float) height / (float) reqHeight);
			} else {
				inSampleSize = Math.round((float) width / (float) reqWidth);
			}
		}
		return inSampleSize;
	}
}
