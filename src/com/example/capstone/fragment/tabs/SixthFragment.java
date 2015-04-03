package com.example.capstone.fragment.tabs;

import java.util.ArrayList;
import java.util.List;

import com.example.capstone.activities.WebViewActivity;
import com.example.capstone.adapter.FirstListAdapter;
import com.example.capstone.model.Calamity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import info.androidhive.slidingmenu.R;


public class SixthFragment extends Fragment {
	ListView listView;
	FirstListAdapter adapter;
	ArrayList<Calamity> list;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_first, container, false);
		list = new ArrayList<Calamity>();
		adapter = new FirstListAdapter(getActivity(), list);
		
		listView = (ListView)view.findViewById(R.id.first_list_view);
		
		listView.setAdapter(adapter);
		
		
		Calamity calamity1 = new Calamity(R.drawable.u,"성인심폐소생술", "응급처치법 자료");
		calamity1.setUrl("https://www.evernote.com/shard/s431/sh/d3f48c22-aff7-4521-bdb2-49de0d6c424d/febf95aa3e6ece5815ad32853179da76");
		Calamity calamity2 = new Calamity(R.drawable.v,"기도폐쇄", "응급처치법 자료");
		calamity2.setUrl("https://www.evernote.com/shard/s431/sh/5b938d2f-689e-4459-a6c9-00c2d5e63cd5/31eac00da8f4563a9ff192723d6bfa71");
		Calamity calamity3 = new Calamity(R.drawable.w,"심장질환", "응급처치법 자료");
		calamity3.setUrl("https://www.evernote.com/shard/s431/sh/5816d377-ca34-4075-8cca-3860266790da/fa9ca4ccbcda2ea0c6cab867d521f449");
		Calamity calamity4 = new Calamity(R.drawable.x,"출혈", "응급처치법 자료");
		calamity4.setUrl("https://www.evernote.com/shard/s431/sh/d0fb8c51-c354-4bab-a54c-44b4b7b3a231/6fbd030c73c5397aacbd8042680d11a1");
		Calamity calamity5 = new Calamity(R.drawable.y,"골절", "응급처치법 자료");
		calamity5.setUrl("https://www.evernote.com/shard/s431/sh/2b322918-4944-44e7-b317-31ca96bbfeec/2e9968aeb68cfcb09aff6eb4641456f2");
		
		
		list.add(calamity1);
		list.add(calamity2);
		list.add(calamity3);
		list.add(calamity4);
		list.add(calamity5);
		
		adapter.notifyDataSetChanged();
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Calamity calamity = list.get(position);
				String url = calamity.getUrl();
				Intent intent = new Intent(getActivity(), WebViewActivity.class);
				intent.putExtra("url", url);
				startActivity(intent);
			}
		});
		
		return view;
	}
}
