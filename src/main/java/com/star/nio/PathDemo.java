package com.star.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {

	public static void main(String[] args) {
		Path path1 = Paths.get("H:\\test\\1\\1.txt");
		Path path2 = Paths.get("H:\\test\\2\\2.txt");
		System.out.println(path1.resolve(path2));
	}
}
