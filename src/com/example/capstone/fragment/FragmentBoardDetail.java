package com.example.capstone.fragment;

import info.androidhive.slidingmenu.R;

import java.util.Collections;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.capstone.CapstoneApplication;
import com.example.capstone.adapter.BoardDetailReplyAdapter;
import com.example.capstone.helper.BoardHelper;
import com.example.capstone.helper.ItAlertDialog;
import com.example.capstone.helper.PrefHelper;
import com.example.capstone.interfaces.DialogCallback;
import com.example.capstone.interfaces.EntityCallback;
import com.example.capstone.interfaces.ListCallback;
import com.example.capstone.model.BoardModel;

public class FragmentBoardDetail extends Fragment {
	
	TextView title;
	TextView createDate;
	TextView whoMade;
	TextView content;
	ImageButton likeIt;
	TextView likeCount;
	Button replyBtn;
	EditText replyContent;
	ListView replyList;
	BoardDetailReplyAdapter adapter;
	BoardHelper boardHelper;
	PrefHelper prefHelper;
	BoardModel mBoard;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_board_detail, container, false);
		
		boardHelper = CapstoneApplication.getGlobalApplicationContext().getBoardHelper();
		prefHelper = CapstoneApplication.getGlobalApplicationContext().getPrefHelper();
		findComponent(view);
		bindEvents();
		getReplyList();
		
		return view;
	}
	
	private boolean mIsAdding = false;
	private int page = 0;
	private void getReplyList() {
		// TODO Auto-generated method stub
		if (this.mIsAdding) return;
		this.mIsAdding = true;
		adapter.clear();
		String userId = prefHelper.getString(BoardModel.WHO_MADE_ID);
		CapstoneApplication.getGlobalApplicationContext().showProgressDialog(getActivity());
		boardHelper.list(this, page, userId, BoardModel.REPLY, mBoard.getId(), new ListCallback<BoardModel>() {
			
			@Override
			public void onCompleted(List<BoardModel> list, int count) {
				// TODO Auto-generated method stub
				Collections.reverse(list);
				adapter.addAll(list);
				page++;
				CapstoneApplication.getGlobalApplicationContext().dismissProgressDialog();
				mIsAdding = false;
			}
		});
	}
	
	private boolean mIsLiking = false;

	private void bindEvents() {
		// TODO Auto-generated method stub
		likeIt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mIsLiking) return;
				mIsLiking = true;
				
				if (mBoard.getPrevLikeId() != null) {
					decreaseLikeCount();
					
					boardHelper.delete(FragmentBoardDetail.this, mBoard.getPrevLikeId(), new EntityCallback<Boolean>() {
						
						@Override
						public void onCompleted(Boolean entity) {
							// TODO Auto-generated method stub
							mBoard.setPrevLikeId(null);
							mIsLiking = false;
							
						}
					});
				} else {
					increaseLikeCount();
					
					BoardModel board = new BoardModel();
					board.setType(BoardModel.LIKE);
					board.setRefId(mBoard.getId());
					board.setWhoMade(prefHelper.getString(BoardModel.WHO_MADE));
					board.setWhoMadeId(prefHelper.getString(BoardModel.WHO_MADE_ID));
					boardHelper.insert(FragmentBoardDetail.this, board, new EntityCallback<BoardModel>() {
						
						@Override
						public void onCompleted(BoardModel entity) {
							// TODO Auto-generated method stub
							mBoard.setPrevLikeId(entity.getId());
							mIsLiking = false;
						}
					});
				}
			}
		});
		
		replyBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				BoardModel board = new BoardModel();
				board.setContent(replyContent.getText().toString());
				board.setType(BoardModel.REPLY);
				board.setRefId(mBoard.getId());
				board.setWhoMade(prefHelper.getString(BoardModel.WHO_MADE));
				board.setWhoMadeId(prefHelper.getString(BoardModel.WHO_MADE_ID));
				CapstoneApplication.getGlobalApplicationContext().showProgressDialog(getActivity());
				boardHelper.insert(FragmentBoardDetail.this, board, new EntityCallback<BoardModel>() {
					
					@Override
					public void onCompleted(BoardModel entity) {
						// TODO Auto-generated method stub
						replyContent.setText("");
//						getReplyList();
						adapter.add(entity);
						CapstoneApplication.getGlobalApplicationContext().dismissProgressDialog();
					}
				});
			}
		});
		
		replyContent.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				String reply = s.toString().trim();
				replyBtn.setEnabled(reply.length() > 0);
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
		
		replyList.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				position = position - 1;
				if (position < 0) return true;
				final BoardModel reply = adapter.getItem(position);
				if (!reply.isMine()) return true;
				ItAlertDialog dialog = ItAlertDialog.newInstance("Do you want to delete?", null, null, true);
				dialog.setCallback(new DialogCallback() {

					@Override
					public void doPositiveThing(Bundle bundle) {
						CapstoneApplication.getGlobalApplicationContext().showProgressDialog(getActivity());
						boardHelper.delete(FragmentBoardDetail.this, reply.getId(), new EntityCallback<Boolean>() {
							
							@Override
							public void onCompleted(Boolean entity) {
								// TODO Auto-generated method stub
								adapter.remove(reply);
								CapstoneApplication.getGlobalApplicationContext().dismissProgressDialog();
							}
						});
					}
					@Override
					public void doNegativeThing(Bundle bundle) {
					}
				});
				dialog.show(FragmentBoardDetail.this.getFragmentManager(), "DialogKey");
				return true;
			}
		});
		
	}

	private void findComponent(View view) {
		
		View header = getActivity().getLayoutInflater().inflate(R.layout.fragment_board_detail_header, null, false);
		
		
		// TODO Auto-generated method stub
		title = (TextView) header.findViewById(R.id.board_detail_title);
		createDate = (TextView) header.findViewById(R.id.board_detail_create_date);
		whoMade = (TextView) header.findViewById(R.id.board_detail_who_made);
		content = (TextView) header.findViewById(R.id.board_detail_content);
		likeCount = (TextView) header.findViewById(R.id.board_detail_like_count);
		likeIt = (ImageButton) header.findViewById(R.id.board_detail_like_it_btn);
		replyBtn = (Button) header.findViewById(R.id.board_upload_ok);
		replyContent = (EditText) header.findViewById(R.id.add_reply_context);
		replyList = (ListView) view.findViewById(R.id.board_detail_reply_list);
		
		replyList.addHeaderView(header);
		
		adapter = new BoardDetailReplyAdapter(getActivity(), this);
		replyList.setAdapter(adapter);
		
		Intent intent = this.getActivity().getIntent();
		this.mBoard = intent.getExtras().getParcelable("board");
		title.setText(this.mBoard.getTitle());
		createDate.setText(this.mBoard.getCreateDateTime().toPrettyDateTime());
		whoMade.setText("[" + this.mBoard.getWhoMade() + "]");
		content.setText(this.mBoard.getContent());
		likeCount.setText(String.valueOf(this.mBoard.getLikeCount()));
		
	}
	
	private void increaseLikeCount() {
		int likeCountInt = Integer.parseInt(likeCount.getText().toString());
		likeCountInt++;
		likeCount.setText(String.valueOf(likeCountInt));
	}
	private void decreaseLikeCount() {
		int likeCountInt = Integer.parseInt(likeCount.getText().toString());
		likeCountInt--;
		likeCount.setText(String.valueOf(likeCountInt));
	}
}
