package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.Check;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumericoValidator<N extends Number & Comparable<N>> {

	private final N value;

	public NumericoValidator(N value) {
		this.value = value;
	}

	public NumericoValidator<N> between(N min, N max) {
		Check.notNull(min);
		Check.notNull(max);
		Check.argument(min.compareTo(max) <= 0,
				String.format("Valor mínimo (%s) deve ser inferior ou igual ao máximo (%s)", min, max));
		return this;
	}

	public NumericoValidator<N> min(N min) {
		Check.notNull(min);
		Check.argument(value.compareTo(min) >= 0,
				String.format("Deve ter valor mínimo %s. [%s]", min, value));
		return this;
	}

	public NumericoValidator<N> max(N max) {
		Check.notNull(max);
		Check.argument(value.compareTo(max) <= 0,
				String.format("Deve ter valor máximo %s. [%s]", max, value));
		return this;
	}

	public NumericoValidator<N> minLength(int min) {
		Check.argument(value.toString().length() >= min,
				String.format("Deve ter no mínimo %d caracteres. [%s]", min, value));
		return this;
	}

	public NumericoValidator<N> maxLength(int max) {
		Check.notNull(max);
		Check.argument(value.toString().length() <= max,
				String.format("Deve ter no máximo %d caracteres. [%s]", max, value));
		return this;
	}

	public NumericoValidator<N> matches(String regex) {
		Check.notNull(regex);
		Check.argument(value.toString().matches(regex), Check.Messages.DIDNT_MATCH);
		return this;
	}

	public NumericoValidator<N> matchesAny(List<Pattern> patterns) {
		boolean anyMatch = patterns.stream().map(p -> p.matcher(value.toString())).anyMatch(Matcher::find);
		Check.argument(anyMatch, Check.Messages.DIDNT_MATCH);
		return this;
	}

}