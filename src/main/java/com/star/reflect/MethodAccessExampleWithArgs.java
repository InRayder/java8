package com.star.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class MethodAccessExampleWithArgs {

	private final int i;

	public MethodAccessExampleWithArgs(int i) {
		this.i = i;
	}

	private void bar(int j, String msg) {
		System.out.println("Private Method \'bar\' successfully accessed : " + i + ", " + j + " : " + msg + "!");
	}

	public static Method makeMethod() {
		Method method = null;
		try {
			method = MethodAccessExampleWithArgs.class.getDeclaredMethod("bar",
					new Class[] { int.class, String.class });
			method.setAccessible(true);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return method;
	}

	public static MethodHandle makeMtd() {
		MethodHandle mh = null;
		MethodType desc = MethodType.methodType(void.class, int.class, String.class);

		try {
			mh = MethodHandles.lookup().findVirtual(MethodAccessExampleWithArgs.class, "bar", desc);
			System.out.println("mh=" + mh);

		} catch (NoSuchMethodException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mh;
	}

}
