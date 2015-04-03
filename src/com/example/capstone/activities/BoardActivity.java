package com.example.capstone.activities;

import info.androidhive.slidingmenu.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.example.capstone.fragment.FragmentBoardDetail;
import com.example.capstone.fragment.FragmentBoardUpload;

public class BoardActivity extends FragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_frame);

		FragmentManager fragmentManager = getSupportFragmentManager();
		
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		
		Intent intent = getIntent();
		String page = intent.getStringExtra("page");
		Fragment fragment = null;
		if (page.equals("detail")) {
			fragment = new FragmentBoardDetail();
		} else {
			fragment = new FragmentBoardUpload();
		}
		fragmentTransaction.add(R.id.activity_container, fragment);
		fragmentTransaction.commit();
	}
}
