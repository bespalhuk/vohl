package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.Check;
import com.google.common.collect.ComparisonChain;
import org.joox.Content;
import org.joox.Context;

import java.io.Serializable;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Objects;

public abstract class Numerico<T extends Numerico<T, N>, N extends Number & Comparable<N>> extends Number
		implements Comparable<T>, Formattable, Content, Serializable {

	private static final long serialVersionUID = 1L;

	protected final N value;

	protected Numerico(N value) {
		this.value = value;
	}

	public static String numerify(String value) {
		Check.notNull(value);
		Check.argument(value.matches("^\\d+(((,\\d+)*(\\.\\d+))|((\\.\\d+)*(,\\d+)))*$"));
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

}