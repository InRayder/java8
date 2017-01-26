package com.star.lamda;

import java.nio.charset.Charset;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.junit.Test;

public class RandomTest {

	@Test
	public void givenUsingPlainJava_whenGeneratingRandomLongUnbounded_thenCorrect() {
		long generatedLong = new Random().nextLong();
		System.out.println(generatedLong);
	}

	@Test
	public void givenUsingPlainJava_whenGeneratingRandomLongBounded_thenCorrect() {
		long leftLimit = 1L;
		long rightLimit = 10L;
		long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
		System.out.println(generatedLong);
	}

	@Test
	public void givenUsingApacheCommons_whenGeneratingRandomLongBounded_thenCorrect() {
		long leftLimit = 1L;
		long rightLimit = 10L;
		long generatedLong = new RandomDataGenerator().nextLong(leftLimit, rightLimit);
		System.out.println(generatedLong);
	}

	@Test
	public void givenUsingPlainJava_whenGeneratingRandomIntegerUnbounded_thenCorrect() {
		int generatedInteger = new Random().nextInt();
		System.out.println(generatedInteger);
	}

	@Test
	public void givenUsingPlainJava_whenGeneratingRandomIntegerBounded_thenCorrect() {
		int leftLimit = 1;
		int rightLimit = 10;
		int generatedInteger = leftLimit + (int) (new Random().nextFloat() * (rightLimit - leftLimit));
		System.out.println(generatedInteger);
	}

	@Test
	public void givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect() {
		byte[] array = new byte[7];
		new Random().nextBytes(array);
		String generatedString = new String(array, Charset.forName("UTF-8"));
		System.out.println(generatedString);
	}

	@Test
	public void givenUsingPlainJava_whenGeneratingRandomStringBounded_thenCorrect() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (new Random().nextFloat() * (rightLimit - leftLimit));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		System.out.println(generatedString);
	}

	@Test
	public void givenUsingApache_whenGeneratingRandomStringBounded_thenCorrect() {
		int length = 10;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

		System.out.println(generatedString);
	}

	@Test
	public void givenUsingApache_whenGeneratingRandomAlphabeticString_thenCorrect() {
		String generatedString = RandomStringUtils.randomAlphabetic(10);

		System.out.println(generatedString);
	}

	@Test
	public void givenUsingApache_whenGeneratingRandomAlphanumericString_thenCorrect() {
		String generatedString = RandomStringUtils.randomAlphanumeric(10);

		System.out.println(generatedString);
	}
}
