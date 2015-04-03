package com.example.capstone.fragment;

import info.androidhive.slidingmenu.R;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


public class FragmentFriends extends Fragment{

	Button Kakao;
	Button SMS;
	Button Community;
	Context thiscontext;
	public FragmentFriends(){}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		return inflater.inflate(R.layout.practice_fragment_friends, container, false);
//        View rootView = inflater.inflate(R.layout.practice_fragment_friends, container, false);
//        thiscontext = container.getContext();
        
//        Kakao = (Button)rootView.findViewById(R.id.KakaoTalkToFriend);
//		Kakao.setOnClickListener(new OnClickListener(){
//			@Override
//			public void onClick(View arg0) {
////				Fragment mFragment = new SendMessage(); 
////			    getFragmentManager().beginTransaction()
////			        .replace(R.id.content_frame, mFragment ).commit();
////				Intent intent = new Intent(getActivity(), SendMessage.class);
////				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
////				startActivity(intent);
//				    // Create new fragment and transaction
//				    Fragment newFragment = new SendMessage(); 
//				    // consider using Java coding conventions (upper first char class names!!!)
//				    FragmentTransaction transaction = getFragmentManager().beginTransaction();
//				    // Replace whatever is in the fragment_container view with this fragment,
//				    // and add the transaction to the back stack
//				    transaction.replace(R.id.practice_fragment_friends, newFragment);
//				    transaction.addToBackStack(null);
//				    // Commit the transaction
//				    transaction.commit(); 
//			}
//		});
//	
//		SMS= (Button)rootView.findViewById(R.id.SMSToFriend);
//		SMS.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View v) {
//				Intent SendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:01020158382"));
//				SendIntent.putExtra("sms_body", "살려주세요!");
//				SendIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
//				startActivity(SendIntent);
//			}			
//		});
//		
//		Community = (Button)rootView.findViewById(R.id.AskCommunityForHelp);
//		Community.setOnClickListener(new OnClickListener(){
//
//			@Override
//			public void onClick(View arg0) {
//				
//			}
//			
//		});
		//return rootView;
	}
	
	
}

