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


public class ThreeFragment extends Fragment implements OnClickListener {
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
		
	      Community calamity1 = new Community("û�ֽû�����ȸ", "0432644789", "û�ֽ�");
	      Community calamity2 = new Community("���ֽ� ��ȣ��ȸ", "0438559393","���ֽ�");
	      Community calamity3 = new Community("�������ȸ","0436432080" ,"��õ��");
	      Community calamity4 = new Community("�Ǹ�����ȸ", "0436462843", "��õ��");
	      Community calamity5 = new Community("��õ���ȸ", "0436433342","��õ��");
	      Community calamity6 = new Community("���ϸ� �ǿ�ҹ��","0435420002" ,"������");
	      Community calamity7 = new Community("�Ӹ���� �ǿ�ҹ��", "0116535183", "������");
	      Community calamity8 = new Community("�غ�������ȸ", "0435424791","������");
	      Community calamity9 = new Community("��õ��������ȸ","0437334777" ,"��õ��");
	      Community calamity10 = new Community("�ѱ�����������ȸ����������", "0437421908", "������");
	      Community calamity11 = new Community("�����������������", "01027729113","����");
	      Community calamity12 = new Community("����û��ȸ","01092504251" ,"��õ��");
	      Community calamity13 = new Community("�γ������ڿ���ȸ", "01134672255", "��õ��");
	      Community calamity14 = new Community("�����ǿ�ҹ��", "0114853133","���걺");
	      Community calamity15 = new Community("���� �����ں����","0163493736" ,"������");
	      Community calamity16 = new Community("�ܾ籺 ���������","01094061021" ,"�ܾ籺");
	
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
