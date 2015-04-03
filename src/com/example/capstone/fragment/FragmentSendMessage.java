package com.example.capstone.fragment;

import com.example.capstone.model.CurrentLocation;
import com.kakao.KakaoLink;
import com.kakao.KakaoParameterException;
import com.kakao.KakaoTalkLinkMessageBuilder;

import info.androidhive.slidingmenu.R;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

public class FragmentSendMessage extends Fragment implements OnClickListener {
	ImageButton Kakao, SMS;
	Button Community;
	Button Drawn, Fire, CarCrash, BuildingDown, Hurt, Kidnapped;
	String drawn, fire, carcrash, buildingdown, hurt, kidnapped;
	
	CheckBox address;
	EditText message;
	Button send;
	CurrentLocation location;
	
	String FullMessage;
	String CheckList=" ";
	public FragmentSendMessage(){}
	
	private KakaoLink kakaoLink;
	private KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder;
	Context thiscontext;
	@Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_send_message, container, false);
         
        location= new CurrentLocation(getActivity());
		address = (CheckBox)rootView.findViewById(R.id.addressCheckBox);
		address.setText(location.ReadyForSendMessage());

		
		drawn="물에 빠졌어요ㅠ_ㅠ";
		fire="불났쪄요ㅠ_ㅠ";
		carcrash="교통사고 났쪄요ㅠㅠ";
		buildingdown="건물이 무너져여여여여ㅠㅠ";
		hurt="사람이 다쳐쏘ㅠㅠ";
		kidnapped="유괴당해쪄요ㅠㅠㅠㅠㅠ";
		Drawn=(Button)rootView.findViewById(R.id.drawn);
		Fire=(Button)rootView.findViewById(R.id.fire);
		CarCrash=(Button)rootView.findViewById(R.id.carcrash);
		BuildingDown=(Button)rootView.findViewById(R.id.buildingdown);
		Hurt=(Button)rootView.findViewById(R.id.hurt);
		Kidnapped=(Button)rootView.findViewById(R.id.kidnapped);
		
		Drawn.setOnClickListener(this);
		Fire.setOnClickListener(this);
		CarCrash.setOnClickListener(this);
		BuildingDown.setOnClickListener(this);
		Hurt.setOnClickListener(this);
		Kidnapped.setOnClickListener(this);

		thiscontext = container.getContext();
		
		try{
			kakaoLink = KakaoLink.getKakaoLink(thiscontext);
			kakaoTalkLinkMessageBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();
		}catch(KakaoParameterException e){
			e.printStackTrace();
			//alert(e.getMessage());
		}
		message = (EditText)rootView.findViewById(R.id.sendMessage);
    	Kakao = (ImageButton)rootView.findViewById(R.id.KakaoToFriends);
		Kakao.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				FullMessage = address.getText().toString()+"##"+CheckList+"##"+message.getText().toString();

				try{
					kakaoTalkLinkMessageBuilder.addText(FullMessage);
//					 kakaoTalkLinkMessageBuilder.addImage(stringImage, 320, 320);
//	                    kakaoTalkLinkMessageBuilder.addWebLink("블로그 이동", stringUrl);
//
//	                    kakaoTalkLinkMessageBuilder.addAppButton("앱열기",
//	                            new AppActionBuilder()
//	                                    .setAndroidExecuteURLParam("target=main")
//	                                    .setIOSExecuteURLParam("target=main", AppActionBuilder.DEVICE_TYPE.PHONE).build());
					kakaoLink.sendMessage(kakaoTalkLinkMessageBuilder.build(),  container.getContext());
				}catch(KakaoParameterException e){
					e.printStackTrace();
					//alert(e.getMessage());
				}
			}
		});	
			
	
		
		SMS= (ImageButton)rootView.findViewById(R.id.SMSToFriends);
		SMS.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {

				FullMessage = address.getText().toString()+"##"+CheckList+"##"+message.getText().toString();

				Intent SendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"));
				SendIntent.putExtra("sms_body", FullMessage);
				startActivity(SendIntent);
			}			
		});
		
		return rootView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.drawn:
			if(!Drawn.isSelected()){
				Drawn.setSelected(true);
				CheckList+=drawn;
			}
			else{
				Drawn.setSelected(false);
				CheckList=CheckList.replace(drawn, "");
			}
			break;
		case R.id.fire:
			if(!Fire.isSelected()){
				Fire.setSelected(true);
				CheckList+=fire;
			}
			else{
				Fire.setSelected(false);
				CheckList=CheckList.replace(fire, "");
			}
			break;

		case R.id.carcrash:
			if(!CarCrash.isSelected()){
				CarCrash.setSelected(true);
				CheckList+=carcrash;
			}
			else{
				CarCrash.setSelected(false);
				CheckList=CheckList.replace(carcrash, "");
			}
			break;

		case R.id.buildingdown:
			if(!BuildingDown.isSelected()){
				BuildingDown.setSelected(true);
				CheckList+=buildingdown;
			}
			else{
				BuildingDown.setSelected(false);
				CheckList=CheckList.replace(buildingdown, "");
			}
			break;

		case R.id.hurt:
			if(!Hurt.isSelected()){
				Hurt.setSelected(true);
				CheckList+=hurt;
			}
			else{
				Hurt.setSelected(false);
				CheckList=CheckList.replace(hurt, "");
			}
			break;

		case R.id.kidnapped:
			if(!Kidnapped.isSelected()){
				Kidnapped.setSelected(true);
				CheckList+=kidnapped;
			}
			else{
				Kidnapped.setSelected(false);
				CheckList=CheckList.replace(kidnapped, "");
			}
			break;

		}
	}
}
