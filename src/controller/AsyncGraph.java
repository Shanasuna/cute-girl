package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import model.APIs;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import android.os.AsyncTask;
import android.util.Log;

public abstract class AsyncGraph extends AsyncTask<String, Void, String> {
    
    public AsyncGraph() {
    	
    }

    protected String doInBackground(String... urls) {
		
		String result = "";
		for (String url : urls) {
			HttpGet httpGet = new HttpGet(url);
			try {
				HttpResponse execute = APIs.httpClient.execute(httpGet);
				InputStream content = execute.getEntity().getContent();
				BufferedReader buffer = new BufferedReader(
						new InputStreamReader(content));
				String s = "";
				while ((s = buffer.readLine()) != null) {
					result += s;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

    protected void onPostExecute(String result) {
    	Log.e("GET_RESULT", result);
    	taskCompleted(result);
    }
    
    public abstract void taskCompleted(String result);
}
