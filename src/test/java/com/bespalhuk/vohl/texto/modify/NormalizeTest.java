package com.bespalhuk.vohl.texto.modify;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalizeTest {

	@Test
	public void modify() {
		assertThat(new Normalize().modify("  Bêspá € lhük  ")).isEqualTo("Bespa lhuk");
	}

}