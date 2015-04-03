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


public class SevenFragment extends Fragment implements OnClickListener {
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


		Community calamity1 = new Community("포항산악구조대", "0542749986", "포항시");
		Community calamity2 = new Community("경주시재난인명구조대", "01035215856","경주시");
		Community calamity3 = new Community("김천의용소방대","0544310054" ,"김천시");
		Community calamity4 = new Community("안동시수난구조대", "01087204186", "안동시");
		Community calamity5 = new Community("대한민국특전동지회영천시지회", "0116631587","영천시");
		Community calamity6 = new Community("상주시민간인명구조대","01035122574" ,"상주시");
		Community calamity7 = new Community("해병전우회", "01094765979", "문경시");
		Community calamity8 = new Community("경산시청아마추어무선봉사대", "0548106300","경산시");
		Community calamity9 = new Community("용성면 자율방범대","01040671373" ,"경산시");
		Community calamity10 = new Community("군위읍 의용소방대", "0543821400", "군위군");
		Community calamity11 = new Community("청송군산악구조대", "01034792249","청송군");
		Community calamity12 = new Community("대한적십자사경북지사영양수난구조대","0546839119" ,"영양군");
		Community calamity13 = new Community("영덕 아마추어무선봉사대", "0547306377", "영덕군");
		Community calamity14 = new Community("청도여성의용소방대", "0543734209","청도군");
		Community calamity15 = new Community("울릉산악구조대","0547906244" ,"울릉군");
		Community calamity16 = new Community("대한응급환자이송단남부지구","0516390129" ,"부산광역시 남구");

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