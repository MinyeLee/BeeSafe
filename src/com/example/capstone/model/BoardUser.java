package com.example.capstone.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

public class BoardUser implements Parcelable {

	public static final String INTENT_KEY = "IT_USER_INTENT_KEY";

	@com.google.gson.annotations.SerializedName("id")
	private String id;
	@com.google.gson.annotations.SerializedName("itUserId")
	private String itUserId;
	@com.google.gson.annotations.SerializedName("nickName")
	private String nickName;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItUserId() {
		return itUserId;
	}
	public void setItUserId(String itUserId) {
		this.itUserId = itUserId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void readItUser(BoardUser itUser) {
		this.setId(itUser.getId());
		this.setItUserId(itUser.getItUserId());
		this.setNickName(itUser.getNickName());
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	public boolean isLoggedIn() {
		return true; 
	}


	public boolean isMe(){
		return true;
	}


	/*
	 * Parcelable
	 */
	public static final Parcelable.Creator<BoardUser> CREATOR = new Creator<BoardUser>(){
		public BoardUser createFromParcel(Parcel in){
			return new BoardUser(in);
		}
		public BoardUser[] newArray(int size){
			return new BoardUser[size]; 
		}
	};

	public BoardUser(Parcel in){
		readToParcel(in);
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.toString());
	}

	public void readToParcel(Parcel in){
		this.readItUser(new Gson().fromJson(in.readString(), BoardUser.class));
	}

	@Override
	public int describeContents() {
		return 0;
	}
}
