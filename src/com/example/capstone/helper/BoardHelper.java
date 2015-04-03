package com.example.capstone.helper;

import java.util.List;

import android.support.v4.app.Fragment;

import com.example.capstone.CapstoneApplication;
import com.example.capstone.interfaces.EntityCallback;
import com.example.capstone.interfaces.ListCallback;
import com.example.capstone.model.BoardException;
import com.example.capstone.model.BoardModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.microsoft.windowsazure.mobileservices.ApiJsonOperationCallback;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.mobileservices.ServiceFilterResponse;

import de.greenrobot.event.EventBus;

public class BoardHelper {
	
	private CapstoneApplication mApp;
	private MobileServiceClient mClient;
	
	private String LIST_BOARD = "list_board";
	private String INSERT_BOARD = "insert_board";
	private String GET_BOARD = "get_board";
	private String DELETE_BOARD = "delete_board";
	
	public BoardHelper() {
		mApp = CapstoneApplication.getGlobalApplicationContext();
		mClient = mApp.getMobileClient();
	}
	
	
	public void list(final Fragment fragment, int page, String userId, int type, String refId, final ListCallback<BoardModel> callback) {
		if(!mApp.isOnline()){
			EventBus.getDefault().post(new BoardException(fragment, BoardException.TYPE.NETWORK_UNAVAILABLE));
			return;
		}
		JsonObject jo = new JsonObject();
		jo.addProperty("page", page);
		jo.addProperty("userId", userId);
		jo.addProperty("type", type);
		jo.addProperty("refId", refId);

		mClient.invokeApi(LIST_BOARD, jo, new ApiJsonOperationCallback() {

			@Override
			public void onCompleted(JsonElement _json, Exception exception,
					ServiceFilterResponse response) {
				if (exception == null) {
					JsonElement json = _json.getAsJsonArray();
					List<BoardModel> list = new Gson().fromJson(json, new TypeToken<List<BoardModel>>(){}.getType());
					callback.onCompleted(list, list.size());
				} else {
					EventBus.getDefault().post(new BoardException(fragment, BoardException.TYPE.SERVER_ERROR));
				}
			}
		});
	}
	
	public void insert(final Fragment fragment, BoardModel board, final EntityCallback<BoardModel> callback) {
		if(!mApp.isOnline()){
			EventBus.getDefault().post(new BoardException(fragment, BoardException.TYPE.NETWORK_UNAVAILABLE));
			return;
		}
		
		JsonElement jo = board.toJson(); 

		mClient.invokeApi(INSERT_BOARD, jo, new ApiJsonOperationCallback() {

			@Override
			public void onCompleted(JsonElement json, Exception exception,
					ServiceFilterResponse response) {
				if (exception == null) {
					BoardModel b = new Gson().fromJson(json,BoardModel.class);
					callback.onCompleted(b);
				} else {
					EventBus.getDefault().post(new BoardException(fragment, BoardException.TYPE.SERVER_ERROR));
				}
			}
		});
	}
	
	public void get(final Fragment fragment, String id, final EntityCallback<BoardModel> callback) {
		if(!mApp.isOnline()){
			EventBus.getDefault().post(new BoardException(fragment, BoardException.TYPE.NETWORK_UNAVAILABLE));
			return;
		}
		
		JsonObject jo = new JsonObject();
		jo.addProperty("id", id);

		mClient.invokeApi(GET_BOARD, jo, new ApiJsonOperationCallback() {

			@Override
			public void onCompleted(JsonElement json, Exception exception,
					ServiceFilterResponse response) {
				if (exception == null) {
					BoardModel b = new Gson().fromJson(json,BoardModel.class);
					callback.onCompleted(b);
				} else {
					EventBus.getDefault().post(new BoardException(fragment, BoardException.TYPE.SERVER_ERROR));
				}
			}
		});
	}
	
	public void delete(final Fragment fragment, String id, final EntityCallback<Boolean> callback) {
		if(!mApp.isOnline()){
			EventBus.getDefault().post(new BoardException(fragment, BoardException.TYPE.NETWORK_UNAVAILABLE));
			return;
		}
		
		JsonObject jo = new JsonObject();
		jo.addProperty("id", id);

		mClient.invokeApi(DELETE_BOARD, jo, new ApiJsonOperationCallback() {

			@Override
			public void onCompleted(JsonElement json, Exception exception,
					ServiceFilterResponse response) {
				if (exception == null) {
					callback.onCompleted(true);
				} else {
					EventBus.getDefault().post(new BoardException(fragment, BoardException.TYPE.SERVER_ERROR));
				}
			}
		});
	}
}
