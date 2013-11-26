package model;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import android.util.Log;

public class APIs {
	
	public static final String URL = "https://graph.facebook.com/PAGE_ID/photos?fields=source";
	
	public static HttpClient httpClient;
	
	public APIs() {
		HttpParams params = new BasicHttpParams();
	    SchemeRegistry registry = new SchemeRegistry();
	    registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
	    registry.register(new Scheme("https", PlainSocketFactory.getSocketFactory(), 80));
	    ClientConnectionManager cm = new ThreadSafeClientConnManager(params, registry);
	    httpClient = new DefaultHttpClient(cm,params);
	    
	}
	
	public static void exception(Exception e) {
		Log.e("ERROR", e.toString());
	}
	
	public static void print(String msg) {
		Log.e("PRINT", msg);
	}

}