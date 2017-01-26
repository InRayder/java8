package com.star.security.test;

import java.security.Guard;
import java.security.GuardedObject;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String message = "test message";
		final StringBuffer objBuffer = new StringBuffer("2345 t");

		GuardedObject go = new GuardedObject(objBuffer, new Guard() {

			@Override
			public void checkGuard(Object object) throws SecurityException {
				// TODO Auto-generated method stub
				if (object == objBuffer && objBuffer.length() == 0) {
					throw new SecurityException(message);
				}
			}
		});

		System.out.println(objBuffer == go.getObject());

		objBuffer.setLength(0);
		try {
			go.getObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
