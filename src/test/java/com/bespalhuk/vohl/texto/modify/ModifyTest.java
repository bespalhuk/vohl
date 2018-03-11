package com.bespalhuk.vohl.texto.modify;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ModifyTest {

	private static final String value = " «Ricardo  Bêspálhük» ";

	@Test
	public void cases() {
		assertThat(Modify.of(Modifier.upperCase(), Modifier.lowerCase()).modify(value))
				.isEqualTo(" «ricardo  bêspálhük» ");
		assertThat(Modify.of(Modifier.lowerCase(), Modifier.upperCase()).modify(value))
				.isEqualTo(" «RICARDO  BÊSPÁLHÜK» ");
	}

	@Test
	public void normalize() {
		assertThat(Modify.of(Modifier.normalize()).modify(value)).isEqualTo("Ricardo Bespalhuk");
	}

	@Test
	public void whiteSpaces() {
		assertThat(Modify.of(Modifier.singleSpaces(), Modifier.trim()).modify(value)).isEqualTo("«Ricardo Bêspálhük»");
	}

	@Test
	public void truncate() {
		assertThat(Modify.of(Modifier.truncate(12)).modify(value)).isEqualTo(" «Ricardo  B");
		assertThat(Modify.of(Modifier.truncate(12, "...")).modify(value)).isEqualTo(" «Ricardo...");
	}

	@Test
	public void unseparate() {
		assertThat(Modify.of(Modifier.unseparate()).modify(value)).isEqualTo("«RicardoBêspálhük»");
	}

}