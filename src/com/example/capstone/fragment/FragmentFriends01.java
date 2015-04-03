package com.example.capstone.fragment;

import info.androidhive.slidingmenu.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentFriends01 extends Fragment{
	Button Kakao;
//	Context thiscontext;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	View rootView = inflater.inflate(R.layout.fragment_friends, container, false);
	//View rootView = new View(getActivity().getApplicationContext());
	//rootView = inflater.inflate(resource, root)
	//	thiscontext = container.getContext();
	 Kakao = (Button)rootView.findViewById(R.id.KakaoTalkToFriend);
		Kakao.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
//				Fragment mFragment = new SendMessage(); 
//			    getFragmentManager().beginTransaction()
//			        .replace(R.id.content_frame, mFragment ).commit();
//				Intent intent = new Intent(getActivity(), SendMessage.class);
//				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
//				startActivity(intent);
				    // Create new fragment and transaction
				    Fragment newFragment = new SendMessage(); 
//				    Bundle args = new Bundle();
//				    args.putInt("myInt", myInt);
//				    newFragment.setArguments(args);
				    // consider using Java coding conventions (upper first char class names!!!)
				    FragmentTransaction transaction = getFragmentManager().beginTransaction();
				    // Replace whatever is in the fragment_container view with this fragment,
				    // and add the transaction to the back stack
				    //transaction.hide();
				    transaction.replace(R.id.practice_fragment_friends, newFragment);
				   // transaction.hide(FragmentFriends01.this);
				   // transaction.hide(FragmentFriends01.this);
				    //store old fragment to stack by using tag
				    transaction.addToBackStack(null);
				    // Commit the transaction
				    transaction.commit(); 
			}
		});
	return rootView;
}

}
