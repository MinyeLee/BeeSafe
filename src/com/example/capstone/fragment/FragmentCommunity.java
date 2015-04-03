package com.example.capstone.fragment;


import info.androidhive.slidingmenu.R;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.capstone.fragment.tabs.EightFragment;
import com.example.capstone.fragment.tabs.FiveFragment;
import com.example.capstone.fragment.tabs.FourFragment;
import com.example.capstone.fragment.tabs.NineFragment;
import com.example.capstone.fragment.tabs.OneFragment;
import com.example.capstone.fragment.tabs.SevenFragment;
import com.example.capstone.fragment.tabs.SixFragment;
import com.example.capstone.fragment.tabs.ThreeFragment;
import com.example.capstone.fragment.tabs.TwoFragment;

public class FragmentCommunity extends Fragment implements OnClickListener {

	final String TAG = "MainActivity";
	Context thiscontext;
	
	int mCurrentFragmentIndex;
	public final static int FRAGMENT_ONE = 0;
	public final static int FRAGMENT_TWO = 1;
	public final static int FRAGMENT_THREE = 2;
	public final static int FRAGMENT_FOUR = 3;
	public final static int FRAGMENT_FIVE = 4;
	public final static int FRAGMENT_SIX = 5;
	public final static int FRAGMENT_SEVEN = 6;
	public final static int FRAGMENT_EIGHT = 7;
	public final static int FRAGMENT_NINE = 8;

	ImageButton bt_oneFragment1;
	ImageButton bt_oneFragment2;
	ImageButton bt_oneFragment3;
	ImageButton bt_oneFragment4;
	ImageButton bt_oneFragment5;
	ImageButton bt_oneFragment6;
	ImageButton bt_oneFragment7;
	ImageButton bt_oneFragment8;
	ImageButton bt_oneFragment9;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
		 
		 View rootView = inflater.inflate(R.layout.fragment_community, container, false);
		    thiscontext = container.getContext();

		bt_oneFragment1 = (ImageButton)rootView.findViewById(R.id.bt_oneFragment);
		bt_oneFragment1.setOnClickListener(this);
		
		bt_oneFragment2 = (ImageButton)rootView.findViewById(R.id.bt_twoFragment);
		bt_oneFragment2.setOnClickListener(this);
		
		bt_oneFragment3 = (ImageButton)rootView.findViewById(R.id.bt_threeFragment);
		bt_oneFragment3.setOnClickListener(this);
		
		bt_oneFragment4 = (ImageButton)rootView.findViewById(R.id.bt_4Fragment);
		bt_oneFragment4.setOnClickListener(this);
		
		bt_oneFragment5 = (ImageButton)rootView.findViewById(R.id.bt_5Fragment);
		bt_oneFragment5.setOnClickListener(this);
		
		bt_oneFragment6 = (ImageButton)rootView.findViewById(R.id.bt_6Fragment);
		bt_oneFragment6.setOnClickListener(this);
		
		bt_oneFragment7 = (ImageButton)rootView.findViewById(R.id.bt_7Fragment);
		bt_oneFragment7.setOnClickListener(this);
		
		bt_oneFragment8 = (ImageButton)rootView.findViewById(R.id.bt_8Fragment);
		bt_oneFragment8.setOnClickListener(this);
		
		bt_oneFragment9 = (ImageButton)rootView.findViewById(R.id.bt_9Fragment);
		bt_oneFragment9.setOnClickListener(this);

		mCurrentFragmentIndex = FRAGMENT_ONE;

		fragmentReplace(mCurrentFragmentIndex);
		return rootView;
	}

	public void fragmentReplace(int reqNewFragmentIndex) {

		Fragment newFragment = null;

		Log.d(TAG, "fragmentReplace " + reqNewFragmentIndex);

		newFragment = getFragment(reqNewFragmentIndex);

		// replace fragment
		final FragmentTransaction transaction = getFragmentManager()
				.beginTransaction();

		transaction.replace(R.id.ll_fragment, newFragment);

		// Commit the transaction
		transaction.commit();

	}

	private Fragment getFragment(int idx) {
		Fragment newFragment = null;

		switch (idx) {
		case FRAGMENT_ONE:
			newFragment = new OneFragment();
			break;
		case FRAGMENT_TWO:
			newFragment = new TwoFragment();
			break;
		case FRAGMENT_THREE:
			newFragment = new ThreeFragment();
			break;
		case FRAGMENT_FOUR:
			newFragment = new FourFragment();
			break;
		case FRAGMENT_FIVE:
			newFragment = new FiveFragment();
			break;
		case FRAGMENT_SIX:
			newFragment = new SixFragment();
			break;
		case FRAGMENT_SEVEN:
			newFragment = new SevenFragment();
			break;
		case FRAGMENT_EIGHT:
			newFragment = new EightFragment();
			break;
		case FRAGMENT_NINE:
			newFragment = new NineFragment();
			break;

		default:
			Log.d(TAG, "Unhandle case");
			break;
		}

		return newFragment;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.bt_oneFragment:
			mCurrentFragmentIndex = FRAGMENT_ONE;
			fragmentReplace(mCurrentFragmentIndex);
			bt_oneFragment1.setBackgroundResource(R.drawable.seoulclick);
			bt_oneFragment2.setBackgroundResource(R.drawable.kang);
			bt_oneFragment3.setBackgroundResource(R.drawable.chungbuk);
			bt_oneFragment4.setBackgroundResource(R.drawable.chungnam);
			bt_oneFragment5.setBackgroundResource(R.drawable.jeonbuk);
			bt_oneFragment6.setBackgroundResource(R.drawable.jeonnam);
			bt_oneFragment7.setBackgroundResource(R.drawable.gyeongbuk);
			bt_oneFragment8.setBackgroundResource(R.drawable.gyeongnam);
			bt_oneFragment9.setBackgroundResource(R.drawable.jeju);
			//imageChange(bt_oneFragment1);
			break;
		case R.id.bt_twoFragment:
			mCurrentFragmentIndex = FRAGMENT_TWO;
			fragmentReplace(mCurrentFragmentIndex);
			bt_oneFragment1.setBackgroundResource(R.drawable.seoul);
			bt_oneFragment2.setBackgroundResource(R.drawable.kangclick);
			bt_oneFragment3.setBackgroundResource(R.drawable.chungbuk);
			bt_oneFragment4.setBackgroundResource(R.drawable.chungnam);
			bt_oneFragment5.setBackgroundResource(R.drawable.jeonbuk);
			bt_oneFragment6.setBackgroundResource(R.drawable.jeonnam);
			bt_oneFragment7.setBackgroundResource(R.drawable.gyeongbuk);
			bt_oneFragment8.setBackgroundResource(R.drawable.gyeongnam);
			bt_oneFragment9.setBackgroundResource(R.drawable.jeju);
			break;
		case R.id.bt_threeFragment:
			mCurrentFragmentIndex = FRAGMENT_THREE;
			fragmentReplace(mCurrentFragmentIndex);
			bt_oneFragment1.setBackgroundResource(R.drawable.seoul);
			bt_oneFragment2.setBackgroundResource(R.drawable.kang);
			bt_oneFragment3.setBackgroundResource(R.drawable.chungbukclick);
			bt_oneFragment4.setBackgroundResource(R.drawable.chungnam);
			bt_oneFragment5.setBackgroundResource(R.drawable.jeonbuk);
			bt_oneFragment6.setBackgroundResource(R.drawable.jeonnam);
			bt_oneFragment7.setBackgroundResource(R.drawable.gyeongbuk);
			bt_oneFragment8.setBackgroundResource(R.drawable.gyeongnam);
			bt_oneFragment9.setBackgroundResource(R.drawable.jeju);
			break;
		case R.id.bt_4Fragment:
			mCurrentFragmentIndex = FRAGMENT_FOUR;
			fragmentReplace(mCurrentFragmentIndex);
			bt_oneFragment1.setBackgroundResource(R.drawable.seoul);
			bt_oneFragment2.setBackgroundResource(R.drawable.kang);
			bt_oneFragment3.setBackgroundResource(R.drawable.chungbuk);
			bt_oneFragment4.setBackgroundResource(R.drawable.chungnamclick);
			bt_oneFragment5.setBackgroundResource(R.drawable.jeonbuk);
			bt_oneFragment6.setBackgroundResource(R.drawable.jeonnam);
			bt_oneFragment7.setBackgroundResource(R.drawable.gyeongbuk);
			bt_oneFragment8.setBackgroundResource(R.drawable.gyeongnam);
			bt_oneFragment9.setBackgroundResource(R.drawable.jeju);
			break;
		case R.id.bt_5Fragment:
			mCurrentFragmentIndex = FRAGMENT_FIVE;
			fragmentReplace(mCurrentFragmentIndex);
			bt_oneFragment1.setBackgroundResource(R.drawable.seoul);
			bt_oneFragment2.setBackgroundResource(R.drawable.kang);
			bt_oneFragment3.setBackgroundResource(R.drawable.chungbuk);
			bt_oneFragment4.setBackgroundResource(R.drawable.chungnam);
			bt_oneFragment5.setBackgroundResource(R.drawable.jeonbukblick);
			bt_oneFragment6.setBackgroundResource(R.drawable.jeonnam);
			bt_oneFragment7.setBackgroundResource(R.drawable.gyeongbuk);
			bt_oneFragment8.setBackgroundResource(R.drawable.gyeongnam);
			bt_oneFragment9.setBackgroundResource(R.drawable.jeju);
			break;
		case R.id.bt_6Fragment:
			mCurrentFragmentIndex = FRAGMENT_SIX;
			fragmentReplace(mCurrentFragmentIndex);
			bt_oneFragment1.setBackgroundResource(R.drawable.seoul);
			bt_oneFragment2.setBackgroundResource(R.drawable.kang);
			bt_oneFragment3.setBackgroundResource(R.drawable.chungbuk);
			bt_oneFragment4.setBackgroundResource(R.drawable.chungnam);
			bt_oneFragment5.setBackgroundResource(R.drawable.jeonbuk);
			bt_oneFragment6.setBackgroundResource(R.drawable.jeonnamclick);
			bt_oneFragment7.setBackgroundResource(R.drawable.gyeongbuk);
			bt_oneFragment8.setBackgroundResource(R.drawable.gyeongnam);
			bt_oneFragment9.setBackgroundResource(R.drawable.jeju);
			break;
		case R.id.bt_7Fragment:
			mCurrentFragmentIndex = FRAGMENT_SEVEN;
			fragmentReplace(mCurrentFragmentIndex);
			bt_oneFragment1.setBackgroundResource(R.drawable.seoul);
			bt_oneFragment2.setBackgroundResource(R.drawable.kang);
			bt_oneFragment3.setBackgroundResource(R.drawable.chungbuk);
			bt_oneFragment4.setBackgroundResource(R.drawable.chungnam);
			bt_oneFragment5.setBackgroundResource(R.drawable.jeonbuk);
			bt_oneFragment6.setBackgroundResource(R.drawable.jeonnam);
			bt_oneFragment7.setBackgroundResource(R.drawable.gyeongbukclick);
			bt_oneFragment8.setBackgroundResource(R.drawable.gyeongnam);
			bt_oneFragment9.setBackgroundResource(R.drawable.jeju);
			break;
		case R.id.bt_8Fragment:
			mCurrentFragmentIndex = FRAGMENT_EIGHT;
			fragmentReplace(mCurrentFragmentIndex);
			bt_oneFragment1.setBackgroundResource(R.drawable.seoul);
			bt_oneFragment2.setBackgroundResource(R.drawable.kang);
			bt_oneFragment3.setBackgroundResource(R.drawable.chungbuk);
			bt_oneFragment4.setBackgroundResource(R.drawable.chungnam);
			bt_oneFragment5.setBackgroundResource(R.drawable.jeonbuk);
			bt_oneFragment6.setBackgroundResource(R.drawable.jeonnam);
			bt_oneFragment7.setBackgroundResource(R.drawable.gyeongbuk);
			bt_oneFragment8.setBackgroundResource(R.drawable.gyeongnamclick);
			bt_oneFragment9.setBackgroundResource(R.drawable.jeju);
			break;
		case R.id.bt_9Fragment:
			mCurrentFragmentIndex = FRAGMENT_NINE;
			fragmentReplace(mCurrentFragmentIndex);
			bt_oneFragment1.setBackgroundResource(R.drawable.seoul);
			bt_oneFragment2.setBackgroundResource(R.drawable.kang);
			bt_oneFragment3.setBackgroundResource(R.drawable.chungbuk);
			bt_oneFragment4.setBackgroundResource(R.drawable.chungnam);
			bt_oneFragment5.setBackgroundResource(R.drawable.jeonbuk);
			bt_oneFragment6.setBackgroundResource(R.drawable.jeonnam);
			bt_oneFragment7.setBackgroundResource(R.drawable.gyeongbuk);
			bt_oneFragment8.setBackgroundResource(R.drawable.gyeongnam);
			bt_oneFragment9.setBackgroundResource(R.drawable.jejuclick);
			break;

		}
	}
}
