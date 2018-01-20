package com.bespalhuk.vohl.texto.modify;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UnseparateTest {

	@Test
	public void modify() {
		assertThat(new Unseparate().modify(" Bespalhuk ")).isEqualTo("Bespalhuk");
		assertThat(new Unseparate().modify(",Bespalhuk,")).isEqualTo("Bespalhuk");
		assertThat(new Unseparate().modify(".Bespalhuk.")).isEqualTo("Bespalhuk");
		assertThat(new Unseparate().modify("+Bespalhuk+")).isEqualTo("Bespalhuk");
		assertThat(new Unseparate().modify("-Bespalhuk-")).isEqualTo("Bespalhuk");
		assertThat(new Unseparate().modify("*Bespalhuk*")).isEqualTo("Bespalhuk");
		assertThat(new Unseparate().modify("/Bespalhuk/")).isEqualTo("Bespalhuk");
		assertThat(new Unseparate().modify("\\Bespalhuk\\")).isEqualTo("Bespalhuk");
		assertThat(new Unseparate().modify("(Bespalhuk(")).isEqualTo("Bespalhuk");
		assertThat(new Unseparate().modify(")Bespalhuk)")).isEqualTo("Bespalhuk");
		assertThat(new Unseparate().modify("[Bespalhuk[")).isEqualTo("Bespalhuk");
		assertThat(new Unseparate().modify("]Bespalhuk]")).isEqualTo("Bespalhuk");
		assertThat(new Unseparate().modify("{Bespalhuk{")).isEqualTo("Bespalhuk");
		assertThat(new Unseparate().modify("}Bespalhuk}")).isEqualTo("Bespalhuk");
	}

}