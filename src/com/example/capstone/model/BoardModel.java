package com.example.capstone.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.capstone.CapstoneApplication;
import com.example.capstone.helper.RandomUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class BoardModel implements Parcelable{
	
	public static String WHO_MADE = "whoMade";
	public static String WHO_MADE_ID = "whoMadeId";
	
	public static String ROOT_REF_ID = "ROOT";
	
	public static final int BOARD = 0;
	public static final int REPLY = 1;
	public static final int LIKE = 2;
	
	protected String id;
	protected String title;
	protected int type;
	protected String content;
	protected String whoMade;
	protected String whoMadeId;
	protected String rawCreateDateTime;
	protected String refId;
	protected int likeCount;
	protected int replyCount;
	
	protected String prevLikeId;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWhoMade() {
		return whoMade;
	}
	public void setWhoMade(String whoMade) {
		this.whoMade = whoMade;
	}
	public String getWhoMadeId() {
		return whoMadeId;
	}
	public void setWhoMadeId(String whoMadeId) {
		this.whoMadeId = whoMadeId;
	}
	public String getRawCreateDateTime() {
		return rawCreateDateTime;
	}
	public void setRawCreateDateTime(String createTime) {
		this.rawCreateDateTime = createTime;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public ItDateTime getCreateDateTime() {
		return new ItDateTime(this.rawCreateDateTime);
	}
	public void setCreateDateTime(ItDateTime dateTime) {
		this.rawCreateDateTime = dateTime.toString();
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public String getPrevLikeId() {
		return prevLikeId;
	}
	public void setPrevLikeId(String prevLikeId) {
		this.prevLikeId = prevLikeId;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public boolean isMine(){
		String userId = CapstoneApplication.getGlobalApplicationContext().getPrefHelper().getString(BoardModel.WHO_MADE_ID);
		return userId.equals(this.getWhoMadeId());
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	public JsonElement toJson() {
//		String jsonStr = new GsonBuilder().registerTypeAdapter(this.getClass(), new AbstractItemModelAdapter()).create().toJson(this);
//		return new Gson().fromJson(jsonStr, JsonElement.class);
		return new Gson().fromJson(this.toString(), JsonElement.class);
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(this.toString());
	}
	
	public static final Parcelable.Creator<BoardModel> CREATOR = new Creator<BoardModel>(){
		public BoardModel createFromParcel(Parcel in){
			String json = in.readString();
			return new Gson().fromJson(json, BoardModel.class);
		}
		public BoardModel[] newArray(int size){
			return new BoardModel[size]; 
		}
	};
	
	public static BoardModel newBoardRand() {
		BoardModel board = new BoardModel();
		
		board.setTitle(RandomUtil.getObjName());
		board.setContent(RandomUtil.getLongString());
		board.setCreateDateTime(ItDateTime.getToday());
		board.setLikeCount(RandomUtil.getInt());
		board.setWhoMade(RandomUtil.getName());
		return board;
	}

//	private class AbstractItemModelAdapter implements JsonSerializer<T> {
//
//		@Override
//		public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
//			Gson gson = new Gson();
//			JsonObject json = gson.fromJson(gson.toJson(src), JsonObject.class);
//			JsonObject jo = new JsonObject();
//			jo.addProperty("table", src.getClass().getSimpleName());
//			jo.add("data", json);
//			return jo;
//		}
//	}
}
