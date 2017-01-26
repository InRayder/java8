package com.star.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class MethodAccessMain {

	@Test
	public void withReflectionArgs() {
		Method method = MethodAccessExampleWithArgs.makeMethod();

		MethodAccessExampleWithArgs mh0 = new MethodAccessExampleWithArgs(0);
		MethodAccessExampleWithArgs mh1 = new MethodAccessExampleWithArgs(1);

		try {
			System.out.println("Invocation using Reflection");
			method.invoke(mh0, 5, "Jabba the Hutt");
			method.invoke(mh1, 7, "Boba Fett");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void withMhArgs() {
		MethodHandle mh = MethodAccessExampleWithArgs.makeMtd();

		MethodAccessExampleWithArgs mh0 = new MethodAccessExampleWithArgs(0);
		MethodAccessExampleWithArgs mh1 = new MethodAccessExampleWithArgs(1);

		try {
			System.out.println("Invocation using Method Handle");
			mh.invokeExact(mh0, 42, "R2D2");
			mh.invokeExact(mh1, 43, "C3P0");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
