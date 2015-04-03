package com.example.capstone.fragment;

import info.androidhive.slidingmenu.R;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.kakao.KakaoLink;
import com.kakao.KakaoParameterException;
import com.kakao.KakaoTalkLinkMessageBuilder;

public class SendMessage extends Fragment {
	private KakaoLink kakaoLink;
	private KakaoTalkLinkMessageBuilder kakaoTalkLinkMessageBuilder;
	Context thiscontext;
	@Override
	public View onCreateView(LayoutInflater inflater, final ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.message, container, false);//message
		thiscontext = container.getContext();
		
		try{
			kakaoLink = KakaoLink.getKakaoLink(thiscontext);
			kakaoTalkLinkMessageBuilder = kakaoLink.createKakaoTalkLinkMessageBuilder();
		}catch(KakaoParameterException e){
			e.printStackTrace();
			//alert(e.getMessage());
		}
		final String stringText = "kakaolinktesttext";
		Button button = (Button)rootView.findViewById(R.id.Send);
		EditText editText1 = (EditText)rootView.findViewById(R.id.sendMessage);
		//final String text = editText1.getText().toString();
		button.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					try{
						kakaoTalkLinkMessageBuilder.addText(stringText);
//						 kakaoTalkLinkMessageBuilder.addImage(stringImage, 320, 320);
//		                    kakaoTalkLinkMessageBuilder.addWebLink("블로그 이동", stringUrl);
//
//		                    kakaoTalkLinkMessageBuilder.addAppButton("앱열기",
//		                            new AppActionBuilder()
//		                                    .setAndroidExecuteURLParam("target=main")
//		                                    .setIOSExecuteURLParam("target=main", AppActionBuilder.DEVICE_TYPE.PHONE).build());
						kakaoLink.sendMessage(kakaoTalkLinkMessageBuilder.build(),  container.getContext());
					}catch(KakaoParameterException e){
						e.printStackTrace();
						//alert(e.getMessage());
					}
				}
			});
		return rootView;
	}
//	private void alert(String message){
//		new AlertDialog.Builder(this)
//        .setIcon(android.R.drawable.ic_dialog_alert)
//        .setTitle(R.string.app_name)
//        .setMessage(message)
//        .setPositiveButton(android.R.string.ok, null)
//        .create().show();
//}
}