package com.example.capstone.model;

import java.util.TimeZone;

import android.content.res.Resources;
import android.text.format.Time;

// 20141113014345 --> 2014-11-13 01:43:45
public class ItDateTime {

	private final int DAY_SECOND = 86400;
	private final int HOUR_SECOND = 3600;
	private final int MINUTE_SECOND = 60;

	private Time dateTime;

	public ItDateTime(String rawDateTime) {
		dateTime = new Time(Time.TIMEZONE_UTC);
		int year = Integer.parseInt(rawDateTime.substring(0, 4));
		int month = Integer.parseInt(rawDateTime.substring(4, 6));
		int date = Integer.parseInt(rawDateTime.substring(6, 8));
		int hour = Integer.parseInt(rawDateTime.substring(8, 10));
		int minute = Integer.parseInt(rawDateTime.substring(10, 12));
		int second = Integer.parseInt(rawDateTime.substring(12, 14));
		dateTime.set(second, minute, hour, date, month-1, year);
		dateTime.switchTimezone(TimeZone.getDefault().getID());
	}

	public static ItDateTime getToday() {
		Time time = new Time();
		time.setToNow();
		return new ItDateTime(time.format("%Y%m%d000000"));
	}

	public ItDateTime getYesterday() {
		dateTime.set(dateTime.monthDay-1, dateTime.month, dateTime.year);
		dateTime.normalize(true);
		return new ItDateTime(dateTime.format("%Y%m%d000000"));
	}

	public String toDate() {
		return dateTime.format("%Y%m%d");
	}

	public String toPrettyTime() {
		return dateTime.format("%H:%M");
	}

	public String toPrettyDate() {
		return dateTime.format("%Y-%m-%d");
	}

	public String toPrettyDateTime() {
		return dateTime.format("%Y-%m-%d %H:%M");
	}

	public int getElapsedDate() {
		Time nowTime = new Time();
		nowTime.setToNow();

		int nowJulianDay = Time.getJulianDay(nowTime.normalize(true), nowTime.gmtoff);
		int itJulianDay = Time.getJulianDay(dateTime.normalize(true), dateTime.gmtoff);
		return nowJulianDay - itJulianDay;
	}

	public String getElapsedTime(Resources resources, int elapsedSecond){
		if(elapsedSecond/HOUR_SECOND > 0){
			return (elapsedSecond/HOUR_SECOND) + "시간 경과";
		} else if(elapsedSecond/MINUTE_SECOND > 0) {
			return (elapsedSecond/MINUTE_SECOND) + "분 경과";
		} else {
			if(elapsedSecond < 0) elapsedSecond = 0;
			return elapsedSecond + "초 경과";
		}
	}
	
	public String getElapsedDateTime(Resources resources) {
		Time nowTime = new Time();
		nowTime.setToNow();

		int elapsedDate = getElapsedDate();
		if(elapsedDate < 1){
			// In a day
			int nowTimeSecond = nowTime.second + nowTime.minute*MINUTE_SECOND + nowTime.hour*HOUR_SECOND;
			int dateTimeSecond = dateTime.second + dateTime.minute*MINUTE_SECOND + dateTime.hour*HOUR_SECOND;
			return getElapsedTime(resources, nowTimeSecond - dateTimeSecond);
		} else if(elapsedDate == 1) {
			int nowTimeSecond = nowTime.second + nowTime.minute*MINUTE_SECOND + nowTime.hour*HOUR_SECOND + DAY_SECOND;
			int dateTimeSecond = dateTime.second + dateTime.minute*MINUTE_SECOND + dateTime.hour*HOUR_SECOND;
			int elapsedSeoncd = nowTimeSecond - dateTimeSecond;
			
			if(elapsedSeoncd < DAY_SECOND){
				// In a day
				return getElapsedTime(resources, elapsedSeoncd);
			} else {
				// 1 day
				return "어제" + " " + toPrettyTime();
			}
		} else if(elapsedDate < 3) {
			// 2 day
			return elapsedDate + "일 경과" + " " + toPrettyTime();
		} else {
			// More than 3 day
			return toPrettyDateTime();
		}
	}

	@Override
	public String toString() {
		return dateTime.format("%Y%m%d%H%M%S");
	}
}
