package com.example.capstone.activities;

import info.androidhive.slidingmenu.R;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Game extends Activity{
	RelativeLayout TopLayout ;
    ImageView iv[] =  new ImageView[10];
	ImageView ex;
	ImageView img;
    Animation animation, animation1;
	TextView Score;
	int i=0;								//이미지 할당 
	int layoutwidth,layoutheight;
	int imgwidth,getWidth,getHeight;
	int score=0;
	
	private Character character;
	public static int X = 350;
	
	ImageSize s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main);
       
        img = (ImageView)findViewById(R.id.rabbit);

          
        TopLayout = (RelativeLayout)findViewById(R.id.layout);
        Score=(TextView)findViewById(R.id.score);
        
        //단말기 사이즈를 불러온다. and ic-launcher size :144
        getDisplaySize();
        
        // 이미지 셋팅한다
        ImageSettings();
    }

	private void ImageSettings() {
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		for(i=0; i<10 ; i++){
			if(i%3==0){
				iv[i]= new ImageView(this);
				iv[i].setBackgroundResource(R.drawable.ic_launcher); 
			}
			else if(i%3==1){
				iv[i]= new ImageView(this);
				iv[i].setBackgroundResource(R.drawable.ic_launcher);
			}
			else{
				iv[i]= new ImageView(this);
				iv[i].setBackgroundResource(R.drawable.ic_launcher);
			} 
		}
	}
	
	private void getDisplaySize() {
		Display display = getWindowManager().getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics( metrics );
		layoutwidth = metrics.widthPixels;
		layoutheight = metrics.heightPixels;		
	}
	
	private void dropImage(final ImageView image,final int startTime, final int duration, final int margin, final int getWidth) {        
		animation = new TranslateAnimation(0,0,0,layoutheight-200*3);
        animation.setInterpolator(new AccelerateInterpolator());
		animation.setStartOffset(startTime);
        animation.setDuration(duration);
        animation.setFillAfter(false);        
        
        image.startAnimation(animation);
        animation.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationEnd(Animation animation) {
				  if(X-30 < margin && margin+ 144 < X+getWidth+30 ){
					  image.setVisibility(View.INVISIBLE);
					  score+=50;
					  Score.setText(String.valueOf(score));
				  }
				  else{
					  dropImageComplete(image, margin);
				  }
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
			}
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
			}
        	
        });
	}

	protected void dropImageComplete(ImageView image, int margin) {
		animation1 = new TranslateAnimation(0,0,layoutheight-200*3-10, layoutheight);
		animation1.setDuration(1500);
		image.startAnimation(animation1);		
	}
	
	public void onWindowFocusChanged(boolean hasFocus){
		super.onWindowFocusChanged(hasFocus);
		
		getWidth=img.getWidth();
		getHeight=img.getHeight();
		Toast.makeText(getApplication(), "img:"+String.valueOf(getWidth)+"(H):"+String.valueOf(getHeight), 1000).show();
		
		 Random rn = new Random();
	    	for(i=0;i<10;i++){
	    		int margin = rn.nextInt(800);
	            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
	            lp.setMargins(margin, 0, 0, 0);
		        iv[i].setLayoutParams(lp);
		        TopLayout.addView(iv[i]);
		    
		        dropImage(iv[i],rn.nextInt(10000),5000,margin,getWidth);
		        
	    	}
	    	
	    	character = (Character)findViewById(R.id.character);
	    	  
	    	  Button btnLeft = (Button)findViewById(R.id.btnLeft);
	    	  btnLeft.setOnClickListener(new OnClickListener() {
	    	   
	    	   @Override
	    	   public void onClick(View v) {
	    	    // TODO Auto-generated method stub
	    		   if(X - 30 <= getWidth)
	    			   X = 10;
	    		   else{
	    			   X -= 60;
	    			   Toast.makeText(getApplication(), String.valueOf(X), 500).show();
	    		   }
	    	   }
	    	  });
	    	  
	    	  Button btnRight = (Button)findViewById(R.id.btnRight);
	    	  btnRight.setOnClickListener(new OnClickListener() {
	    	   
	    	   @Override
	    	   public void onClick(View v) {
	    	    // TODO Auto-generated method stub
	    		   if(X < layoutwidth - getWidth ){
	    			   X+=60;
	    			   Toast.makeText(getApplication(), String.valueOf(X), 500).show();
	    		   }
	    		   else
	    			   X = layoutwidth - getWidth;
	    	   }
	    	  });
	    	  
	}
}