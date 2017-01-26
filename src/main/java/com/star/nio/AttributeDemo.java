package com.star.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AttributeDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		Path path1 = Paths.get("/1.txt");
		Path path2 = Paths.get("/2.txt");
		System.out.println(Files.isSameFile(path1, path2));
	}

}
