package com.example.capstone.adapter;

import info.androidhive.slidingmenu.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListviewContactAdapter extends BaseAdapter{
	
	LayoutInflater inflater;
	String[] categorya;
	Context mContext;
	int mListLayout;
	public String TAG = "listAdapter";
	public int listCount = 0;
	public int selectedPosition = -1;
	
	public ListviewContactAdapter(Context tContext, int listLayout, String[] tmpa) {
		mContext = tContext;
		mListLayout = listLayout;
		categorya = tmpa;
		inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if(categorya != null){
			listCount = categorya.length;
		}
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listCount;
	}
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null){
			convertView = inflater.inflate(mListLayout, parent, false);
		}
		final int positionInt = position;
		((TextView)convertView.findViewById(R.id.board_detail_title)).setText(categorya[position]);;
		
		ImageView selected = (ImageView) convertView.findViewById(R.id.reply_like_it);
	    if(selectedPosition == position){
	        selected.setVisibility(View.VISIBLE);
	    }else
	        selected.setVisibility(View.INVISIBLE);
		return convertView;
	}

}