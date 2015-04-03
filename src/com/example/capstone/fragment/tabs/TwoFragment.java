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


public class TwoFragment extends Fragment implements OnClickListener {
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
		
	      Community calamity1 = new Community("전기지킴이", "01053675907", "춘천시");
	      Community calamity2 = new Community("사랑의119우정봉사단", "0337422001","원주시");
	      Community calamity3 = new Community("강릉시새마을부녀회","0336521882" ,"강릉시");
	      Community calamity4 = new Community("동해모범운전자회", "0335337524", "동해시");
	      Community calamity5 = new Community("두타 산악구조대", "0335348194","동해시");
	      Community calamity6 = new Community("묵호자율방재단","0113767082" ,"동해시");
	      Community calamity7 = new Community("아우름봉사단", "01067308579", "태백시");
	      Community calamity8 = new Community("태백잠수", "0335502101","태백시");
	      Community calamity9 = new Community("민간자율구조대","0336342241" ,"속초시");
	      Community calamity10 = new Community("속초의용소방대", "0113758704", "속초시");
	      Community calamity11 = new Community("가곡여성의용소방대", "0335721316","삼척시");
	      Community calamity12 = new Community("덕항산구조대","0113663661" ,"삼척시");
	      Community calamity13 = new Community("삼척잠수회", "0335747565", "삼척시");
	      Community calamity14 = new Community("대한적십자사홍천지구협의회", "01074008295","홍천군");
	      Community calamity15 = new Community("고씨굴자율방범대","01098780399" ,"횡성군");
	      Community calamity16 = new Community("김삿갓청년회","01029239686" ,"영월군");
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
