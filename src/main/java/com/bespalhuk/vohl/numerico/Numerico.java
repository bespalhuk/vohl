package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.Check;
import com.google.common.collect.ComparisonChain;
import org.joox.Content;
import org.joox.Context;

import java.io.Serializable;
import java.util.Formattable;
import java.util.Formatter;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Numerico<T extends Numerico<T, N>, N extends Number & Comparable<N>> extends Number
		implements Comparable<T>, Formattable, Content, Serializable {

	private static final long serialVersionUID = 1L;

	protected final N value;

	protected Numerico(Builder builder) {
		this.value = (N) builder.build();
	}

	protected static <N extends Number> Builder builder(N value) {
		Check.notNull(value);
		return new Builder(value);
	}

	public static String numerify(String value) {
		Check.notNull(value);
		Check.argument(value.matches("^\\d+(((\\,\\d+)*(\\.\\d+))|((\\.\\d+)*(\\,\\d+)))*$"));
		if (value.lastIndexOf(",") > value.lastIndexOf(".")) {
			return value.replaceAll("\\.", "").replaceAll(",", ".");
		}
		return value.replaceAll(",", "");
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Numerico) {
			Numerico o = (Numerico) obj;
			return Objects.equals(this.value, o.value);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public int compareTo(T o) {
		return ComparisonChain.start().compare(this.value, o.value).result();
	}

	@Override
	public void formatTo(Formatter formatter, int flags, int width, int precision) {
		formatter.format("%s", value);
	}

	@Override
	public String content(Context context) {
		return toString();
	}

	public boolean isZero() {
		return value.intValue() == 0;
	}

	public boolean isMaiorOuIgualZero() {
		return value.intValue() >= 0;
	}

	public boolean isMaiorQue(T value) {
		Check.notNull(value);
		return this.compareTo(value) > 0;
	}

	public boolean isMaiorOuIgualQue(T value) {
		Check.notNull(value);
		return this.compareTo(value) >= 0;
	}

	public boolean isPositivo() {
		return value.intValue() > 0;
	}

	public boolean isNegativo() {
		return value.intValue() < 0;
	}

	public N getValue() {
		return value;
	}

	@Override
	public int intValue() {
		return value.intValue();
	}

	@Override
	public long longValue() {
		return value.longValue();
	}

	@Override
	public float floatValue() {
		return value.floatValue();
	}

	@Override
	public double doubleValue() {
		return value.doubleValue();
	}

	@Override
	public byte byteValue() {
		return value.byteValue();
	}

	@Override
	public short shortValue() {
		return value.shortValue();
	}

	public static class Builder<N extends Number & Comparable<N>> {

		private N value;

		private Builder(N value) {
			this.value = value;
		}

		public Builder between(N min, N max) {
			Check.notNull(min);
			Check.notNull(max);
			Check.argument(min.compareTo(max) <= 0,
					String.format("Valor mínimo (%d) deve ser inferior ou igual ao máximo (%d)", min, max));
			min(min);
			max(max);
			return this;
		}

		public Builder min(N min) {
			Check.notNull(min);
			Check.argument(value.compareTo(min) >= 0,
					String.format("Deve ter valor mínimo %d. [%s]", min, value));
			return this;
		}

		public Builder max(N max) {
			Check.notNull(max);
			Check.argument(value.compareTo(max) <= 0,
					String.format("Deve ter valor máximo %d. [%s]", max, value));
			return this;
		}

		public Builder minLength(int min) {
			Check.notNull(min);
			Check.argument(value.toString().length() >= min,
					String.format("Deve ter no mínimo %d caracteres. [%s]", min, value));
			return this;
		}

		public Builder maxLength(int max) {
			Check.notNull(max);
			Check.argument(value.toString().length() <= max,
					String.format("Deve ter no máximo %d caracteres. [%s]", max, value));
			return this;
		}

		public Builder matches(String regex) {
			Check.notNull(regex);
			Check.argument(value.toString().matches(regex), Check.Messages.DIDNT_MATCH);
			return this;
		}

		public Builder matchesAny(List<Pattern> patterns) {
			Check.notNull(patterns);
			boolean anyMatch = patterns.stream().map(p -> p.matcher(value.toString())).anyMatch(Matcher::find);
			Check.argument(anyMatch, Check.Messages.DIDNT_MATCH);
			return this;
		}

		private N build() {
			return value;
		}

	}

}