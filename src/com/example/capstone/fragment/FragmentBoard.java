package com.example.capstone.fragment;

import info.androidhive.slidingmenu.R;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.capstone.CapstoneApplication;
import com.example.capstone.activities.BoardActivity;
import com.example.capstone.adapter.BoardAdapter;
import com.example.capstone.helper.BoardHelper;
import com.example.capstone.helper.ItAlertDialog;
import com.example.capstone.helper.PrefHelper;
import com.example.capstone.interfaces.DialogCallback;
import com.example.capstone.interfaces.EntityCallback;
import com.example.capstone.interfaces.ListCallback;
import com.example.capstone.model.BoardModel;

public class FragmentBoard extends Fragment {
	
	ListView listView;
	BoardAdapter adapter;
	ImageButton uploadBtn;
	private String BOARD_DIALOG = "BOARD_DIALOG";
	BoardHelper boardHelper;
	PrefHelper prefHelper;
	private boolean mIsAdding = false;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_board, container, false);
		
		boardHelper = CapstoneApplication.getGlobalApplicationContext().getBoardHelper();
		prefHelper = CapstoneApplication.getGlobalApplicationContext().getPrefHelper();
		
		findComponent(view);
		bindEvents();
		showDialog();
		getBoards();
		
		return view;
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		BoardModel board = CapstoneApplication.getGlobalApplicationContext().getBoard();
		if (board != null) {
			adapter.insert(board, 0);
			CapstoneApplication.getGlobalApplicationContext().setBoard(null);
		}
	}
	
	private void bindEvents() {
		// TODO Auto-generated method stub
		
		this.uploadBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), BoardActivity.class);
				intent.putExtra("page", "upload");
				startActivity(intent);
			}
		});
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				BoardModel board = adapter.getItem(position);
				Intent intent = new Intent(getActivity(), BoardActivity.class);
				intent.putExtra("page", "detail");
				intent.putExtra("board", board);
				startActivity(intent);
			}
		});
		
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				final BoardModel board = adapter.getItem(position);
				if (!board.isMine()) return true;
				ItAlertDialog dialog = ItAlertDialog.newInstance("Do you want to delete?", null, null, true);
				dialog.setCallback(new DialogCallback() {

					@Override
					public void doPositiveThing(Bundle bundle) {
						CapstoneApplication.getGlobalApplicationContext().showProgressDialog(getActivity());
						boardHelper.delete(FragmentBoard.this, board.getId(), new EntityCallback<Boolean>() {
							
							@Override
							public void onCompleted(Boolean entity) {
								// TODO Auto-generated method stub
								adapter.remove(board);
								CapstoneApplication.getGlobalApplicationContext().dismissProgressDialog();
							}
						});
					}
					@Override
					public void doNegativeThing(Bundle bundle) {
					}
				});
				dialog.show(FragmentBoard.this.getFragmentManager(), "DialogKey");
				return true;
			}
		});
		
		
		listView.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				// TODO Auto-generated method stub
				
//				 if (view.getLastVisiblePosition()==(totalItemCount-1)){
				if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 0) {
					if (stop) return;
					getBoards();
				} else {
		        }
			}
		});
		
	}
	
	private boolean stop = false;


	private void findComponent(View view) {
		this.listView = (ListView) view.findViewById(R.id.board_list_view);
		this.uploadBtn = (ImageButton) view.findViewById(R.id.board_upload_button);
		
		adapter = new BoardAdapter(this.getActivity(), this);
		this.listView.setAdapter(adapter);
		
		
	}
	
	private void showDialog() {
		final PrefHelper prefHelper = CapstoneApplication.getGlobalApplicationContext().getPrefHelper();
		boolean isChecked = prefHelper.getBoolean(BOARD_DIALOG);
		if (isChecked) return;
		String message = "[재난 대비 지식 공유 게시판]\n\n"
				+ "* 재난 발생 시 대처법 등 궁금한 사항들을 물어보아요~\n"
				+ " * 자신이 알고 있거나 도움을 줄수 있는 경우, 여러분의 지식을 나누어 주세요.";

		ItAlertDialog dialog = ItAlertDialog.newInstance(message, null, null, false);
		dialog.setCallback(new DialogCallback() {

			@Override
			public void doPositiveThing(Bundle bundle) {
				prefHelper.put(BOARD_DIALOG, true);
			}
			@Override
			public void doNegativeThing(Bundle bundle) {
				// Do nothing
			}
		});
		dialog.show(this.getFragmentManager(), "DialogKey");
	}
	
	private int page = 0;
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
//		stop = false;
//		page = 0;
//		this.adapter.clear();
//		getBoards();
	}
	private void getBoards() {
		// TODO Auto-generated method stub
		if (this.mIsAdding) return;
		
		this.mIsAdding = true;
		String userId = prefHelper.getString(BoardModel.WHO_MADE_ID);
		CapstoneApplication.getGlobalApplicationContext().showProgressDialog(getActivity());
		boardHelper.list(this, page, userId, BoardModel.BOARD, BoardModel.ROOT_REF_ID, new ListCallback<BoardModel>() {
			
			@Override
			public void onCompleted(List<BoardModel> list, int count) {
				// TODO Auto-generated method stub
				adapter.addAll(list);
				if (list.size() < 15) {
					stop = true;
				}
				page++;
				CapstoneApplication.getGlobalApplicationContext().dismissProgressDialog();
				mIsAdding = false;
			}
		});
	}
}
