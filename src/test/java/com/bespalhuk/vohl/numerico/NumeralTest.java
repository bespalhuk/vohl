package com.bespalhuk.vohl.numerico;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumeralTest {

	@Test
	public void numerify() {
		assertThat(Numeral.numerify("1")).isEqualTo("1");
		assertThat(Numeral.numerify("1.0")).isEqualTo("1.0");
		assertThat(Numeral.numerify("1,0")).isEqualTo("1.0");
		assertThat(Numeral.numerify("1000.00")).isEqualTo("1000.00");
		assertThat(Numeral.numerify("1000,00")).isEqualTo("1000.00");
		assertThat(Numeral.numerify("1,000.00")).isEqualTo("1000.00");
		assertThat(Numeral.numerify("1.000,00")).isEqualTo("1000.00");
		assertThat(Numeral.numerify("1000000.00")).isEqualTo("1000000.00");
		assertThat(Numeral.numerify("1000000,00")).isEqualTo("1000000.00");
		assertThat(Numeral.numerify("1000,000.00")).isEqualTo("1000000.00");
		assertThat(Numeral.numerify("1000.000,00")).isEqualTo("1000000.00");
		assertThat(Numeral.numerify("1,000,000.000")).isEqualTo("1000000.000");
		assertThat(Numeral.numerify("1.000.000,000")).isEqualTo("1000000.000");
	}

}