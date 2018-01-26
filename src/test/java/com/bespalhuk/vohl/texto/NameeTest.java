package com.bespalhuk.vohl.texto;

import com.bespalhuk.vohl.ContractTester;
import com.google.common.collect.ImmutableList;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameeTest {

	@Test
	public void lenght() {
		assertThat(Namee.MAX_LENGTH).isEqualTo(60);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void ofNull() {
		Namee.of(null);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void ofBlank() {
		Namee.of("");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void regex() {
		Namee.of("¹²³");
	}

	@Test
	public void equals() {
		ContractTester.test(Namee.of(" Ricardo  Bespalhuk "),
				ImmutableList.builder().add(Namee.of("Ricardo Bespalhuk")).build(),
				ImmutableList.builder().add(Namee.of("Bespalhuk")).build());
	}

}