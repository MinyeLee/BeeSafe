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


public class EightFragment extends Fragment implements OnClickListener {
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

		Community calamity1 = new Community("의용소방대", "0175956650", "창원시");
		Community calamity2 = new Community("수중구조대", "0555428987","창원시");
		Community calamity3 = new Community("대한응급환자이송단","0556411339" ,"통영시");
		Community calamity4 = new Community("민간모니터위원", "0558522986", "사천시");
		Community calamity5 = new Community("민간자율명예구조대", "0558348315","사천시");
		Community calamity6 = new Community("김해소방서 의용소방대 연합회","0553209263" ,"김해시");
		Community calamity7 = new Community("한국112무선봉사단밀양지단", "01065103800", "밀양시");
		Community calamity8 = new Community("수중구조대", "0556815535","거제시");
		Community calamity9 = new Community("수난구조대","0553884740" ,"양산시");
		Community calamity10 = new Community("경상남도 의용소방대 의령군연합회", "0116974545", "함안군");
		Community calamity11 = new Community("고성해양구조대", "0556746999","고성군");
		Community calamity12 = new Community("인명구조봉사대","01035635500" ,"하동군");
		Community calamity13 = new Community("지리산 민간산악구조대", "0559739415", "산청군");
		Community calamity14 = new Community("(사)한국해양구조협회 거창구조대", "0559407731","거창군");
		Community calamity15 = new Community("SMS특수구조단","01095679716" ,"부산광역시 영도구");
		Community calamity16 = new Community("한국자유총연맹 재난구조단","01076629293" ,"부산광역시 수영구");

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
