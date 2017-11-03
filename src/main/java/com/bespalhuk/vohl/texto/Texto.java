package com.bespalhuk.vohl.texto;

import com.bespalhuk.vohl.Check;
import com.bespalhuk.vohl.texto.modify.Modifier;
import com.bespalhuk.vohl.texto.modify.Modify;
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

public abstract class Texto<T extends Texto<T>> implements Comparable<T>, Formattable, Content, Serializable {

	private static final long serialVersionUID = 1L;

	protected final String value;

	protected Texto(Builder builder) {
		this.value = builder.build();
	}

	protected static Builder builder(String value) {
		Check.notNull(value);
		return new Builder(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Texto) {
			Texto o = (Texto) obj;
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
		return value;
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
		return value;
	}

	public static class Builder {

		private String value;

		private Builder(String value) {
			this.value = value;
		}

		public Builder modifiers(Modifier... modifiers) {
			this.value = Modify.of(modifiers).modify(value);
			return this;
		}

		public Builder between(int min, int max) {
			Check.argument(min <= max,
					String.format("Mínimo (%d) deve ser inferior ou igual ao máximo (%d)", min, max));
			min(min);
			max(max);
			return this;
		}

		public Builder min(int length) {
			Check.argument(value.length() >= length,
					String.format("%s deve ter no mínimo %d caracteres.", value, length));
			return this;
		}

		public Builder max(int length) {
			Check.argument(value.length() <= length,
					String.format("%s deve ter no máximo %d caracteres.", value, length));
			return this;
		}

		public Builder matches(String regex) {
			Check.argument(value.matches(regex), Check.Messages.DIDNT_MATCH);
			return this;
		}

		public Builder matches(List<Pattern> patterns) {
			boolean anyMatch = patterns.stream().map(p -> p.matcher(value)).anyMatch(Matcher::find);
			Check.argument(anyMatch, Check.Messages.DIDNT_MATCH);
			return this;
		}

		public Builder notBlank() {
			Check.notBlank(value);
			return this;
		}

		private String build() {
			return value;
		}

	}

}