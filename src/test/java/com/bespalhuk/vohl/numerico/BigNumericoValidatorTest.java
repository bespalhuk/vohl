package com.bespalhuk.vohl.numerico;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

public class BigNumericoValidatorTest {

	private static final BigDecimal CINCO = new BigDecimal(5);

	private static final BigDecimal QUINZE = new BigDecimal(15);

	private static final BigDecimal VINTE = new BigDecimal(20);

	private static final BigNumericoValidator DEZ_E_MEIO
			= new BigNumericoValidator(10.5, 3, RoundingMode.HALF_EVEN);

	@Test
	public void validBetween() {
		DEZ_E_MEIO.between(CINCO, QUINZE);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidBetween() {
		DEZ_E_MEIO.between(QUINZE, CINCO);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMinBetween() {
		DEZ_E_MEIO.between(QUINZE, VINTE);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMaxBetween() {
		DEZ_E_MEIO.between(BigDecimal.ZERO, CINCO);
	}

	@Test
	public void validMin() {
		DEZ_E_MEIO.min(CINCO);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMin() {
		DEZ_E_MEIO.min(QUINZE);
	}

	@Test
	public void validMax() {
		DEZ_E_MEIO.max(QUINZE);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMax() {
		DEZ_E_MEIO.max(CINCO);
	}

	@Test
	public void validMinLength() {
		DEZ_E_MEIO.minLength(4);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMinLength() {
		DEZ_E_MEIO.minLength(6);
	}

	@Test
	public void validMaxLength() {
		DEZ_E_MEIO.maxLength(6);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMaxLength() {
		DEZ_E_MEIO.maxLength(4);
	}

	@Test
	public void getValue() {
		assertThat(DEZ_E_MEIO.getValue()).isEqualTo(new BigDecimal("10.500"));
	}

}