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


public class FiveFragment extends Fragment implements OnClickListener {
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
		

		Community calamity1 = new Community("의용소방대", "0632504251", "전주시");
		Community calamity2 = new Community("감곡면 의용소방대", "0635713057","정읍시");
		Community calamity3 = new Community("남원시산악연맹","0636263101" ,"남원시 죽항동 죽항");
		Community calamity4 = new Community("민간모니터요원", "0635441240", "김제시");
		Community calamity5 = new Community("산내인명구조대", "0636363738","남원시");
		Community calamity6 = new Community("덕유산산악구조대","0633224945" ,"무주군");
		Community calamity7 = new Community("무주군수난구조대", "0633229952", "무주군");
		Community calamity8 = new Community("고창소방서산악구조대", "5616546","고창군");
		Community calamity9 = new Community("이순신수난구조대","0635826648" ,"부안군");
		Community calamity10 = new Community("한국해양구조단", "0116528948", "부안군");
		Community calamity11 = new Community("여성단체협의회", "0636347373","남원시");
		Community calamity12 = new Community("여성단체협의회","0166895352" ,"장수군");
		Community calamity13 = new Community("자율방범대", "0106785379", "임실군");
		Community calamity14 = new Community("고창종합병원", "0635633333","고창군 고창읍 읍내리 663");
		Community calamity15 = new Community("정읍아산병원","0635306114" ,"정읍시 용계동 350");
		Community calamity16 = new Community("부안성모병원","0635815100" ,"부안군 부안읍 봉덕리 583");


	
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
