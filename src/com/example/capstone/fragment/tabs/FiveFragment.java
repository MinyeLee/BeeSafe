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
		

		Community calamity1 = new Community("�ǿ�ҹ��", "0632504251", "���ֽ�");
		Community calamity2 = new Community("����� �ǿ�ҹ��", "0635713057","������");
		Community calamity3 = new Community("�����û�ǿ���","0636263101" ,"������ ���׵� ����");
		Community calamity4 = new Community("�ΰ�����Ϳ��", "0635441240", "������");
		Community calamity5 = new Community("�곻�θ�����", "0636363738","������");
		Community calamity6 = new Community("�������Ǳ�����","0633224945" ,"���ֱ�");
		Community calamity7 = new Community("���ֱ�����������", "0633229952", "���ֱ�");
		Community calamity8 = new Community("��â�ҹ漭��Ǳ�����", "5616546","��â��");
		Community calamity9 = new Community("�̼��ż���������","0635826648" ,"�ξȱ�");
		Community calamity10 = new Community("�ѱ��ؾ籸����", "0116528948", "�ξȱ�");
		Community calamity11 = new Community("������ü����ȸ", "0636347373","������");
		Community calamity12 = new Community("������ü����ȸ","0166895352" ,"�����");
		Community calamity13 = new Community("���������", "0106785379", "�ӽǱ�");
		Community calamity14 = new Community("��â���պ���", "0635633333","��â�� ��â�� ������ 663");
		Community calamity15 = new Community("�����ƻ꺴��","0635306114" ,"������ ��赿 350");
		Community calamity16 = new Community("�ξȼ��𺴿�","0635815100" ,"�ξȱ� �ξ��� ������ 583");


	
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
