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


public class NineFragment extends Fragment implements OnClickListener {
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
		
		Community calamity1 = new Community("(��)û�ҳ⽺Ų�������ȸ ����Ư����ġ�� ���ֺ���", "0175571199", "���ֽ�");
        Community calamity2 = new Community("���ѹα�������ȸ�ؾ������������ȸ", "01035700717","���ֽ�");
        Community calamity3 = new Community("�쵵�����ǿ�ҹ��","01193311034" ,"���ֽ�");
        Community calamity4 = new Community("�����ؾ������ �ΰ�����������", "0647229595 ", "���ֽ�");
        Community calamity5 = new Community("�������������   ", "0647466682 ","���ֽ�");
        Community calamity6 = new Community("�ؾ�ȯ������","01096622221" ,"���ֽ�");
        Community calamity7 = new Community("�����ǿ�ҹ��", "01036999988", "��������");
        Community calamity8 = new Community("�����������������", "0647603143","��������");
        Community calamity9 = new Community("�����ǿ�ҹ��","0116998555" ,"��������");
        Community calamity10 = new Community("ȿ���ǿ�ҹ��", "01079282243", "��������");

	
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
