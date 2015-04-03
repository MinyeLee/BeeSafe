package com.example.capstone.activities;

import info.androidhive.slidingmenu.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Character extends View{

 private Paint paint;
 private Bitmap bitmap;

 public Character(Context context, AttributeSet attrs) {
	  super(context, attrs);
	  // TODO Auto-generated constructor stub
	  bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rabbit_1);
	 }
	
	 @Override
	 protected void onDraw(Canvas canvas) {
	  // TODO Auto-generated method stub
	  super.onDraw(canvas);
	  canvas.drawBitmap(bitmap, Game.X, 1400, paint);
	  invalidate();
	 } 
}