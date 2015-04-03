package com.example.capstone.activities;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageSize extends Activity{
	ImageView img;
	int getWidth;
	public ImageSize(ImageView img) {
		this.img= img;
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus){
		super.onWindowFocusChanged(hasFocus);
		
		getWidth=img.getWidth();
		Toast.makeText(getApplication(), "img:"+String.valueOf(getWidth), 1000).show();
	}
}
