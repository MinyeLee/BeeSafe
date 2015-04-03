package com.example.capstone.fragment.tabs;

import info.androidhive.slidingmenu.R;

import java.util.ArrayList;
import java.util.List;

import com.example.capstone.activities.WebViewActivity;
import com.example.capstone.adapter.FirstListAdapter;
import com.example.capstone.model.Calamity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;



public class FirstFragment extends Fragment {
	ListView listView;
	FirstListAdapter adapter;
	ArrayList<Calamity> list;
	Context context;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_first, container, false);
		list = new ArrayList<Calamity>();
		adapter = new FirstListAdapter(getActivity(), list);
		
		listView = (ListView)view.findViewById(R.id.first_list_view);
		//String WebUrl ="http://hongkunyoo.github.io/test/heart_for_adult.pdf";
		listView.setAdapter(adapter);
		context = container.getContext();
			Calamity calamity1 = new Calamity(R.drawable.a,"유도선사고-승객", "유도선 승객안전 주의사항");
			calamity1.setUrl("https://www.evernote.com/shard/s431/sh/3f4a8597-808c-4d1c-a0c6-abf51aed72bc/a85e5244fe0ce46e837b865e1e5b3363");
			
			Calamity calamity2 = new Calamity(R.drawable.b,"유도선사고-선박", "선박안전관리 일반 매뉴얼");
			calamity2.setUrl("https://www.evernote.com/shard/s431/sh/1739a2c5-8fc7-4bdd-91ba-2d77a6e58601/591a7d43dcb4631740f592f818c98eb6");

			Calamity calamity3 = new Calamity(R.drawable.c,"대규모수질오염", "대규모환경오염(수질) 사고 발생시 국민행동요령");
			calamity3.setUrl("https://www.evernote.com/shard/s431/sh/e27112ce-3817-40ce-bab6-bf3e951c51f3/8b3d24f23a42a2cb1d7ca0e97cc42e59");

			Calamity calamity4 = new Calamity(R.drawable.d,"해양오염사고", "대규모 해양오염사고 발생시 국민행동요령");
			calamity4.setUrl("https://www.evernote.com/shard/s431/sh/38bd0804-dcdd-448c-8f66-2c6cffd74ccb/9162e186c974176b5e43c2834e3960ea");

			Calamity calamity5 = new Calamity(R.drawable.e,"여름철 물놀이 ", "물놀이 안전 매뉴얼");
			calamity5.setUrl("https://www.evernote.com/shard/s431/sh/d3594890-e052-434e-81db-ca9cf9d03028/23600c6e45ab21c6bc6d9852bd1cf899");

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
					Intent intent = new Intent(context, WebViewActivity.class);
					intent.putExtra("url", url);
					context.startActivity(intent);
					//finish();
				}
			});
			return view;
	}
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
			 }
}

