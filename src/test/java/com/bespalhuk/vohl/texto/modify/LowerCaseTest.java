package com.bespalhuk.vohl.texto.modify;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LowerCaseTest {

	@Test
	public void modify() {
		assertThat(new LowerCase().modify("BESPALHUK")).isEqualTo("bespalhuk");
	}

}