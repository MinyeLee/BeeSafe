package com.example.capstone.model;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

public class GPSInfo extends Service implements LocationListener {
	  
    private final Context mContext;
  
    // Çö?ç GPS »ç¿ë?¯¹«
    boolean isGPSEnabled = false;
  
    // ³×Æ®¿öÅ© »ç¿ë?¯¹« 
    boolean isNetworkEnabled = false;
  
    // GPS »óÅÂ°ª
    boolean isGetLocation = false;
  
    Location location; 
    double lat; // ?§µµ 
    double lon; // °æµµ
  
    // ÃÖ¼Ò GPS Á¤º¸ ¾÷µ¥?ÌÆ® °Å¸® 10¹ÌÅÍ 
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; 
  
    // ÃÖ¼Ò GPS Á¤º¸ ¾÷µ¥?ÌÆ® ½Ã°£ ¹Ð¸®¼¼ÄÁ?Ì¹Ç·Î 1ºÐ
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; 
  
    protected LocationManager locationManager;
  
    public GPSInfo(Context context) {
        this.mContext = context;
        getLocation();
    }
  
    public Location getLocation() {
        try {
            locationManager = (LocationManager) mContext
                    .getSystemService(LOCATION_SERVICE);
  
            // GPS Á¤º¸ °¡Á®¿?±â 
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
         
            // Çö?ç ³×Æ®¿öÅ© »óÅÂ °ª ¾Ë¾Æ¿?±â 
            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

  
            if (!isGPSEnabled && !isNetworkEnabled) {
                // GPS ¿Í ³×Æ®¿öÅ©»ç¿ë?Ì °¡´ÉÇÏÁö ¾Ê?»¶§ ¼Ò½º ±¸Çö
            } else {
                this.isGetLocation = true;
                // ³×Æ®¿öÅ© Á¤º¸·Î ºÎÅÍ ?§Ä¡°ª °¡Á®¿?±â 
                if (isNetworkEnabled) {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    
                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                       // location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        if (location != null) {
                            // ?§µµ °æµµ ?ú?å 
                            lat = location.getLatitude();
                            lon = location.getLongitude();
                        }
                    }
                }
                 
                if (isGPSEnabled) {
                    if (location == null) {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        if (locationManager != null) {
                            location = locationManager
                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                lat = location.getLatitude();
                                lon = location.getLongitude();
                            }
                        }
                    }
                }
            }
  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }
      
   //GPS Á¾·á 
    public void stopUsingGPS(){
        if(locationManager != null){
            locationManager.removeUpdates(GPSInfo.this);
        }       
    }
      
   //?§µµ °ª?» °¡Á® ¿É´Ï´Ù. 
    public double getLatitude(){
        if(location != null){
            lat = location.getLatitude();
        }
        return lat;
    }
      
   //°æµµ °ª?» °¡Á® ¿É´Ï´Ù. 
    public double getLongitude(){
        if(location != null){
            lon = location.getLongitude();
        }
        return lon;
    }
      
  //GPS³ª WIFI°¡ ÄÑÁ® ?Ö´ÂÁö Á¤º¸¸¦ °¡Á® ¿É´Ï´Ù. 
    public boolean isGetLocation() {
        return this.isGetLocation;
    }
      
    
    // GPS Á¤º¸¸¦ °¡Á®¿?Áö ¸øÇß?»¶§ , ¼³Á¤°ª?¸·Î °¥Áö ¹°¾îº¸´Â alert Ã¢
     
    public void showSettingsAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
 
        alertDialog.setTitle("GPS »ç¿ë?¯¹«¼ÂÆÃ");
        alertDialog.setMessage("GPS ¼ÂÆÃ?Ì µÇÁö ¾Ê¾Ò?»¼öµµ ?Ö½?´Ï´Ù.  \n ¼³Á¤Ã¢?¸·Î °¡½Ã°Ú½?´Ï±î?");
                                        
   
        // OK ¸¦ ´©¸£°Ô µÇ¸é ¼³Á¤Ã¢?¸·Î ?Ìµ¿ÇÕ´Ï´Ù. 
        alertDialog.setPositiveButton("Settings",  new DialogInterface.OnClickListener() {
                               
            public void onClick(DialogInterface dialog,int which) {
                Intent intent = new Intent (Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                mContext.startActivity(intent);
            }
        });
        
        // Cancle ÇÏ¸é Á¾·á ÇÕ´Ï´Ù. 
        alertDialog.setNegativeButton("Cancel", 
                              new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
            }
        });
 
        alertDialog.show();
    }
  
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
 
    public void onLocationChanged(Location location) {
        // TODO Auto-generated method stub
         
    }
 
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
         
    }
 
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub
         
    }
 
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub
         
    }
}
