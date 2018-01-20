package com.bespalhuk.vohl.texto.modify;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleSpacesTest {

	@Test
	public void modify() {
		assertThat(new SingleSpaces().modify("  Ricardo  boca  Bespalhuk  ")).isEqualTo(" Ricardo boca Bespalhuk ");
	}

}