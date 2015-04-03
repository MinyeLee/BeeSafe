package com.example.capstone.fragment;

import info.androidhive.slidingmenu.R;
import info.androidhive.slidingmenu.R.id;
import info.androidhive.slidingmenu.R.layout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

public class FragmentSettings extends Fragment {
	SeekBar seekbar;
	TextView status;
	
	public FragmentSettings(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        seekbar =(SeekBar)rootView.findViewById(R.id.seekbar);
        status= (TextView)rootView.findViewById(R.id.status);
        
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				if(progress<10){
					progress=10;
					seekbar.setProgress(progress);
				}
				status.setText("Display Control: "+progress);
				
				WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
				params.screenBrightness = (float) progress/100;
				getActivity().getWindow().setAttributes(params);
				android.provider.Settings.System.putInt(getActivity().getContentResolver(),android.provider.Settings.System.SCREEN_BRIGHTNESS,progress*(255/100)+(int)(0.6*progress));
			}
		});
        return rootView;
    }
}
