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
		
	      Community calamity1 = new Community("������Ŵ��", "01053675907", "��õ��");
	      Community calamity2 = new Community("�����119���������", "0337422001","���ֽ�");
	      Community calamity3 = new Community("�����û������γ�ȸ","0336521882" ,"������");
	      Community calamity4 = new Community("���ظ��������ȸ", "0335337524", "���ؽ�");
	      Community calamity5 = new Community("��Ÿ ��Ǳ�����", "0335348194","���ؽ�");
	      Community calamity6 = new Community("��ȣ���������","0113767082" ,"���ؽ�");
	      Community calamity7 = new Community("�ƿ츧�����", "01067308579", "�¹��");
	      Community calamity8 = new Community("�¹����", "0335502101","�¹��");
	      Community calamity9 = new Community("�ΰ�����������","0336342241" ,"���ʽ�");
	      Community calamity10 = new Community("�����ǿ�ҹ��", "0113758704", "���ʽ�");
	      Community calamity11 = new Community("������ǿ�ҹ��", "0335721316","��ô��");
	      Community calamity12 = new Community("���׻걸����","0113663661" ,"��ô��");
	      Community calamity13 = new Community("��ô���ȸ", "0335747565", "��ô��");
	      Community calamity14 = new Community("���������ڻ�ȫõ��������ȸ", "01074008295","ȫõ��");
	      Community calamity15 = new Community("�������������","01098780399" ,"Ⱦ����");
	      Community calamity16 = new Community("���û��ȸ","01029239686" ,"������");
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
