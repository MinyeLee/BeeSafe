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


public class FourFragment extends Fragment implements OnClickListener {
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

		Community calamity1 = new Community("부여군안전모니터봉사단", "0418328372", "부여군");
		Community calamity2 = new Community("대덕구경찰서", "0422810258","대덕구 대덕대로1417번길 11");
		Community calamity3 = new Community("동부소방서","0426096461" ,"대덕구 계족로 682");
		Community calamity4 = new Community("충남도시가스", "0423365205", "중구 유등천동로 762");
		Community calamity5 = new Community("대전중앙병원응급실", "0426705119","대덕구 계족로 637");
		Community calamity6 = new Community("동부소방서","0426096461" ,"대덕구 계족로 682");
		Community calamity7 = new Community("보훈병원응급실", "0429390100", "대덕구 대청로82번길 147");
		Community calamity8 = new Community("충남소방안전본부", "0422203117","홍성군 홍북면 충남대로 21");
		Community calamity9 = new Community("112민간순찰대","01198094502" ,"천안시");
		Community calamity10 = new Community("병천의용소방대", "01054243911", "천안시");
		Community calamity11 = new Community("산악구조대", "0114523613","천안시");
		Community calamity12 = new Community("천안경찰서","01030663973" ,"천안시");
		Community calamity13 = new Community("블루가드", "01047851999", "태안군");
		Community calamity14 = new Community("한국구조연합안면도지역대", "01072850482","태안군");
		Community calamity15 = new Community("태안군자원봉사센터","0416751365" ,"태안군");
		Community calamity16 = new Community("서천군 여성단체 협의회","9517911" ,"서천군");

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
