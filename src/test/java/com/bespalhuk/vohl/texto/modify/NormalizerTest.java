package com.bespalhuk.vohl.texto.modify;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalizerTest {

	@Test
	public void modify() {
		assertThat(new Normalizer().modify("  Bêspá € lhük  ")).isEqualTo("Bespa lhuk");
	}

}