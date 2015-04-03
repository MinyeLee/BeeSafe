package com.example.capstone.fragment.tabs;

import info.androidhive.slidingmenu.R;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.capstone.adapter.CommunityAdapter;
import com.example.capstone.model.Community;


public class SixFragment extends Fragment implements OnClickListener {
	ListView listView;
	CommunityAdapter adapter;
	List<Community> list;
	Context thiscontext;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		super.onCreateView(inflater, container, savedInstanceState);
		thiscontext = container.getContext();
		View view = inflater.inflate(R.layout.fragment_first, container, false);
		list = new ArrayList<Community>();
		adapter = new CommunityAdapter(thiscontext, list);
		
		listView = (ListView)view.findViewById(R.id.first_list_view);
		listView.setAdapter(adapter);

		Community calamity1 = new Community("전남소방본부", "0612860900", "무안군 삼향읍 오룡길 1");
		Community calamity2 = new Community("수난구조대", "0617445568","순천시");
		Community calamity3 = new Community("한국수난안전협회광양지구대","7949119" ,"광양시");
		Community calamity4 = new Community("순천소방서산악구조대", "7810119", "구례군");
		Community calamity5 = new Community("국립공원월출산사무소재난구조대", "0614735210","강진군");
		Community calamity6 = new Community("완도해양구조단","0615530119" ,"완도군");
		Community calamity7 = new Community("아마추어무선봉사대", "01051970213", "진도군임회면");
		Community calamity8 = new Community("월산면의용소방대", "01036147347","담양군");
		Community calamity9 = new Community("목포산악구조대","2738848" ,"순천시");
		Community calamity10 = new Community("순천시의용소방대", "0617500822", "순천시");
		Community calamity11 = new Community("산동면의용소방대", "7833777","구례군");
		Community calamity12 = new Community("광의면의용소방대","7813514" ,"구례군");
		Community calamity13 = new Community("구례읍 신월의용소방대", "7826425", "구례군");
		Community calamity14 = new Community("삼호읍의용소방대", "0616730098","영암군 삼호읍");
		Community calamity15 = new Community("덕진면의용소방대","0614730098" ,"영암군 덕진면");
		Community calamity16 = new Community("황산면의용소방대","0615322793" ,"해남군");
	
		list.add(calamity1);
		list.add(calamity2);
		list.add(calamity3);
		list.add(calamity4);
		list.add(calamity5);
		list.add(calamity6);
		list.add(calamity7);
		list.add(calamity8);
		list.add(calamity9);
		list.add(calamity10);
		list.add(calamity11);
		list.add(calamity12);
		list.add(calamity13);
		list.add(calamity14);
		list.add(calamity15);
		list.add(calamity16);
		
		
		adapter.notifyDataSetChanged();
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
//				Calamity calamity = list.get(position);
//				String url = calamity.getUrl();
//				Intent intent = new Intent(getActivity(), WebViewActivity.class);
//				intent.putExtra("url", url);
//				startActivity(intent);
				Community community_phone = list.get(position);
				String phone = community_phone.getData2();
				Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+phone));
                startActivity(i);
			}
		});
		
		return view;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}