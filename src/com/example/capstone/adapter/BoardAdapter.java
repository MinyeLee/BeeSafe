package com.example.capstone.adapter;

import info.androidhive.slidingmenu.R;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.capstone.model.BoardModel;

public class BoardAdapter extends ArrayAdapter<BoardModel> {
	private Context context;
	private Fragment fragment;
	
	public BoardAdapter(Context context, Fragment frag) {
		super(context, 0);
		this.context = context;
		this.fragment = frag;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.adapter_layout_board, parent, false);
		}

		BoardModel board = getItem(position);
		if (board != null) {
			/*
			 * Find UI component
			 */
			TextView title = (TextView) view.findViewById(R.id.reply_content);
			TextView whoMade = (TextView) view.findViewById(R.id.reply_who_made);
			TextView createAt = (TextView) view.findViewById(R.id.reply_create_date);
			TextView likeCount = (TextView) view.findViewById(R.id.reply_like_count);
			TextView replyCount = (TextView) view.findViewById(R.id.reply_count);
			
			String titleStr = board.getTitle();
			if (titleStr.length() > 20) {
				titleStr = titleStr.substring(0, 18) + "...";
			}
			title.setText(titleStr);
			whoMade.setText("[by "+ board.getWhoMade() + "]");
			createAt.setText(board.getCreateDateTime().toPrettyDate());
			likeCount.setText(String.valueOf(board.getLikeCount()));
			replyCount.setText(String.valueOf(board.getReplyCount()));
		}

		return view;
	}

}
