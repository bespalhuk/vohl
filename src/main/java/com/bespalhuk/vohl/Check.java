package com.bespalhuk.vohl;

public class Check {

	private Check() {
	}

	public static void argument(boolean expression) {
		if (!expression) {
			throw new IllegalArgumentException();
		}
	}

	public static void argument(boolean expression, Object errorMessage) {
		if (!expression) {
			throw new IllegalArgumentException(String.valueOf(errorMessage));
		}
	}

	public static boolean isBlank(String value) {
		return isNull(value) || isEmpty(value);
	}

	public static boolean isEmpty(String value) {
		return value.trim().isEmpty();
	}

	public static boolean isNull(Object value) {
		return value == null;
	}

	public static void notBlank(String value) {
		notNull(value);
		if (isBlank(value)) {
			throw new IllegalArgumentException(Messages.NOT_BLANK);
		}
	}

	public static void notBlank(String value, Object errorMessage) {
		notNull(value, errorMessage);
		if (isBlank(value)) {
			throw new IllegalArgumentException(String.valueOf(errorMessage));
		}
	}

	public static void notNull(Object value) {
		if (isNull(value)) {
			throw new NullPointerException(Messages.NOT_NULL);
		}
	}

	public static void notNull(Object value, Object errorMessage) {
		if (isNull(value)) {
			throw new NullPointerException(String.valueOf(errorMessage));
		}
	}

	public static void state(boolean expression) {
		if (!expression) {
			throw new IllegalStateException();
		}
	}

	public static void state(boolean expression, Object errorMessage) {
		if (!expression) {
			throw new IllegalStateException(String.valueOf(errorMessage));
		}
	}

	public static class Messages {

		public static final String NOT_BLANK = "Value cannot be blank.";

		public static final String NOT_NULL = "Value cannot be null.";

		public static final String DIDNT_MATCH = "Value didn't match.";

		private Messages() {
		}

	}

}