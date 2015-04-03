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

		Community calamity1 = new Community("�����ҹ溻��", "0612860900", "���ȱ� ������ ����� 1");
		Community calamity2 = new Community("����������", "0617445568","��õ��");
		Community calamity3 = new Community("�ѱ�����������ȸ����������","7949119" ,"�����");
		Community calamity4 = new Community("��õ�ҹ漭��Ǳ�����", "7810119", "���ʱ�");
		Community calamity5 = new Community("�������������繫���糭������", "0614735210","������");
		Community calamity6 = new Community("�ϵ��ؾ籸����","0615530119" ,"�ϵ���");
		Community calamity7 = new Community("�Ƹ��߾�������", "01051970213", "��������ȸ��");
		Community calamity8 = new Community("������ǿ�ҹ��", "01036147347","��籺");
		Community calamity9 = new Community("������Ǳ�����","2738848" ,"��õ��");
		Community calamity10 = new Community("��õ���ǿ�ҹ��", "0617500822", "��õ��");
		Community calamity11 = new Community("�굿���ǿ�ҹ��", "7833777","���ʱ�");
		Community calamity12 = new Community("���Ǹ��ǿ�ҹ��","7813514" ,"���ʱ�");
		Community calamity13 = new Community("������ �ſ��ǿ�ҹ��", "7826425", "���ʱ�");
		Community calamity14 = new Community("��ȣ���ǿ�ҹ��", "0616730098","���ϱ� ��ȣ��");
		Community calamity15 = new Community("�������ǿ�ҹ��","0614730098" ,"���ϱ� ������");
		Community calamity16 = new Community("Ȳ����ǿ�ҹ��","0615322793" ,"�س���");
	
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