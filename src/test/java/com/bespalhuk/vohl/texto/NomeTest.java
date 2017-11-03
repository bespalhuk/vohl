package com.bespalhuk.vohl.texto;

import com.bespalhuk.vohl.ContractTester;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NomeTest {

	@Test
	public void lenght() {
		assertThat(Nome.MAX_LENGTH).isEqualTo(60);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void ofNull() {
		Nome.of(null);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void ofBlank() {
		Nome.of("");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void regex() {
		Nome.of("¹²³");
	}

	@Test
	public void equals() {
		ContractTester.test(Nome.of(" Bespalhuk "), Nome.of("Bespalhuk"), Nome.of("Ricardo"));
	}

}