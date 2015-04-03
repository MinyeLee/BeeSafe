package com.example.capstone.model;

import android.support.v4.app.Fragment;

import com.google.gson.Gson;

public class BoardException {
	public enum TYPE {
		NETWORK_UNAVAILABLE,
		SERVER_ERROR
	}
	private Fragment fragment;
	private TYPE type;
	
	public BoardException(Fragment fragment, TYPE type) {
		this.fragment = fragment;
		this.type = type;
	}
	
	public Fragment getFragment() {
		return fragment;
	}
	
	public TYPE getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
