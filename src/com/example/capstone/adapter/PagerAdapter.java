package com.example.capstone.adapter;

import com.example.capstone.fragment.tabs.FifthFragment;
import com.example.capstone.fragment.tabs.FirstFragment;
import com.example.capstone.fragment.tabs.FourthFragment;
import com.example.capstone.fragment.tabs.SecondFragment;
import com.example.capstone.fragment.tabs.SixthFragment;
import com.example.capstone.fragment.tabs.ThirdFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class PagerAdapter extends android.support.v4.app.FragmentStatePagerAdapter {

	private Fragment[] fragmentList;
	private String[] titles = new String[]{"해양사고", "화재","지하철/건물","붕괴,폭발","기타인적재난","응급처치법"};
	

	public PagerAdapter(FragmentManager fm) {
		super(fm);
		fragmentList = new Fragment[titles.length];
		fragmentList[0] = new FirstFragment();
		fragmentList[1] = new SecondFragment();
		fragmentList[2] = new ThirdFragment();
		fragmentList[3] = new FourthFragment();
		fragmentList[4] = new FifthFragment();
		fragmentList[5] = new SixthFragment();
	}



	@Override
	public CharSequence getPageTitle(int position) {
		return titles[position];
	}

	@Override
	public Fragment getItem(int position) {
		return fragmentList[position];
	}


	@Override
	public int getCount() {
		return this.fragmentList.length;
	}
}
