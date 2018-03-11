package com.bespalhuk.vohl.numerico;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PowerLevel extends BigNumerico<PowerLevel> {

	public static final int PRECISION = 4;

	public static final int SCALE = 2;

	public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;

	private static final BigDecimal MIN_VALUE = new BigDecimal("8000.00");

	public static final PowerLevel MIN = new PowerLevel(MIN_VALUE);

	private static final BigDecimal MAX_VALUE = new BigDecimal("8000.00");

	public static final PowerLevel MAX = new PowerLevel(MAX_VALUE);

	private PowerLevel(BigDecimal value) {
		super(value);
	}

	public static PowerLevel of(Object value) {
		BigDecimal validated = new BigNumericoValidator(value, SCALE, ROUNDING_MODE)
				.between(MIN_VALUE, MAX_VALUE)
				.getValue();
		if (MIN_VALUE.equals(validated)) {
			return PowerLevel.MIN;
		}
		if (MAX_VALUE.equals(validated)) {
			return PowerLevel.MAX;
		}
		return new PowerLevel(validated);
	}

	@Override
	public RoundingMode getRoundingMode() {
		return ROUNDING_MODE;
	}

	@Override
	public int getPrecision() {
		return PRECISION;
	}

	@Override
	public int getScale() {
		return SCALE;
	}

	@Override
	public PowerLevel sum(PowerLevel value) {
		return PowerLevel.of(this.value.add(value.getValue()));
	}

	@Override
	public PowerLevel subtract(PowerLevel value) {
		return PowerLevel.of(this.value.subtract(value.getValue()));
	}

	@Override
	public PowerLevel multiply(PowerLevel value) {
		return PowerLevel.of(this.value.multiply(value.getValue()));
	}

	@Override
	public PowerLevel divide(PowerLevel value) {
		return PowerLevel.of(this.value.divide(value.getValue(), SCALE, ROUNDING_MODE));
	}

	@Override
	public PowerLevel toFloor() {
		return new PowerLevel(value.setScale(0, RoundingMode.FLOOR));
	}

}