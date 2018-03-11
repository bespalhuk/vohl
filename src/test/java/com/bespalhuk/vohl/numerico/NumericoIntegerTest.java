package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.ContractTester;
import com.google.common.collect.ImmutableList;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumericoIntegerTest {

//	private static final IntegerNumericoInteger DEZ = new IntegerNumericoInteger(10);
//
//	private static final NumericoIntegerFloat DEZ_F = new NumericoIntegerFloat(10);
//
//	@Test
//	public void numerify() {
//		assertThat(NumericoInteger.numerify("1")).isEqualTo("1");
//		assertThat(NumericoInteger.numerify("1.0")).isEqualTo("1.0");
//		assertThat(NumericoInteger.numerify("1,0")).isEqualTo("1.0");
//		assertThat(NumericoInteger.numerify("1000.00")).isEqualTo("1000.00");
//		assertThat(NumericoInteger.numerify("1000,00")).isEqualTo("1000.00");
//		assertThat(NumericoInteger.numerify("1,000.00")).isEqualTo("1000.00");
//		assertThat(NumericoInteger.numerify("1.000,00")).isEqualTo("1000.00");
//		assertThat(NumericoInteger.numerify("1000000.00")).isEqualTo("1000000.00");
//		assertThat(NumericoInteger.numerify("1000000,00")).isEqualTo("1000000.00");
//		assertThat(NumericoInteger.numerify("1000,000.00")).isEqualTo("1000000.00");
//		assertThat(NumericoInteger.numerify("1000.000,00")).isEqualTo("1000000.00");
//		assertThat(NumericoInteger.numerify("1,000,000.000")).isEqualTo("1000000.000");
//		assertThat(NumericoInteger.numerify("1.000.000,000")).isEqualTo("1000000.000");
//	}
//
//	@Test
//	public void equals() {
//		ContractTester.test(DEZ,
//				ImmutableList.of(new IntegerNumericoInteger(10)),
//				ImmutableList.of(new IntegerNumericoInteger(1), DEZ_F));
//	}
//
//	@Test
//	public void string() {
//		assertThat(DEZ.toString()).isEqualTo("10");
//		assertThat(DEZ_F.toString()).isEqualTo("10.0");
//	}
//
//	@Test
//	public void compare() {
//		assertThat(DEZ.compareTo(new IntegerNumericoInteger(5))).isEqualTo(1);
//		assertThat(DEZ.compareTo(new IntegerNumericoInteger(10))).isEqualTo(0);
//		assertThat(DEZ.compareTo(new IntegerNumericoInteger(15))).isEqualTo(-1);
//	}
//
//	@Test
//	public void format() {
//		assertThat(String.format("%s", DEZ)).isEqualTo("10");
//		assertThat(String.format("%s", DEZ_F)).isEqualTo("10.0");
//	}
//
//	@Test
//	public void content() {
//		assertThat(DEZ.content(null)).isEqualTo("10");
//		assertThat(DEZ_F.content(null)).isEqualTo("10.0");
//	}
//
//	@Test
//	public void isZero() {
//		assertThat(new IntegerNumericoInteger(0).isZero()).isTrue();
//		assertThat(DEZ.isZero()).isFalse();
//		assertThat(new NumericoIntegerFloat(0.0F).isZero()).isFalse();
//		assertThat(new NumericoIntegerFloat(0.1F).isZero()).isFalse();
//	}
//
//	@Test
//	public void isMaiorOuIgualZero() {
//		assertThat(new IntegerNumericoInteger(-10).isMaiorOuIgualZero()).isFalse();
//		assertThat(new IntegerNumericoInteger(0).isMaiorOuIgualZero()).isTrue();
//		assertThat(DEZ.isMaiorOuIgualZero()).isTrue();
//	}
//
//	@Test
//	public void isMaiorQue() {
//		assertThat(DEZ.isMaiorQue(new IntegerNumericoInteger(5))).isTrue();
//		assertThat(DEZ.isMaiorQue(DEZ)).isFalse();
//		assertThat(DEZ.isMaiorQue(new IntegerNumericoInteger(15))).isFalse();
//	}
//
//	@Test
//	public void isMaiorOuIgualQue() {
//		assertThat(DEZ.isMaiorOuIgualQue(new IntegerNumericoInteger(5))).isTrue();
//		assertThat(DEZ.isMaiorOuIgualQue(DEZ)).isTrue();
//		assertThat(DEZ.isMaiorOuIgualQue(new IntegerNumericoInteger(15))).isFalse();
//	}
//
//	@Test
//	public void isPositivo() {
//		assertThat(new IntegerNumericoInteger(-5).isPositivo()).isFalse();
//		assertThat(new IntegerNumericoInteger(0).isPositivo()).isFalse();
//		assertThat(DEZ.isPositivo()).isTrue();
//	}
//
//	@Test
//	public void isNegativo() {
//		assertThat(new IntegerNumericoInteger(-5).isNegativo()).isTrue();
//		assertThat(new IntegerNumericoInteger(0).isNegativo()).isFalse();
//		assertThat(DEZ.isNegativo()).isFalse();
//	}
//
//	@Test
//	public void getValue() {
//		assertThat(DEZ.getValue()).isEqualTo(10);
//		assertThat(DEZ.byteValue()).isEqualTo((byte) 10);
//		assertThat(DEZ.shortValue()).isEqualTo((short) 10);
//		assertThat(DEZ.intValue()).isEqualTo(10);
//		assertThat(DEZ.longValue()).isEqualTo(10L);
//		assertThat(DEZ.floatValue()).isEqualTo(10.0f);
//		assertThat(DEZ.doubleValue()).isEqualTo(10.0d);
//	}
//
//	private static class IntegerNumericoInteger extends NumericoInteger<NumericoIntegerInteger, Integer> {
//
//		private IntegerNumericoInteger(int value) {
//			super(value);
//		}
//
//		@Override
//		public boolean equals(Object obj) {
//			return super.equals(obj);
//		}
//
//	}
//
//	private static class NumericoIntegerFloat extends NumericoInteger<NumericoIntegerFloat, Float> {
//
//		private NumericoIntegerFloat(float value) {
//			super(value);
//		}
//
//		@Override
//		public boolean equals(Object obj) {
//			return super.equals(obj);
//		}
//
//	}

}