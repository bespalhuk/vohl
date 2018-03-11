package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.Check;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigNumericoValidator {

	private final BigDecimal value;

	public BigNumericoValidator(Object value, int scale, RoundingMode roundingMode) {
		Check.notNull(value);
		Check.notNull(scale);
		Check.notNull(roundingMode);
		this.value = new BigDecimal(Numeral.numerify(value.toString())).setScale(scale, roundingMode);
	}

	public BigNumericoValidator between(BigDecimal min, BigDecimal max) {
		Check.notNull(min);
		Check.notNull(max);
		Check.argument(min.compareTo(max) <= 0,
				String.format("Valor mínimo (%s) deve ser inferior ou igual ao máximo (%s)", min, max));
		min(min);
		max(max);
		return this;
	}

	public BigNumericoValidator min(BigDecimal min) {
		Check.notNull(min);
		Check.argument(value.compareTo(min) >= 0,
				String.format("Deve ter valor mínimo %s. [%s]", min, value));
		return this;
	}

	public BigNumericoValidator max(BigDecimal max) {
		Check.notNull(max);
		Check.argument(value.compareTo(max) <= 0,
				String.format("Deve ter valor máximo %s. [%s]", max, value));
		return this;
	}

	public BigNumericoValidator minLength(int min) {
		Check.argument(value.toString().length() >= min,
				String.format("Deve ter no mínimo %d caracteres. [%s]", min, value));
		return this;
	}

	public BigNumericoValidator maxLength(int max) {
		Check.notNull(max);
		Check.argument(value.toString().length() <= max,
				String.format("Deve ter no máximo %d caracteres. [%s]", max, value));
		return this;
	}

	public BigDecimal getValue() {
		return value;
	}

}