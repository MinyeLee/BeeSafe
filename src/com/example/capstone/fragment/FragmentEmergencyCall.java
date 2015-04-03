package com.example.capstone.fragment;

import info.androidhive.slidingmenu.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.capstone.adapter.ListviewContactAdapter;
import com.example.capstone.model.GPSInfo;

public class FragmentEmergencyCall extends Fragment implements OnItemClickListener, OnClickListener{
	
	ImageButton phone;
	ImageButton sms;
	static String targetName=null;
	static String targetNumber;
	Context thiscontext;
	public ProgressBar pb1=null;
	private GPSInfo gps;
	String address;
	ImageView iv;
	
	public FragmentEmergencyCall(){}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
		Log.e("ERROR", "FragmentEmergencyCall");
		 View rootView = inflater.inflate(R.layout.emergency_fragment_listview, container, false);
		    thiscontext = container.getContext();
		    String[] lista =getResources().getStringArray(R.array.phonenumber);
		    
		    final ListviewContactAdapter listAdapter = new ListviewContactAdapter(thiscontext, R.layout.list_item_text_with_check , lista);
		    ListView listView = (ListView)rootView.findViewById(R.id.emergency_call_listview);
		    listView.setAdapter(listAdapter);
		    listView.setOnItemClickListener( new OnItemClickListener(){
		    	@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					switch(position){
					case 0 :
						targetName="화재신고 119"; targetNumber="119";
						break;
					case 1:
						targetName="경찰신고 112"; targetNumber="112";
						break;
					case 2:
						targetName="해양경찰청 122"; targetNumber="122";
						break;
					case 3:
						targetName="국정원 111"; targetNumber="11";
						break;
					case 4:
						targetName="산악안전1688-3119"; targetNumber="16883119";
						break;
					case 5:
						targetName="TEST번호"; targetNumber="119";
						break;
					default:
						targetName="화재신고 119"; targetNumber="119";
					}
					listAdapter.selectedPosition = position;
					listAdapter.notifyDataSetChanged();
				}
		    });

			iv = (ImageView)rootView.findViewById(R.id.reply_like_it);

		    phone = (ImageButton)rootView.findViewById(R.id.call);
	        phone.setOnClickListener(this);
	        
	        sms = (ImageButton)rootView.findViewById(R.id.practicebluebtn);
	        sms.setOnTouchListener(new View.OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					if(v.getId() == R.id.practicebluebtn){
						switch (event.getAction()){
					
						case MotionEvent.ACTION_DOWN:
							startProgressBarThread();
							break;
						case MotionEvent.ACTION_UP:
							pb1.setProgress(0);
							if (CurrentPosition != 100){
								iv.setImageResource(0);
								stopProgressBarThread();
								break;
							}
							else if (CurrentPosition == 100){
								stopProgressBarThread();
								String destination = "01020158382";
								String message = ReadyForSendMessage();
								SmsManager smsMgr = SmsManager.getDefault();
								smsMgr.sendTextMessage(destination, null, message, null, null);
								break;
							}
						default:
							break;
						}
					}
					
					return false;
				}
				
				private String ReadyForSendMessage() {

					 gps = new GPSInfo(getActivity());
		               
					 if (gps.isGetLocation()) {
		                    double latitude = gps.getLatitude();
		                    double longitude = gps.getLongitude();
		                    address=String.valueOf(findAddress(latitude, longitude));
		                } else 
		                {
		                    gps.showSettingsAlert();
		                }
						return address;
				}

				private StringBuffer findAddress(double lat, double lng) {
					StringBuffer bf = new StringBuffer();
			        Geocoder geocoder =  new Geocoder(getActivity(), Locale.KOREA);

			        List<Address> address;
			        try {
			          if (geocoder != null) {
			                address = geocoder.getFromLocation(lat, lng, 1);
			               if (address != null && address.size() > 0) {
			                    String currentLocationAddress = address.get(0).getAddressLine(0).toString();
			                    
			                    bf.append(currentLocationAddress).append("#");
			                    bf.append(lat).append("#");
			                    bf.append(lng);
			                }
			            }
			            
			         } catch (IOException e) {
			          //  Toast.makeText(getApplicationContext(), "Exception Error", Toast.LENGTH_LONG).show();

			             e.printStackTrace();
			         }
					return bf;			
				}
			});
	        
	 
	        pb1 = (ProgressBar)rootView.findViewById(R.id.pb1);
	        //pb1.setVisibility(ProgressBar.GONE);
		    return rootView;
	}
	
	

	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
			case R.id.call :
				Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+targetNumber));
                startActivity(i);
	   			break;
			default:
				break;
		}
	}
	
	private volatile Thread theProgressBarThread1;
   	public int CurrentPosition = 0;
   	
   	private synchronized void startProgressBarThread(){
   		if(theProgressBarThread1 == null){
   			theProgressBarThread1 = new Thread(null, backgroundThread1, "startProgressBarThread");
   			CurrentPosition = 0;
   			theProgressBarThread1.start();
   		}
   	}
   	
   	private synchronized void stopProgressBarThread(){
   		if(theProgressBarThread1 != null){
   			Thread tmpThread = theProgressBarThread1;
   			theProgressBarThread1 = null;
   			tmpThread.interrupt();
   		}
   		//pb1.setVisibility(ProgressBar.GONE);
   		
   	}
   	
   	private Runnable backgroundThread1 = new Runnable(){
   		@Override
   		public void run(){
   			if(Thread.currentThread() == theProgressBarThread1){
   				CurrentPosition = 0;
   				final int total = 100;
   				while(CurrentPosition < total) {
   					try{
   						progressBarHandle.sendMessage(progressBarHandle.obtainMessage());
   						Thread.sleep(30);
   					} catch(final InterruptedException e) {
   						return;
   					} catch(final Exception e) {
   						return;
   					}
   				}
   			}
   		}
   		
   		Handler progressBarHandle = new Handler() {
   			@Override
   			public void handleMessage(Message msg) {
   				CurrentPosition++;
   				pb1.setProgress(CurrentPosition);
   				
   				if(CurrentPosition == 33){
					iv.setImageResource(R.drawable.balloon1);
				}
				else if(CurrentPosition == 66){
					iv.setImageResource(R.drawable.balloon2);
				}
				else if(CurrentPosition == 99){
					iv.setImageResource(R.drawable.balloon3);
				}
				else if(CurrentPosition == 100){
					stopProgressBarThread();
	   	   		}
   					
   			}
   		};
   	};

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}
  
	
}