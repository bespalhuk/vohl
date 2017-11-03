package com.bespalhuk.vohl.texto.modify;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpacesTest {

	@Test
	public void modify() {
		assertThat(new Spaces().modify("  Ricardo  Bespalhuk  ")).isEqualTo(" Ricardo Bespalhuk ");
	}

}