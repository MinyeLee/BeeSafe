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

		Community calamity1 = new Community("�ǿ�ҹ��", "0175956650", "â����");
		Community calamity2 = new Community("���߱�����", "0555428987","â����");
		Community calamity3 = new Community("��������ȯ���̼۴�","0556411339" ,"�뿵��");
		Community calamity4 = new Community("�ΰ����������", "0558522986", "��õ��");
		Community calamity5 = new Community("�ΰ�������������", "0558348315","��õ��");
		Community calamity6 = new Community("���ؼҹ漭 �ǿ�ҹ�� ����ȸ","0553209263" ,"���ؽ�");
		Community calamity7 = new Community("�ѱ�112��������ܹо�����", "01065103800", "�о��");
		Community calamity8 = new Community("���߱�����", "0556815535","������");
		Community calamity9 = new Community("����������","0553884740" ,"����");
		Community calamity10 = new Community("��󳲵� �ǿ�ҹ�� �Ƿɱ�����ȸ", "0116974545", "�Ծȱ�");
		Community calamity11 = new Community("���ؾ籸����", "0556746999","����");
		Community calamity12 = new Community("�θ��������","01035635500" ,"�ϵ���");
		Community calamity13 = new Community("������ �ΰ���Ǳ�����", "0559739415", "��û��");
		Community calamity14 = new Community("(��)�ѱ��ؾ籸����ȸ ��â������", "0559407731","��â��");
		Community calamity15 = new Community("SMSƯ��������","01095679716" ,"�λ걤���� ������");
		Community calamity16 = new Community("�ѱ������ѿ��� �糭������","01076629293" ,"�λ걤���� ������");

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
