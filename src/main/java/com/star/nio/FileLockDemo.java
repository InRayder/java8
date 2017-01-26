package com.star.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Files;

public class FileLockDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		RandomAccessFile raf = new RandomAccessFile("/1.txt", "rw");
		FileChannel fileChannel = raf.getChannel();
		FileLock fileLock = fileChannel.tryLock();
		System.out.println(fileLock.isShared());
		System.out.println(fileLock.acquiredBy());
		System.out.println(fileLock.isShared());
		System.out.println(fileLock.isValid());
		System.out.println(fileLock.size());
		if (fileLock != null) {
			new Thread() {
				public void run() {
					try {
						FileInputStream fis = new FileInputStream("/1.txt");
						fis.read();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				};
			}.start();

			Thread.sleep(10000);

		}
	}
}
