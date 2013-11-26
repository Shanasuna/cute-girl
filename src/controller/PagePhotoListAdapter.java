package controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.APIs;
import model.PagePhotoGridItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class PagePhotoListAdapter extends ArrayAdapter<PagePhotoGridItem> implements OnItemClickListener {
	
	Context context;
	public PagePhotoListAdapter(Context context) {
		super(context, 0);
		this.context = context;
	}
	
	public View getView(int position, View view, ViewGroup parent) {
		
		if (view == null) {
			view = LayoutInflater.from(getContext()).inflate(com.zenin.cutegirl.R.layout.page_photo_grid_item, null);
		}
		
		getItem(position).init(view, context);
		
		return view;
	}
	
	public void init(String result) {
		try {
			JSONObject json = new JSONObject(result);
			JSONArray data = json.getJSONArray("data");
			for (int i = 0; i < data.length(); i++) {
				JSONObject item = data.getJSONObject(i);
				this.add(new PagePhotoGridItem("", "", item.getString("source")));
//				APIs.print(item.getString("source"));
			}
		} catch (JSONException e) {
			APIs.exception(e);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//		AsyncGraph task = new AsyncGraph() {
//			@Override
//			public void taskCompleted(String result) {
//				context.startActivity(new Intent(context, PagePhotoActivity.class));
//			}
//		};
//		task.execute(APIs.URL.replace("PAGE_ID", ((MainSourceListItem) ((MainSourceListAdapter) arg0.getAdapter()).getItem(arg2)).URL ));
	}

}
