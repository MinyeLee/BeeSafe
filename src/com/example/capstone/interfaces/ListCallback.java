package com.example.capstone.interfaces;

import java.util.List;

public interface ListCallback<E> {
	public void onCompleted(List<E> list, int count);
}
