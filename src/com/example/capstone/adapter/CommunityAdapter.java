package com.example.capstone.adapter;

import info.androidhive.slidingmenu.R;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.capstone.model.Community;

public class CommunityAdapter extends ArrayAdapter<Community> {
	private Context context;
	private TextView textView1;
	private TextView textView2;
	private TextView textView3;
	
	public CommunityAdapter(Context context, List<Community> list){
		super(context, 0, list);
		// TODO Auto-generated constructor stub
		this.context = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.adapter_layout_community, parent, false);
		}
		
		final Community community = this.getItem(position);
		
		if (community != null) {
			textView1 = (TextView)view.findViewById(R.id.my_first_text_view1);
			textView2 = (TextView)view.findViewById(R.id.my_first_text_view2);
			textView3 = (TextView)view.findViewById(R.id.my_first_text_view3);
			
			textView1.setText(community.getData1());
			textView2.setText(community.getData2());
			textView3.setText(community.getData3());
		}
		
		return view;
	}
	
	

}
