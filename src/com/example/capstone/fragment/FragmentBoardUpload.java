package com.example.capstone.fragment;

import info.androidhive.slidingmenu.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.capstone.CapstoneApplication;
import com.example.capstone.helper.BoardHelper;
import com.example.capstone.helper.PrefHelper;
import com.example.capstone.interfaces.EntityCallback;
import com.example.capstone.model.BoardModel;

public class FragmentBoardUpload extends Fragment {
	
	ImageButton ok;
	ImageButton cancel;
	EditText title;
	EditText content;
	BoardHelper boardHelper;
	PrefHelper prefHelper;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_board_upload, container, false);
		
		boardHelper = CapstoneApplication.getGlobalApplicationContext().getBoardHelper();
		prefHelper = CapstoneApplication.getGlobalApplicationContext().getPrefHelper();
		findComponent(view);
		
		bindEvents();
		
		return view;
	}
	

	private void findComponent(View view) {
		ok = (ImageButton) view.findViewById(R.id.board_upload_ok);
		cancel = (ImageButton) view.findViewById(R.id.board_upload_cancel);
		title = (EditText) view.findViewById(R.id.board_upload_title);
		content = (EditText) view.findViewById(R.id.board_upload_content);
	}
	
	private void bindEvents() {
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				BoardModel board = new BoardModel();
				board.setTitle(title.getText().toString());
				board.setContent(content.getText().toString());
				board.setWhoMade(prefHelper.getString(BoardModel.WHO_MADE));
				board.setWhoMadeId(prefHelper.getString(BoardModel.WHO_MADE_ID));
				board.setType(BoardModel.BOARD);
				board.setRefId(BoardModel.ROOT_REF_ID);
				
				CapstoneApplication.getGlobalApplicationContext().showProgressDialog(getActivity());
				boardHelper.insert(FragmentBoardUpload.this, board, new EntityCallback<BoardModel>() {
					
					@Override
					public void onCompleted(BoardModel entity) {
						// TODO Auto-generated method stub
						CapstoneApplication.getGlobalApplicationContext().dismissProgressDialog();
						CapstoneApplication.getGlobalApplicationContext().setBoard(entity);
						getActivity().finish();
					}
				});
			}
		});
		
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getActivity().finish();
			}
		});
		
		title.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				String reply = s.toString().trim();
				ok.setEnabled(reply.length() > 0);
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}
	
}
