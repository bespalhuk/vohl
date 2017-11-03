package com.bespalhuk.vohl.texto.modify;

import org.testng.annotations.Test;

import static com.bespalhuk.vohl.texto.modify.Modifier.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ModifyTest {

	@Test
	public void cases() {
		String name = "  «Ricardo  Bêspálhük»  ";
		assertThat(Modify.of(upperCase(), lowerCase()).modify(name)).isEqualTo("  «ricardo  bêspálhük»  ");
		assertThat(Modify.of(lowerCase(), upperCase()).modify(name)).isEqualTo("  «RICARDO  BÊSPÁLHÜK»  ");
	}

	@Test
	public void whiteSpaces() {
		String name = "  «Ricardo  Bêspálhük»  ";
		assertThat(Modify.of(spaces(), trim()).modify(name)).isEqualTo("«Ricardo Bêspálhük»");
	}

	@Test
	public void normalizer() {
		String name = "  «Ricardo  Bêspálhük»  ";
		assertThat(Modify.of(normalize()).modify(name)).isEqualTo("Ricardo Bespalhuk");
	}

}