package com.bespalhuk.vohl.numerico;

public class Level99 extends NumericoInteger<Level99> {

	private static final int MIN = 1;

	private static final int MAX = 99;

	private Level99(Integer value) {
		super(value);
	}

	public static Level99 of(Integer value) {
		new NumericoValidator<>(value).between(MIN, MAX);
		return new Level99(value);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Level99 && super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public Level99 up() {
		if (value == MAX) {
			throw new UnsupportedOperationException("Already on maximum level!");
		}
		return new Level99(value + 1);
	}

	public Level99 down() {
		if (value == MIN) {
			throw new UnsupportedOperationException("Already on minimum level!");
		}
		return new Level99(value - 1);
	}

}