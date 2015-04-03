package com.example.capstone;


import info.androidhive.slidingmenu.R;

import java.net.MalformedURLException;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.example.capstone.helper.BoardHelper;
import com.example.capstone.helper.ItAlertDialog;
import com.example.capstone.helper.ObjectPrefHelper;
import com.example.capstone.helper.PrefHelper;
import com.example.capstone.interfaces.DialogCallback;
import com.example.capstone.model.BoardException;
import com.example.capstone.model.BoardModel;
import com.kakao.template.loginbase.GlobalApplication;
import com.microsoft.windowsazure.mobileservices.MobileServiceClient;

import de.greenrobot.event.EventBus;

public class CapstoneApplication extends GlobalApplication {
	private static final String AZURE_URL = "https://capstone.azure-mobile.net/";
	private static final String AZURE_KEY = "YyHEUFxLSPXmfVZdIcOmXlGjPpwXwY47";
	
	private static volatile CapstoneApplication instance = null;
	
	private MobileServiceClient mobileClient = null;
	private PrefHelper prefHelper;
	private ObjectPrefHelper objectPrefHelper;
	
	private ProgressDialog progressDialog;
	
	private BoardHelper boardHelper;
	
	private BoardModel board;
	
	public BoardModel getBoard() {
		return board;
	}
	public void setBoard(BoardModel board) {
		this.board = board;
	}

    public static CapstoneApplication getGlobalApplicationContext() {
        if(instance == null)
            throw new IllegalStateException("this application does not inherit com.kakao.GlobalApplication");
        return instance;
    }
	
	@Override
	public void onCreate() {
		super.onCreate();
		this.instance = this;
		boardHelper = new BoardHelper();
		
		EventBus.getDefault().register(this);
	}
	
	public MobileServiceClient getMobileClient() {
		if(mobileClient == null){
			try {
				mobileClient = new MobileServiceClient(
						AZURE_URL,
						AZURE_KEY,
						this);
			} catch (MalformedURLException e) {
			}
			
		}
		return mobileClient;
	}
	public BoardHelper getBoardHelper() {
		return this.boardHelper;
	}
	
	public PrefHelper getPrefHelper() {
		if(prefHelper == null) prefHelper = new PrefHelper(instance);
		return prefHelper;
	}
	public ObjectPrefHelper getObjectPrefHelper() {
		if(objectPrefHelper == null) {
			objectPrefHelper = new ObjectPrefHelper();
			objectPrefHelper.setPrefHelper(getPrefHelper());
		}
		return objectPrefHelper;
	}
	
	public boolean isOnline(){
		ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		return (activeNetwork != null && activeNetwork.isConnectedOrConnecting());
	}

	public void showProgressDialog(Context context){
		
		progressDialog = new ProgressDialog(context);
		progressDialog.setCancelable(false);
		progressDialog.show();
		progressDialog.setContentView(R.layout.custom_progress_dialog);
	}

	public void dismissProgressDialog(){
		progressDialog.dismiss();
	}
	
	public void onEvent(BoardException exception) {

		String message = "에러가 발생했습니다";

		ItAlertDialog exceptionDialog = ItAlertDialog.newInstance(message, null, null, false);
		exceptionDialog.setCallback(new DialogCallback() {

			@Override
			public void doPositiveThing(Bundle bundle) {
				android.os.Process.killProcess(android.os.Process.myPid());
				System.exit(1);
			}
			@Override
			public void doNegativeThing(Bundle bundle) {
				// Do nothing
			}
		});
		exceptionDialog.show(exception.getFragment().getFragmentManager(), "DialogKey");
	}
}
