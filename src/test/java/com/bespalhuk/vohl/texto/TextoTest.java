package com.bespalhuk.vohl.texto;

import com.bespalhuk.vohl.ContractTester;
import com.bespalhuk.vohl.texto.modify.Modifier;
import com.google.common.collect.ImmutableList;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class TextoTest {

	private Texto.Builder texto;

	@BeforeMethod
	public void before() {
		texto = Texto.builder("Bespalhuk");
	}

	@Test
	public void builderConstructor() {
		assertThat(Texto.Builder.class.getDeclaredConstructors().length).isEqualTo(2);
	}

	@Test
	public void modifiers() {
		assertThat(new Texto1(texto.modifiers(Modifier.lowerCase(), Modifier.upperCase())).toString())
				.isEqualTo("BESPALHUK");
	}

	@Test
	public void validBetween() {
		texto.between(5, 10);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidBetween() {
		texto.between(10, 5);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidBetweenMin() {
		texto.between(10, 10);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidBetweenMax() {
		texto.between(5, 5);
	}

	@Test
	public void validMin() {
		texto.min(5);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMin() {
		texto.min(10);
	}

	@Test
	public void validMax() {
		texto.max(10);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMax() {
		texto.max(5);
	}

	@Test
	public void validMatches() {
		texto.matches("\\w+");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMatches() {
		texto.matches("\\W+");
	}

	@Test
	public void validMatchesAny() {
		texto.matchesAny(ImmutableList.of(Pattern.compile("\\w+"), Pattern.compile("\\W+")));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidMatchesAny() {
		texto.matchesAny(ImmutableList.of(Pattern.compile("\\s+"), Pattern.compile("\\W+")));
	}

	@Test
	public void validNotBlank() {
		texto.notBlank();
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void invalidNotBlank() {
		Texto.builder("").notBlank();
	}

	@Test
	public void equals() {
		ContractTester.test(new Texto1(texto),
				ImmutableList.builder().add(new Texto1(texto)).build(),
				ImmutableList.builder().add(new Texto1(Texto.builder("Ricardo"))).build());
	}

	@Test
	public void string() {
		assertThat(new Texto1(texto).toString()).isEqualTo("Bespalhuk");
	}

	@Test
	public void compare() {
		Texto1 texto1 = new Texto1(texto);
		assertThat(texto1.compareTo(new Texto1(Texto.builder("0")))).isEqualTo(1);
		assertThat(texto1.compareTo(texto1)).isEqualTo(0);
		assertThat(texto1.compareTo(new Texto1(Texto.builder("Z")))).isEqualTo(-1);
	}

	@Test
	public void format() {
		assertThat(String.format("%s", new Texto1(texto))).isEqualTo("Bespalhuk");
	}

	@Test
	public void content() {
		assertThat(new Texto1(texto).content(null)).isEqualTo("Bespalhuk");
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