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


public class ThreeFragment extends Fragment implements OnClickListener {
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
		
	      Community calamity1 = new Community("청주시새마을회", "0432644789", "청주시");
	      Community calamity2 = new Community("충주시 간호사회", "0438559393","충주시");
	      Community calamity3 = new Community("내토봉사회","0436432080" ,"제천시");
	      Community calamity4 = new Community("의림봉사회", "0436462843", "제천시");
	      Community calamity5 = new Community("제천잠수회", "0436433342","제천시");
	      Community calamity6 = new Community("내북면 의용소방대","0435420002" ,"보은군");
	      Community calamity7 = new Community("속리산면 의용소방대", "0116535183", "보은군");
	      Community calamity8 = new Community("해병대전우회", "0435424791","보은군");
	      Community calamity9 = new Community("옥천군새마을회","0437334777" ,"옥천군");
	      Community calamity10 = new Community("한국수난안전협회영동지구대", "0437421908", "영동군");
	      Community calamity11 = new Community("증평군지역자율방재단", "01027729113","증평군");
	      Community calamity12 = new Community("덕산청년회","01092504251" ,"진천군");
	      Community calamity13 = new Community("부녀지도자연합회", "01134672255", "진천군");
	      Community calamity14 = new Community("괴산의용소방대", "0114853133","괴산군");
	      Community calamity15 = new Community("감곡 적십자봉사대","0163493736" ,"음성군");
	      Community calamity16 = new Community("단양군 자율방재단","01094061021" ,"단양군");
	
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
