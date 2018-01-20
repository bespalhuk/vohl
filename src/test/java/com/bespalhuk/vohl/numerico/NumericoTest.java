package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.ContractTester;
import com.google.common.collect.ImmutableList;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class NumericoTest {

	private Numerico.Builder<Integer> dez = Numerico.builder(10);

	@Test
	public void builderConstructor() {
		assertThat(Numerico.Builder.class.getDeclaredConstructors().length).isEqualTo(2);
	}

	@Test
	public void numerify() {
		assertThat(Numerico.numerify("1")).isEqualTo("1");
		assertThat(Numerico.numerify("1.0")).isEqualTo("1.0");
		assertThat(Numerico.numerify("1,0")).isEqualTo("1.0");
		assertThat(Numerico.numerify("1000.00")).isEqualTo("1000.00");
		assertThat(Numerico.numerify("1000,00")).isEqualTo("1000.00");
		assertThat(Numerico.numerify("1,000.00")).isEqualTo("1000.00");
		assertThat(Numerico.numerify("1.000,00")).isEqualTo("1000.00");
		assertThat(Numerico.numerify("1000000.00")).isEqualTo("1000000.00");
		assertThat(Numerico.numerify("1000000,00")).isEqualTo("1000000.00");
		assertThat(Numerico.numerify("1000,000.00")).isEqualTo("1000000.00");
		assertThat(Numerico.numerify("1000.000,00")).isEqualTo("1000000.00");
		assertThat(Numerico.numerify("1,000,000.000")).isEqualTo("1000000.000");
		assertThat(Numerico.numerify("1.000.000,000")).isEqualTo("1000000.000");
	}

	@Test
	public void validBetween() {
		dez.between(5, 15);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidBetween() {
		dez.between(15, 5);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidBetweenMin() {
		dez.between(15, 15);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidBetweenMax() {
		dez.between(5, 5);
	}

	@Test
	public void validMin() {
		dez.min(5);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMin() {
		dez.min(15);
	}

	@Test
	public void validMax() {
		dez.max(15);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMax() {
		dez.max(5);
	}

	@Test
	public void validMinLength() {
		dez.minLength(2);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMinLength() {
		dez.minLength(3);
	}

	@Test
	public void validMaxLength() {
		dez.maxLength(2);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMaxLength() {
		dez.maxLength(1);
	}

	@Test
	public void validMatches() {
		dez.matches("\\d+");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMatches() {
		dez.matches("\\D+");
	}

	@Test
	public void validMatchesAny() {
		dez.matchesAny(ImmutableList.of(Pattern.compile("\\d+"), Pattern.compile("\\D+")));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMatchAny() {
		dez.matchesAny(ImmutableList.of(Pattern.compile("\\s+"), Pattern.compile("\\D+")));
	}

	@Test
	public void equals() {
		ContractTester.test(new NumericoInteger(dez),
				ImmutableList.builder().add(new NumericoInteger(dez)).build(),
				ImmutableList.builder().add(new NumericoInteger(Numerico.builder(1))).build());
	}

	@Test
	public void string() {
		assertThat(new NumericoInteger(dez).toString()).isEqualTo("10");
	}

	@Test
	public void compare() {
		NumericoInteger numerico = new NumericoInteger(this.dez);
		assertThat(numerico.compareTo(new NumericoInteger(Numerico.builder(5)))).isEqualTo(1);
		assertThat(numerico.compareTo(new NumericoInteger(Numerico.builder(10)))).isEqualTo(0);
		assertThat(numerico.compareTo(new NumericoInteger(Numerico.builder(15)))).isEqualTo(-1);
	}

	@Test
	public void format() {
		assertThat(String.format("%s", new NumericoInteger(dez))).isEqualTo("10");
	}

	@Test
	public void content() {
		assertThat(new NumericoInteger(dez).content(null)).isEqualTo("10");
	}

	@Test
	public void isZero() {
		assertThat(new NumericoInteger(Numerico.builder(0)).isZero()).isTrue();
		assertThat(new NumericoInteger(dez).isZero()).isFalse();
	}

	@Test
	public void isMaiorOuIgualZero() {
		assertThat(new NumericoInteger(Numerico.builder(-10)).isMaiorOuIgualZero()).isFalse();
		assertThat(new NumericoInteger(Numerico.builder(0)).isMaiorOuIgualZero()).isTrue();
		assertThat(new NumericoInteger(dez).isMaiorOuIgualZero()).isTrue();
	}

	@Test
	public void isMaiorQue() {
		NumericoInteger numerico = new NumericoInteger(dez);
		assertThat(numerico.isMaiorQue(new NumericoInteger(Numerico.builder(5)))).isTrue();
		assertThat(numerico.isMaiorQue(new NumericoInteger(dez))).isFalse();
		assertThat(numerico.isMaiorQue(new NumericoInteger(Numerico.builder(15)))).isFalse();
	}

	@Test
	public void isMaiorOuIgualQue() {
		NumericoInteger numerico = new NumericoInteger(dez);
		assertThat(numerico.isMaiorOuIgualQue(new NumericoInteger(Numerico.builder(5)))).isTrue();
		assertThat(numerico.isMaiorOuIgualQue(new NumericoInteger(dez))).isTrue();
		assertThat(numerico.isMaiorOuIgualQue(new NumericoInteger(Numerico.builder(15)))).isFalse();
	}

	@Test
	public void isPositivo() {
		assertThat(new NumericoInteger(Numerico.builder(-5)).isPositivo()).isFalse();
		assertThat(new NumericoInteger(Numerico.builder(0)).isPositivo()).isFalse();
		assertThat(new NumericoInteger(dez).isPositivo()).isTrue();
	}

	@Test
	public void isNegativo() {
		assertThat(new NumericoInteger(Numerico.builder(-5)).isNegativo()).isTrue();
		assertThat(new NumericoInteger(Numerico.builder(0)).isNegativo()).isFalse();
		assertThat(new NumericoInteger(dez).isNegativo()).isFalse();
	}

	@Test
	public void getValue() {
		assertThat(new NumericoInteger(dez).getValue()).isEqualTo(10);
		assertThat(new NumericoInteger(dez).byteValue()).isEqualTo((byte) 10);
		assertThat(new NumericoInteger(dez).shortValue()).isEqualTo((short) 10);
		assertThat(new NumericoInteger(dez).intValue()).isEqualTo(10);
		assertThat(new NumericoInteger(dez).longValue()).isEqualTo(10L);
		assertThat(new NumericoInteger(dez).floatValue()).isEqualTo(10.0f);
		assertThat(new NumericoInteger(dez).doubleValue()).isEqualTo(10.0d);
	}

	private static class NumericoInteger extends Numerico<NumericoInteger, Integer> {

		private NumericoInteger(Builder builder) {
			super(builder);
		}

		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}

	}

}