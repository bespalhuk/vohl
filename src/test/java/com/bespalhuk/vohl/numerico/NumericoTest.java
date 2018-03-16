package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.ContractTester;
import com.google.common.collect.ImmutableList;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumericoTest {

	private static final IntegerNumerico M_DEZ_I = new IntegerNumerico(-10);

	private static final IntegerNumerico ZERO_I = new IntegerNumerico(0);

	private static final IntegerNumerico DEZ_I = new IntegerNumerico(10);

	private static final IntegerNumerico VINTE_I = new IntegerNumerico(20);

	private static final LongNumerico M_DEZ_L = new LongNumerico(-10L);

	private static final LongNumerico ZERO_L = new LongNumerico(0L);

	private static final LongNumerico DEZ_L = new LongNumerico(10L);

	private static final LongNumerico VINTE_L = new LongNumerico(20L);

	@Test
	public void equals() {
		ContractTester.test(DEZ_I,
				ImmutableList.of(new IntegerNumerico(10)),
				ImmutableList.of(M_DEZ_I));

		ContractTester.test(DEZ_L,
				ImmutableList.of(new LongNumerico(10L)),
				ImmutableList.of(M_DEZ_L));
	}

	@Test
	public void tostring() {
		assertThat(DEZ_I.toString()).isEqualTo("10");

		assertThat(DEZ_L.toString()).isEqualTo("10");
	}

	@Test
	public void compare() {
		assertThat(DEZ_I.compareTo(M_DEZ_I)).isEqualTo(1);
		assertThat(DEZ_I.compareTo(new IntegerNumerico(10))).isEqualTo(0);
		assertThat(DEZ_I.compareTo(VINTE_I)).isEqualTo(-1);

		assertThat(DEZ_L.compareTo(M_DEZ_L)).isEqualTo(1);
		assertThat(DEZ_L.compareTo(new LongNumerico(10L))).isEqualTo(0);
		assertThat(DEZ_L.compareTo(VINTE_L)).isEqualTo(-1);
	}

	@Test
	public void format() {
		assertThat(String.format("%s", DEZ_I)).isEqualTo("10");

		assertThat(String.format("%s", DEZ_L)).isEqualTo("10");
	}

	@Test
	public void content() {
		assertThat(DEZ_I.content(null)).isEqualTo(DEZ_I.toString());

		assertThat(DEZ_L.content(null)).isEqualTo(DEZ_L.toString());
	}

	@Test
	public void isPositivo() {
		assertThat(M_DEZ_I.isPositivo()).isFalse();
		assertThat(ZERO_I.isPositivo()).isFalse();
		assertThat(DEZ_I.isPositivo()).isTrue();

		assertThat(M_DEZ_L.isPositivo()).isFalse();
		assertThat(ZERO_L.isPositivo()).isFalse();
		assertThat(DEZ_L.isPositivo()).isTrue();
	}

	@Test
	public void isNegativo() {
		assertThat(M_DEZ_I.isNegativo()).isTrue();
		assertThat(ZERO_I.isNegativo()).isFalse();
		assertThat(DEZ_I.isNegativo()).isFalse();

		assertThat(M_DEZ_L.isNegativo()).isTrue();
		assertThat(ZERO_L.isNegativo()).isFalse();
		assertThat(DEZ_L.isNegativo()).isFalse();
	}

	@Test
	public void isZero() {
		assertThat(ZERO_I.isZero()).isTrue();
		assertThat(DEZ_I.isZero()).isFalse();

		assertThat(ZERO_L.isZero()).isTrue();
		assertThat(DEZ_L.isZero()).isFalse();
	}

	@Test
	public void isMinimoZero() {
		assertThat(M_DEZ_I.isMinimoZero()).isFalse();
		assertThat(ZERO_I.isMinimoZero()).isTrue();
		assertThat(DEZ_I.isMinimoZero()).isTrue();

		assertThat(M_DEZ_L.isMinimoZero()).isFalse();
		assertThat(ZERO_L.isMinimoZero()).isTrue();
		assertThat(DEZ_L.isMinimoZero()).isTrue();
	}

	@Test
	public void isMaximoZero() {
		assertThat(M_DEZ_I.isMaximoZero()).isTrue();
		assertThat(ZERO_I.isMaximoZero()).isTrue();
		assertThat(DEZ_I.isMaximoZero()).isFalse();

		assertThat(M_DEZ_L.isMaximoZero()).isTrue();
		assertThat(ZERO_L.isMaximoZero()).isTrue();
		assertThat(DEZ_L.isMaximoZero()).isFalse();
	}

	@Test
	public void isMaiorQue() {
		assertThat(DEZ_I.isMaiorQue(M_DEZ_I)).isTrue();
		assertThat(DEZ_I.isMaiorQue(new IntegerNumerico(10))).isFalse();
		assertThat(DEZ_I.isMaiorQue(VINTE_I)).isFalse();

		assertThat(DEZ_L.isMaiorQue(M_DEZ_L)).isTrue();
		assertThat(DEZ_L.isMaiorQue(new LongNumerico(10L))).isFalse();
		assertThat(DEZ_L.isMaiorQue(VINTE_L)).isFalse();
	}

	@Test
	public void isMaiorOuIgualQue() {
		assertThat(DEZ_I.isMaiorOuIgualQue(M_DEZ_I)).isTrue();
		assertThat(DEZ_I.isMaiorOuIgualQue(new IntegerNumerico(10))).isTrue();
		assertThat(DEZ_I.isMaiorOuIgualQue(VINTE_I)).isFalse();

		assertThat(DEZ_L.isMaiorOuIgualQue(M_DEZ_L)).isTrue();
		assertThat(DEZ_L.isMaiorOuIgualQue(new LongNumerico(10L))).isTrue();
		assertThat(DEZ_L.isMaiorOuIgualQue(VINTE_L)).isFalse();
	}

	@Test
	public void getValue() {
		assertThat(DEZ_I.getValue()).isEqualTo(10);

		assertThat(DEZ_L.getValue()).isEqualTo(10);
	}

	private static class IntegerNumerico extends NumericoInteger<IntegerNumerico> {

		private IntegerNumerico(int value) {
			super(value);
		}

		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}

	}

	private static class LongNumerico extends NumericoLong<LongNumerico> {

		private LongNumerico(long value) {
			super(value);
		}

		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}

	}

}