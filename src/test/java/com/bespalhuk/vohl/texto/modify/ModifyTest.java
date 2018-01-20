package com.bespalhuk.vohl.texto.modify;

import org.testng.annotations.Test;

import static com.bespalhuk.vohl.texto.modify.Modifier.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ModifyTest {

	private static final String value = " «Ricardo  Bêspálhük» ";

	@Test
	public void cases() {
		assertThat(Modify.of(upperCase(), lowerCase()).modify(value)).isEqualTo(" «ricardo  bêspálhük» ");
		assertThat(Modify.of(lowerCase(), upperCase()).modify(value)).isEqualTo(" «RICARDO  BÊSPÁLHÜK» ");
	}

	@Test
	public void whiteSpaces() {
		assertThat(Modify.of(singleSpaces(), trim()).modify(value)).isEqualTo("«Ricardo Bêspálhük»");
	}

	@Test
	public void normalizer() {
		assertThat(Modify.of(normalize()).modify(value)).isEqualTo("Ricardo Bespalhuk");
	}

	@Test
	public void separator() {
		assertThat(Modify.of(unseparate()).modify(value)).isEqualTo("«RicardoBêspálhük»");
	}

}