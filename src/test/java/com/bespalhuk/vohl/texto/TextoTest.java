package com.bespalhuk.vohl.texto;

import com.bespalhuk.vohl.ContractTester;
import com.bespalhuk.vohl.texto.modify.Modifier;
import com.google.common.collect.ImmutableList;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class TextoTest {

	private static final Texto.Builder TEXTO = Texto.builder("Bespalhuk");

	@Test
	public void builderConstructor() {
		assertThat(Texto.Builder.class.getDeclaredConstructors().length).isEqualTo(2);
	}

	@Test
	public void modifiers() {
		assertThat(new Texto1(Texto.builder("Bespalhuk")
				.modifiers(Modifier.lowerCase(), Modifier.upperCase())).toString()).isEqualTo("BESPALHUK");
	}

	@Test
	public void validBetween() {
		TEXTO.between(5, 10);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidBetween() {
		TEXTO.between(10, 5);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidBetweenMin() {
		TEXTO.between(10, 10);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidBetweenMax() {
		TEXTO.between(5, 5);
	}

	@Test
	public void validMin() {
		TEXTO.min(5);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMin() {
		TEXTO.min(10);
	}

	@Test
	public void validMax() {
		TEXTO.max(10);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMax() {
		TEXTO.max(5);
	}

	@Test
	public void validMatches() {
		TEXTO.matches("\\w+");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMatches() {
		TEXTO.matches("\\W+");
	}

	@Test
	public void validMatchesAny() {
		TEXTO.matchesAny(ImmutableList.of(Pattern.compile("\\w+"), Pattern.compile("\\W+")));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMatchesAny() {
		TEXTO.matchesAny(ImmutableList.of(Pattern.compile("\\s+"), Pattern.compile("\\W+")));
	}

	@Test
	public void validNotBlank() {
		TEXTO.notBlank();
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidNotBlank() {
		Texto.builder("").notBlank();
	}

	@Test
	public void equals() {
		ContractTester.test(new Texto1(TEXTO),
				ImmutableList.of(new Texto1(Texto.builder("Bespalhuk"))),
				ImmutableList.of(new Texto1(Texto.builder("Ricardo"))));
	}

	@Test
	public void string() {
		assertThat(new Texto1(TEXTO).toString()).isEqualTo("Bespalhuk");
	}

	@Test
	public void compare() {
		Texto1 texto1 = new Texto1(TEXTO);
		assertThat(texto1.compareTo(new Texto1(Texto.builder("0")))).isEqualTo(1);
		assertThat(texto1.compareTo(texto1)).isEqualTo(0);
		assertThat(texto1.compareTo(new Texto1(Texto.builder("Z")))).isEqualTo(-1);
	}

	@Test
	public void format() {
		assertThat(String.format("%s", new Texto1(TEXTO))).isEqualTo("Bespalhuk");
	}

	@Test
	public void content() {
		assertThat(new Texto1(TEXTO).content(null)).isEqualTo("Bespalhuk");
	}

	private static class Texto1 extends Texto<Texto1> {

		private Texto1(Builder builder) {
			super(builder);
		}

		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}

	}

}