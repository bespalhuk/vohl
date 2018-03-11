package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.ContractTester;
import com.google.common.collect.ImmutableList;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class BigNumericoTest {

//	private static final BigDecimal BD_10 = new BigDecimal(10);
//
//	private static final BigNumericoA DEZ_A = new BigNumericoA(BD_10);
//
////	private static final BigNumericoB DEZ_B = new BigNumericoB(BD_10);
//
//	@Test
//	public void equals() {
//		ContractTester.test(DEZ_A,
//				ImmutableList.of(new BigNumericoA(BD_10)),
//				ImmutableList.of(new BigNumericoA(new BigDecimal(1))));
//
////		assertThat(DEZ_A.equals(DEZ_B)).isFalse();
////		assertThat(DEZ_B.equals(DEZ_A)).isTrue();
////		assertThat(DEZ_B.equals("")).isFalse();
//	}
//
//	@Test
//	public void string() {
//		assertThat(DEZ_A.toString()).isEqualTo("10");
//	}
//
//	@Test
//	public void truncate() {
//		BigNumericoA dez0001 = new BigNumericoA(new BigDecimal(10.0001));
//		assertThat(dez0001.truncate(0)).isEqualTo(BD_10);
//		assertThat(dez0001.truncate(2)).isEqualTo(BD_10);
//
//		BigNumericoA dez9999 = new BigNumericoA(new BigDecimal(10.9999));
//		assertThat(dez9999.truncate(0)).isEqualTo(BD_10);
//		assertThat(dez9999.truncate(2)).isEqualTo(new BigDecimal(10.99));
//	}
//
//	private static class BigNumericoA extends BigNumerico<BigNumericoA> {
//
//		private BigNumericoA(BigDecimal value) {
//			new BigNumericoValidator(value, 3, 2);
//			super(value);
//		}
//
//		@Override
//		public boolean equals(Object obj) {
//			if (obj instanceof BigNumericoA) {
//				return super.equals(obj);
//			}
//			return false;
//		}
//
//		@Override
//		protected int maxInteger() {
//			return 3;
//		}
//
//		@Override
//		protected int maxDecimals() {
//			return 2;
//		}
//
//		@Override
//		protected BigDecimal formated() {
//			return null;
//		}
//
//		@Override
//		protected BigDecimal normalized() {
//			return null;
//		}
//
//	}

//	private static class BigNumericoB extends BigNumerico<BigNumericoB> {
//
//		private BigNumericoB(BigDecimal value) {
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