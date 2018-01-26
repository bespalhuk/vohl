package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.ContractTester;
import com.google.common.collect.ImmutableList;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumericoTest {

	private static final NumericoInteger DEZ = new NumericoInteger(10);

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
	public void equals() {
		ContractTester.test(DEZ, ImmutableList.of(new NumericoInteger(10)), ImmutableList.of(new NumericoInteger(1)));
	}

	@Test
	public void string() {
		assertThat(DEZ.toString()).isEqualTo("10");
	}

	@Test
	public void compare() {
		assertThat(DEZ.compareTo(new NumericoInteger(5))).isEqualTo(1);
		assertThat(DEZ.compareTo(new NumericoInteger(10))).isEqualTo(0);
		assertThat(DEZ.compareTo(new NumericoInteger(15))).isEqualTo(-1);
	}

	@Test
	public void format() {
		assertThat(String.format("%s", DEZ)).isEqualTo("10");
	}

	@Test
	public void content() {
		assertThat(DEZ.content(null)).isEqualTo("10");
	}

	@Test
	public void isZero() {
		assertThat(new NumericoInteger(0).isZero()).isTrue();
		assertThat(DEZ.isZero()).isFalse();
	}

	@Test
	public void isMaiorOuIgualZero() {
		assertThat(new NumericoInteger(-10).isMaiorOuIgualZero()).isFalse();
		assertThat(new NumericoInteger(0).isMaiorOuIgualZero()).isTrue();
		assertThat(DEZ.isMaiorOuIgualZero()).isTrue();
	}

	@Test
	public void isMaiorQue() {
		assertThat(DEZ.isMaiorQue(new NumericoInteger(5))).isTrue();
		assertThat(DEZ.isMaiorQue(DEZ)).isFalse();
		assertThat(DEZ.isMaiorQue(new NumericoInteger(15))).isFalse();
	}

	@Test
	public void isMaiorOuIgualQue() {
		assertThat(DEZ.isMaiorOuIgualQue(new NumericoInteger(5))).isTrue();
		assertThat(DEZ.isMaiorOuIgualQue(DEZ)).isTrue();
		assertThat(DEZ.isMaiorOuIgualQue(new NumericoInteger(15))).isFalse();
	}

	@Test
	public void isPositivo() {
		assertThat(new NumericoInteger(-5).isPositivo()).isFalse();
		assertThat(new NumericoInteger(0).isPositivo()).isFalse();
		assertThat(DEZ.isPositivo()).isTrue();
	}

	@Test
	public void isNegativo() {
		assertThat(new NumericoInteger(-5).isNegativo()).isTrue();
		assertThat(new NumericoInteger(0).isNegativo()).isFalse();
		assertThat(DEZ.isNegativo()).isFalse();
	}

	@Test
	public void getValue() {
		assertThat(DEZ.getValue()).isEqualTo(10);
		assertThat(DEZ.byteValue()).isEqualTo((byte) 10);
		assertThat(DEZ.shortValue()).isEqualTo((short) 10);
		assertThat(DEZ.intValue()).isEqualTo(10);
		assertThat(DEZ.longValue()).isEqualTo(10L);
		assertThat(DEZ.floatValue()).isEqualTo(10.0f);
		assertThat(DEZ.doubleValue()).isEqualTo(10.0d);
	}

	private static class NumericoInteger extends Numerico<NumericoInteger, Integer> {

		private NumericoInteger(int value) {
			super(value);
		}

		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}

	}

}