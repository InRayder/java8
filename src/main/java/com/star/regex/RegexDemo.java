package com.star.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		noCaptureGroup();
	}

	public static void noCaptureGroup() {
		Pattern pattern = Pattern.compile("(?:(\\d+))?\\s?([a-zA-Z]+)?.+");
		String source = "2133 fdsdee4333";
		Matcher matcher = pattern.matcher(source);
		if (matcher.matches()) {
			for (int i = 0; i <= matcher.groupCount(); i++) {
				System.out.println("group " + i + ":" + matcher.group(i));
			}
		}
	}
}
