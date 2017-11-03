package com.bespalhuk.vohl.texto.modify;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UpperCaseTest {

	@Test
	public void modify() {
		assertThat(new UpperCase().modify("bespalhuk")).isEqualTo("BESPALHUK");
	}

}