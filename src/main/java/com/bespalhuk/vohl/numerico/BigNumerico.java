package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.Check;
import com.google.common.collect.ComparisonChain;
import org.joox.Context;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Formatter;
import java.util.Objects;

public abstract class BigNumerico<T extends BigNumerico<T>> implements Numeral<T, BigDecimal> {

	protected final BigDecimal value;

	protected BigNumerico(BigDecimal value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BigNumerico) {
			BigNumerico o = (BigNumerico) obj;
			return Objects.equals(this.value, o.value);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return value.toPlainString();
	}

	@Override
	public int compareTo(T o) {
		return ComparisonChain.start().compare(this.value, o).result();
	}

	@Override
	public void formatTo(Formatter formatter, int flags, int width, int precision) {
		formatter.format("%s", value.setScale(precision < 0 ? value.scale() : precision, getRoundingMode()));
	}

	@Override
	public String content(Context context) {
		return toString();
	}

	@Override
	public boolean isPositivo() {
		return value.compareTo(BigDecimal.ZERO) > 0;
	}

	@Override
	public boolean isNegativo() {
		return value.compareTo(BigDecimal.ZERO) < 0;
	}

	@Override
	public boolean isZero() {
		return value.compareTo(BigDecimal.ZERO) == 0;
	}

	@Override
	public boolean isMinimoZero() {
		return value.compareTo(BigDecimal.ZERO) >= 0;
	}

	@Override
	public boolean isMaximoZero() {
		return value.compareTo(BigDecimal.ZERO) <= 0;
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
	public BigDecimal getValue() {
		return value;
	}

	public BigDecimal truncate(int decimals) {
		return value.setScale(decimals, RoundingMode.FLOOR);
	}

	public abstract RoundingMode getRoundingMode();

	public abstract int getPrecision();

	public abstract int getScale();

	public abstract T sum(T value);

	public abstract T subtract(T value);

	public abstract T multiply(T value);

	public abstract T divide(T value);

	public abstract T toFloor();

}