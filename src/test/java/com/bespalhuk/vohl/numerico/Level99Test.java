package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.ContractTester;
import com.google.common.collect.ImmutableList;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Level99Test {

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void min() {
		Level99.of(0);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void max() {
		Level99.of(100);
	}

	@Test
	public void equals() {
		ContractTester.test(Level99.of(9), ImmutableList.of(Level99.of(9)), ImmutableList.of(99));
	}

	@Test
	public void validUp() {
		assertThat(Level99.of(9).up()).isEqualTo(Level99.of(10));
	}

	@Test(expectedExceptions = UnsupportedOperationException.class)
	public void invalidUp() {
		Level99.of(99).up();
	}

	@Test
	public void validDown() {
		assertThat(Level99.of(10).down()).isEqualTo(Level99.of(9));
	}

	@Test(expectedExceptions = UnsupportedOperationException.class)
	public void invalidDown() {
		Level99.of(1).down();
	}

}