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

		Community calamity1 = new Community("�ο�����������ͺ����", "0418328372", "�ο���");
		Community calamity2 = new Community("�����������", "0422810258","����� ������1417���� 11");
		Community calamity3 = new Community("���μҹ漭","0426096461" ,"����� ������ 682");
		Community calamity4 = new Community("�泲���ð���", "0423365205", "�߱� ����õ���� 762");
		Community calamity5 = new Community("�����߾Ӻ������޽�", "0426705119","����� ������ 637");
		Community calamity6 = new Community("���μҹ漭","0426096461" ,"����� ������ 682");
		Community calamity7 = new Community("���ƺ������޽�", "0429390100", "����� ��û��82���� 147");
		Community calamity8 = new Community("�泲�ҹ��������", "0422203117","ȫ���� ȫ�ϸ� �泲��� 21");
		Community calamity9 = new Community("112�ΰ�������","01198094502" ,"õ�Ƚ�");
		Community calamity10 = new Community("��õ�ǿ�ҹ��", "01054243911", "õ�Ƚ�");
		Community calamity11 = new Community("��Ǳ�����", "0114523613","õ�Ƚ�");
		Community calamity12 = new Community("õ�Ȱ�����","01030663973" ,"õ�Ƚ�");
		Community calamity13 = new Community("��簡��", "01047851999", "�¾ȱ�");
		Community calamity14 = new Community("�ѱ��������վȸ鵵������", "01072850482","�¾ȱ�");
		Community calamity15 = new Community("�¾ȱ��ڿ����缾��","0416751365" ,"�¾ȱ�");
		Community calamity16 = new Community("��õ�� ������ü ����ȸ","9517911" ,"��õ��");

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
