package com.star.nio;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;

public class CharSetDemo {

	public static void main(String[] args) {
		Map<String, Charset> maps = Charset.availableCharsets();
		for (Entry<String, Charset> entry : maps.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

}
