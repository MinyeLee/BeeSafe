package com.example.capstone.model;

public class Community {
	private int id;
	private String data1;
	private String data2;
	private String data3;
	
	public Community() {
		
	}
	public Community(String data1, String data2, String data3) {
		this.data1 = data1;
		this.data2 = data2;
		this.data3 = data3;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	public String getData3() {
		return data3;
	}
	public void setData3(String data3) {
		this.data3 = data3;
	}
}
