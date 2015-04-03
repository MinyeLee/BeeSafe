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


		Community calamity1 = new Community("���׻�Ǳ�����", "0542749986", "���׽�");
		Community calamity2 = new Community("���ֽ��糭�θ�����", "01035215856","���ֽ�");
		Community calamity3 = new Community("��õ�ǿ�ҹ��","0544310054" ,"��õ��");
		Community calamity4 = new Community("�ȵ��ü���������", "01087204186", "�ȵ���");
		Community calamity5 = new Community("���ѹα�Ư������ȸ��õ����ȸ", "0116631587","��õ��");
		Community calamity6 = new Community("���ֽùΰ��θ�����","01035122574" ,"���ֽ�");
		Community calamity7 = new Community("�غ�����ȸ", "01094765979", "�����");
		Community calamity8 = new Community("����û�Ƹ��߾�������", "0548106300","����");
		Community calamity9 = new Community("�뼺�� ���������","01040671373" ,"����");
		Community calamity10 = new Community("������ �ǿ�ҹ��", "0543821400", "������");
		Community calamity11 = new Community("û�۱���Ǳ�����", "01034792249","û�۱�");
		Community calamity12 = new Community("���������ڻ������翵�����������","0546839119" ,"���籺");
		Community calamity13 = new Community("���� �Ƹ��߾�������", "0547306377", "������");
		Community calamity14 = new Community("û�������ǿ�ҹ��", "0543734209","û����");
		Community calamity15 = new Community("�︪��Ǳ�����","0547906244" ,"�︪��");
		Community calamity16 = new Community("��������ȯ���̼۴ܳ�������","0516390129" ,"�λ걤���� ����");

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