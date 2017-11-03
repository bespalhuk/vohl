package com.bespalhuk.vohl.texto.modify;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrimTest {

	@Test
	public void modify() {
		assertThat(new Trim().modify(" Bespalhuk ")).isEqualTo("Bespalhuk");
	}

}