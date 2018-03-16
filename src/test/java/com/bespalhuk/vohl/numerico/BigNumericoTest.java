package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.ContractTester;
import com.google.common.collect.ImmutableList;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

public class BigNumericoTest {

	private static final BigNumericoA M_DEZ_A = new BigNumericoA(-10);

	private static final BigNumericoA ZERO_A = new BigNumericoA(0);

	private static final BigNumericoA DEZ_A = new BigNumericoA(10);

	private static final BigNumericoA VINTE_A = new BigNumericoA(20);

	private static final BigNumericoB DEZ_B = new BigNumericoB(10);

	@Test
	public void equals() {
		ContractTester.test(DEZ_A,
				ImmutableList.of(new BigNumericoA(10)),
				ImmutableList.of(new BigNumericoA(1)));

		assertThat(DEZ_A.equals(DEZ_B)).isFalse();
		assertThat(DEZ_B.equals(DEZ_A)).isTrue();
		assertThat(DEZ_B.equals("")).isFalse();
	}

	@Test
	public void tostring() {
		assertThat(DEZ_A.toString()).isEqualTo("10");
	}

	@Test
	public void compare() {
		assertThat(DEZ_A.compareTo(M_DEZ_A)).isEqualTo(1);
		assertThat(DEZ_A.compareTo(new BigNumericoA(10))).isEqualTo(0);
		assertThat(DEZ_A.compareTo(VINTE_A)).isEqualTo(-1);
	}

	@Test
	public void format() {
		assertThat(String.format("%s", DEZ_A)).isEqualTo("10");
	}

	@Test
	public void content() {
		assertThat(DEZ_A.content(null)).isEqualTo(DEZ_A.toString());
	}

	@Test
	public void isPositivo() {
		assertThat(M_DEZ_A.isPositivo()).isFalse();
		assertThat(ZERO_A.isPositivo()).isFalse();
		assertThat(DEZ_A.isPositivo()).isTrue();
	}

	@Test
	public void isNegativo() {
		assertThat(M_DEZ_A.isNegativo()).isTrue();
		assertThat(ZERO_A.isNegativo()).isFalse();
		assertThat(DEZ_A.isNegativo()).isFalse();
	}

	@Test
	public void isZero() {
		assertThat(ZERO_A.isZero()).isTrue();
		assertThat(DEZ_A.isZero()).isFalse();
	}

	@Test
	public void isMinimoZero() {
		assertThat(M_DEZ_A.isMinimoZero()).isFalse();
		assertThat(ZERO_A.isMinimoZero()).isTrue();
		assertThat(DEZ_A.isMinimoZero()).isTrue();
	}

	@Test
	public void isMaximoZero() {
		assertThat(M_DEZ_A.isMaximoZero()).isTrue();
		assertThat(ZERO_A.isMaximoZero()).isTrue();
		assertThat(DEZ_A.isMaximoZero()).isFalse();
	}

	@Test
	public void isMaiorQue() {
		assertThat(DEZ_A.isMaiorQue(M_DEZ_A)).isTrue();
		assertThat(DEZ_A.isMaiorQue(new BigNumericoA(10))).isFalse();
		assertThat(DEZ_A.isMaiorQue(VINTE_A)).isFalse();
	}

	@Test
	public void isMaiorOuIgualQue() {
		assertThat(DEZ_A.isMaiorOuIgualQue(M_DEZ_A)).isTrue();
		assertThat(DEZ_A.isMaiorOuIgualQue(new BigNumericoA(10))).isTrue();
		assertThat(DEZ_A.isMaiorOuIgualQue(VINTE_A)).isFalse();
	}

	@Test
	public void getValue() {
		assertThat(DEZ_A.getValue()).isEqualTo(new BigDecimal(10));
	}

	@Test
	public void truncate() {
		assertThat(new BigNumericoA(10.123456, 6).truncate(5)).isEqualTo(new BigDecimal("10.12345"));
	}

	@Test
	public void round() {
		assertThat(new BigNumericoA(10.123456, 6).round(5)).isEqualTo(new BigDecimal("10.12346"));
	}

	private static class BigNumericoA extends BigNumerico<BigNumericoA> {

		private BigNumericoA(float value) {
			super(new BigDecimal(value));
		}


		private BigNumericoA(double value, int scale) {
			super(new BigDecimal(value).setScale(scale, RoundingMode.HALF_EVEN));
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof BigNumericoA && super.equals(obj);
		}

		@Override
		public RoundingMode getRoundingMode() {
			return RoundingMode.HALF_EVEN;
		}

		@Override
		public int getPrecision() {
			return 0;
		}

		@Override
		public int getScale() {
			return 0;
		}

		@Override
		public BigNumericoA sum(BigNumericoA value) {
			return null;
		}

		@Override
		public BigNumericoA subtract(BigNumericoA value) {
			return null;
		}

		@Override
		public BigNumericoA multiply(BigNumericoA value) {
			return null;
		}

		@Override
		public BigNumericoA divide(BigNumericoA value) {
			return null;
		}

		@Override
		public BigNumericoA toFloor() {
			return null;
		}
	}

	private static class BigNumericoB extends BigNumerico<BigNumericoB> {

		private BigNumericoB(float value) {
			super(new BigDecimal(value));
		}

		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}

		@Override
		public RoundingMode getRoundingMode() {
			return null;
		}

		@Override
		public int getPrecision() {
			return 0;
		}

		@Override
		public int getScale() {
			return 0;
		}

		@Override
		public BigNumericoB sum(BigNumericoB value) {
			return null;
		}

		@Override
		public BigNumericoB subtract(BigNumericoB value) {
			return null;
		}

		@Override
		public BigNumericoB multiply(BigNumericoB value) {
			return null;
		}

		@Override
		public BigNumericoB divide(BigNumericoB value) {
			return null;
		}

		@Override
		public BigNumericoB toFloor() {
			return null;
		}

	}

}