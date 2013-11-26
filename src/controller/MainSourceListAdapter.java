package controller;

import com.zenin.cutegirl.PagePhotoActivity;

import model.APIs;
import model.MainSourceListItem;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class MainSourceListAdapter extends ArrayAdapter<MainSourceListItem> implements OnItemClickListener {
	
	Context context;
	public MainSourceListAdapter(Context context) {
		super(context, 0);
		this.context = context;
	}
	
	public View getView(int position, View view, ViewGroup parent) {
		
		if (view == null) {
			view = LayoutInflater.from(getContext()).inflate(com.zenin.cutegirl.R.layout.source_list_item, null);
		}
		
		getItem(position).init(view, context);
		
		return view;
	}
	
	public void genSampleList() {
		this.add(new MainSourceListItem("KKU Cute Girl", "350697308288261", ""));
		this.add(new MainSourceListItem("CU Cute Girl", "420563797962229", ""));
		this.add(new MainSourceListItem("MU Cute Girl", "150227068428429", ""));
		this.add(new MainSourceListItem("ABAC Cute Girl", "347890078565697", ""));
		this.add(new MainSourceListItem("CMU Cute Girl", "106681086125750", ""));
		this.add(new MainSourceListItem("BU Cute Girl", "345627495457914", ""));
		this.add(new MainSourceListItem("TU Cute Girl", "235250013230189", ""));
		this.add(new MainSourceListItem("SU Cute Girl", "117985621656278", ""));
		this.add(new MainSourceListItem("SWU Cute Girl", "379684595390795", ""));
		this.add(new MainSourceListItem("MSU Cute Girl", "263687583699875", ""));
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		AsyncGraph task = new AsyncGraph() {
			@Override
			public void taskCompleted(String result) {
				Intent intent = new Intent(context, PagePhotoActivity.class);
				intent.putExtra("json", result);
				context.startActivity(intent);
			}
		};
		task.execute(APIs.URL.replace("PAGE_ID", ((MainSourceListItem) ((MainSourceListAdapter) arg0.getAdapter()).getItem(arg2)).URL ));
	}

}
