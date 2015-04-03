package com.example.capstone.fragment.tabs;

import info.androidhive.slidingmenu.R;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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


public class OneFragment extends Fragment implements OnClickListener {
	ListView listView;
	CommunityAdapter adapter;
	List<Community> list;
	Context thiscontext;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.e("ERROR", "OneFragment");
		super.onCreateView(inflater, container, savedInstanceState);
		thiscontext = container.getContext();
		View view = inflater.inflate(R.layout.fragment_first, container, false);
		list = new ArrayList<Community>();
		adapter = new CommunityAdapter(thiscontext, list);
		
		listView = (ListView)view.findViewById(R.id.first_list_view);
		
		listView.setAdapter(adapter);
		
	      Community calamity1 = new Community("������ ���������", "0232889111", "�����");
	      Community calamity2 = new Community("�ǿ�ҹ��", "024761190","�����");
	      Community calamity3 = new Community("���ϱ� ���������","029895124" ,"�����");
	      Community calamity4 = new Community("���Ǳ������ӴϿ���ȸ", "028895186", "�����");
	      Community calamity5 = new Community("�������������ȸ", "024657917","�����");
	      Community calamity6 = new Community("���α� ������ü����ȸ","01047843771" ,"�����");
	      Community calamity7 = new Community("��õ�� �ùξ��������", "028512233", "�����");
	      Community calamity8 = new Community("���ⱺ��ȸ", "01191211652","�����");
	      Community calamity9 = new Community("��Ǳ�����","029545600" ,"�����");
	      Community calamity10 = new Community("�غ�������ȸ ������ȸ", "028210928", "�����");
	      Community calamity11 = new Community("����1�� �������γ�ȸ", "01190668494","�����");
	      Community calamity12 = new Community("�������γ�ȸ(����)","01041014029" ,"�����");
	      Community calamity13 = new Community("����������ȸ", "0222906750", "�����");
	      Community calamity14 = new Community("�ٸ��Ի������ȸ", "0222446622","�����");
	      Community calamity15 = new Community("�Ƹ��߿����������","0222906600" ,"�����");
	      Community calamity16 = new Community("���رغ����ùο���","0117515555" ,"�����");
	      
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