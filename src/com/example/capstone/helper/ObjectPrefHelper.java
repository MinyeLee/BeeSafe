package com.example.capstone.helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ObjectPrefHelper {

	private PrefHelper mPrefHelper;

	public void setPrefHelper(PrefHelper pref) {
		mPrefHelper = pref;
	}

	public <E> void put(E obj) {
		Class<?> clazz = obj.getClass();
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (!isGetter(method)) continue;
			mPrefHelper.put(clazz.getName()+removePrefix(method.getName()), invokeGetMethod(obj, method));
		}
	}

	public <E> E get(Class<E> clazz) {
		E obj = null;
		try {
			obj = clazz.newInstance();
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				if (!isSetter(method)) continue;
				Class<?> paramClazz = method.getParameterTypes()[0];
				invokeSetMethod(obj, method, mPrefHelper.get(clazz.getName()+removePrefix(method.getName()), paramClazz));
			}
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		return obj;
	}

	public <E> void remove(Class<E> clazz) {
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (!isGetter(method)) continue;
			mPrefHelper.remove(clazz.getName()+removePrefix(method.getName()));
		}
	}

	private Object invokeGetMethod(Object obj, Method method) {
		Object object = null;
		try {
			object = method.invoke(obj);
		} catch (IllegalAccessException e) {
		} catch (IllegalArgumentException e) {
		} catch (InvocationTargetException e) {
		}
		return object;
	}

	private void invokeSetMethod(Object obj, Method method, Object arg) {
		try {
			method.invoke(obj, arg);
		} catch (IllegalAccessException e) {
		} catch (IllegalArgumentException e) {
		} catch (InvocationTargetException e) {
		}
	}

	private boolean isGetter(Method method) {
		if (method.getName().equals("getClass")) return false;
		if (!(method.getName().startsWith("get") || method.getName().startsWith("is")))
			return false;
		if (method.getParameterTypes().length != 0)
			return false;
		if (void.class.equals(method.getReturnType()))
			return false;
		return true;
	}

	private boolean isSetter(Method method) {
		if (!method.getName().startsWith("set"))
			return false;
		if (method.getParameterTypes().length != 1)
			return false;
		return true;
	}

	private String removePrefix(String name) {
		return name.split("(is)|(get)|(set)")[1];
	}
}
