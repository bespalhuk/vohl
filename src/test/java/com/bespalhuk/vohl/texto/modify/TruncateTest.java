package com.bespalhuk.vohl.texto.modify;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TruncateTest {

	@Test
	public void modify() {
		assertThat(new Truncate(1).modify("Bespalhuk")).isEqualTo("B");
		assertThat(new Truncate(1, "...").modify("Bespalhuk")).isEqualTo("B");
		assertThat(new Truncate(2, "...").modify("Bespalhuk")).isEqualTo("Be");
		assertThat(new Truncate(3, "...").modify("Bespalhuk")).isEqualTo("Bes");
		assertThat(new Truncate(4, "...").modify("Bespalhuk")).isEqualTo("B...");
	}

}