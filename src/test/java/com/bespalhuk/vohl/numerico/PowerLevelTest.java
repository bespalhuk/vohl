package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.ContractTester;
import com.google.common.collect.ImmutableList;
import org.testng.annotations.Test;

import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

public class PowerLevelTest {

	@Test
	public void precision() {
		assertThat(PowerLevel.PRECISION).isEqualTo(6);
		assertThat(PowerLevel.MIN.getPrecision()).isSameAs(PowerLevel.PRECISION);
	}

	@Test
	public void scale() {
		assertThat(PowerLevel.SCALE).isEqualTo(2);
		assertThat(PowerLevel.MIN.getScale()).isSameAs(PowerLevel.SCALE);
	}

	@Test
	public void roundingMode() {
		assertThat(PowerLevel.ROUNDING_MODE).isEqualTo(RoundingMode.HALF_EVEN);
		assertThat(PowerLevel.MIN.getRoundingMode()).isSameAs(RoundingMode.HALF_EVEN);
	}

	@Test
	public void min() {
		assertThat(PowerLevel.MIN).isEqualTo(PowerLevel.of(10));
	}

	@Test
	public void max() {
		assertThat(PowerLevel.MAX).isEqualTo(PowerLevel.of(9999.99));
	}

	@Test
	public void equals() {
		ContractTester.test(PowerLevel.MIN,
				ImmutableList.of(PowerLevel.of(10)),
				ImmutableList.of(PowerLevel.MAX));
	}

	@Test
	public void sum() {
		assertThat(PowerLevel.MIN.sum(PowerLevel.MIN)).isEqualTo(PowerLevel.of(20));
	}

	@Test
	public void subtract() {
		assertThat(PowerLevel.MAX.subtract(PowerLevel.MIN)).isEqualTo(PowerLevel.of(9989.99));
	}

	@Test
	public void multiply() {
		assertThat(PowerLevel.MIN.multiply(PowerLevel.MIN)).isEqualTo(PowerLevel.of(100));
	}

	@Test
	public void divide() {
		assertThat(PowerLevel.MAX.divide(PowerLevel.MIN)).isEqualTo(PowerLevel.of(1000));
	}

	@Test
	public void toFloor() {
		assertThat(PowerLevel.MAX.toFloor()).isEqualTo(PowerLevel.of(9999));
	}

}