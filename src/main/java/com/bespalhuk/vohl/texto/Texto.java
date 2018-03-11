package com.bespalhuk.vohl.texto;

import com.bespalhuk.vohl.Check;
import com.bespalhuk.vohl.texto.modify.Modifier;
import com.bespalhuk.vohl.texto.modify.Modify;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.MoreCollectors;
import org.joox.Content;
import org.joox.Context;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
		Check.notNull(o);
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
			Check.notNull(modifiers);
			this.value = Modify.of(modifiers).modify(value);
			return this;
		}

		public Builder between(int min, int max) {
			Check.notNull(min);
			Check.notNull(max);
			Check.argument(min <= max,
					String.format("Mínimo (%d) deve ser inferior ou igual ao máximo (%d)", min, max));
			min(min);
			max(max);
			return this;
		}

		public Builder min(int min) {
			Check.notNull(min);
			Check.argument(value.length() >= min,
					String.format("Deve ter no mínimo %d caracteres. [%s]", min, value));
			return this;
		}

		public Builder max(int max) {
			Check.notNull(max);
			Check.argument(value.length() <= max,
					String.format("Deve ter no máximo %d caracteres. [%s]", max, value));
			return this;
		}

		public Builder matches(String regex) {
			Check.notNull(regex);
			Check.argument(value.matches(regex), Check.Messages.DIDNT_MATCH);
			return this;
		}

		public Builder matches(Pattern pattern) {
			Check.notNull(pattern);
			Check.argument(pattern.matcher(value).find(), Check.Messages.DIDNT_MATCH);
			return this;
		}

		public Builder matchesAny(String... regexs) {
			Check.notNull(regexs);
			matchesAny(Arrays.stream(regexs).map(Pattern::compile).collect(Collectors.toList()));
			return this;
		}

		public Builder matchesAny(List<Pattern> patterns) {
			Check.notNull(patterns);
			boolean anyMatch = patterns.stream().map(p -> p.matcher(value)).anyMatch(Matcher::find);
			Check.argument(anyMatch, Check.Messages.DIDNT_MATCH);
			return this;
		}

		public String getValue() {
			return value;
		}

		private String build() {
			return value;
		}

	}

}