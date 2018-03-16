package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.Check;
import com.google.common.collect.ComparisonChain;
import org.joox.Context;

import java.util.Formatter;
import java.util.Objects;

public abstract class NumericoLong<T extends NumericoLong<T>> implements Numeral<T, Long> {

	private static final long serialVersionUID = 1L;

	protected final Long value;

	protected NumericoLong(Long value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof NumericoLong) {
			NumericoLong o = (NumericoLong) obj;
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

	@Override
	public boolean isPositivo() {
		return value > 0;
	}

	@Override
	public boolean isNegativo() {
		return value < 0;
	}

	@Override
	public boolean isZero() {
		return value == 0;
	}

	@Override
	public boolean isMinimoZero() {
		return value >= 0;
	}

	@Override
	public boolean isMaximoZero() {
		return value <= 0;
	}

	@Override
	public boolean isMaiorQue(T value) {
		Check.notNull(value);
		return this.value.compareTo(value.value) > 0;
	}

	@Override
	public boolean isMaiorOuIgualQue(T value) {
		Check.notNull(value);
		return this.value.compareTo(value.value) >= 0;
	}

	@Override
	public Long getValue() {
		return value;
	}

}