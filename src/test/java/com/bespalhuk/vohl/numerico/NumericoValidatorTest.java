package com.bespalhuk.vohl.numerico;

import com.google.common.collect.ImmutableList;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class NumericoValidatorTest {

	private static final NumericoValidator<Integer> DEZ = new NumericoValidator<>(10);

	@Test
	public void validBetween() {
		DEZ.between(5, 15);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidBetween() {
		DEZ.between(15, 5);
	}

	@Test
	public void validMin() {
		DEZ.min(5);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMin() {
		DEZ.min(15);
	}

	@Test
	public void validMax() {
		DEZ.max(15);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMax() {
		DEZ.max(5);
	}

	@Test
	public void validMinLength() {
		DEZ.minLength(2);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMinLength() {
		DEZ.minLength(3);
	}

	@Test
	public void validMaxLength() {
		DEZ.maxLength(2);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMaxLength() {
		DEZ.maxLength(1);
	}

	@Test
	public void validMatches() {
		DEZ.matches("\\d+");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMatches() {
		DEZ.matches("\\D+");
	}

	@Test
	public void validMatchesAny() {
		DEZ.matchesAny(ImmutableList.of(Pattern.compile("\\d+"), Pattern.compile("\\D+")));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMatchesAny() {
		DEZ.matchesAny(ImmutableList.of(Pattern.compile("\\s+"), Pattern.compile("\\D+")));
	}

}