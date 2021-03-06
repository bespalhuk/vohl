package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.Check;

public class NumericoValidator<T extends Number & Comparable<T>> {

	private final T value;

	public NumericoValidator(T value) {
		Check.notNull(value);
		this.value = value;
	}

	public NumericoValidator<T> between(T min, T max) {
		Check.notNull(min);
		Check.notNull(max);
		Check.argument(min.compareTo(max) <= 0,
				String.format("Valor mínimo (%s) deve ser inferior ou igual ao máximo (%s)", min, max));
		min(min);
		max(max);
		return this;
	}

	public NumericoValidator<T> min(T min) {
		Check.notNull(min);
		Check.argument(value.compareTo(min) >= 0,
				String.format("Deve ter valor mínimo %s. [%s]", min, value));
		return this;
	}

	public NumericoValidator<T> max(T max) {
		Check.notNull(max);
		Check.argument(value.compareTo(max) <= 0,
				String.format("Deve ter valor máximo %s. [%s]", max, value));
		return this;
	}

	public NumericoValidator<T> minLength(int min) {
		Check.argument(value.toString().length() >= min,
				String.format("Deve ter no mínimo %d caracteres. [%s]", min, value));
		return this;
	}

	public NumericoValidator<T> maxLength(int max) {
		Check.notNull(max);
		Check.argument(value.toString().length() <= max,
				String.format("Deve ter no máximo %d caracteres. [%s]", max, value));
		return this;
	}

}