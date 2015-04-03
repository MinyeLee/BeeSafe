package com.example.capstone.adapter;

import info.androidhive.slidingmenu.R;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.capstone.CapstoneApplication;
import com.example.capstone.helper.BoardHelper;
import com.example.capstone.helper.PrefHelper;
import com.example.capstone.interfaces.EntityCallback;
import com.example.capstone.model.BoardModel;

public class BoardDetailReplyAdapter extends ArrayAdapter<BoardModel> {
	private Context context;
	private Fragment fragment;
	private BoardHelper boardHelper;
	private PrefHelper prefHelper;
	
	public BoardDetailReplyAdapter(Context context, Fragment frag) {
		super(context, 0);
		this.context = context;
		this.fragment = frag;
		boardHelper = CapstoneApplication.getGlobalApplicationContext().getBoardHelper();
		prefHelper = CapstoneApplication.getGlobalApplicationContext().getPrefHelper();
	}
	
	private boolean mIsLiking = false;
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.adapter_layout_board_detail_reply, parent, false);
		}

		final BoardModel reply = getItem(position);
		if (reply != null) {
			/*
			 * Find UI component
			 */
			TextView content = (TextView) view.findViewById(R.id.reply_content);
			TextView whoMade = (TextView) view.findViewById(R.id.reply_who_made);
			TextView createAt = (TextView) view.findViewById(R.id.reply_create_date);
			final TextView likeCount = (TextView) view.findViewById(R.id.reply_like_count);
			ImageButton likeIt = (ImageButton) view.findViewById(R.id.reply_like_it);
			
			content.setText(reply.getContent());
			whoMade.setText("[by "+ reply.getWhoMade() + "]");
			createAt.setText(reply.getCreateDateTime().toPrettyDate());
			likeCount.setText(String.valueOf(reply.getLikeCount()));
			likeIt.setTag(position);
			likeIt.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if (mIsLiking) return;
					mIsLiking = true;
					
					if (reply.getPrevLikeId() != null) {
						decreaseLikeCount(likeCount);
						
						boardHelper.delete(fragment, reply.getPrevLikeId(), new EntityCallback<Boolean>() {
							
							@Override
							public void onCompleted(Boolean entity) {
								// TODO Auto-generated method stub
								reply.setPrevLikeId(null);
								mIsLiking = false;
								
							}
						});
					} else {
						increaseLikeCount(likeCount);
						
						BoardModel board = new BoardModel();
						board.setRefId(reply.getId());
						board.setType(BoardModel.LIKE);
						
						board.setWhoMade(prefHelper.getString(BoardModel.WHO_MADE));
						board.setWhoMadeId(prefHelper.getString(BoardModel.WHO_MADE_ID));
						boardHelper.insert(fragment, board, new EntityCallback<BoardModel>() {
							
							@Override
							public void onCompleted(BoardModel entity) {
								// TODO Auto-generated method stub
								reply.setPrevLikeId(entity.getId());
								mIsLiking = false;
							}
						});
					}
				}
			});
			likeIt.setFocusable(false);
		}

		return view;
	}
	
	private void increaseLikeCount(TextView likeCount) {
		int likeCountInt = Integer.parseInt(likeCount.getText().toString());
		likeCountInt++;
		likeCount.setText(String.valueOf(likeCountInt));
	}
	private void decreaseLikeCount(TextView likeCount) {
		int likeCountInt = Integer.parseInt(likeCount.getText().toString());
		likeCountInt--;
		likeCount.setText(String.valueOf(likeCountInt));
	}
}
