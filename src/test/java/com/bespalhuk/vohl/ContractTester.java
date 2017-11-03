package com.bespalhuk.vohl;

import static org.assertj.core.api.Assertions.assertThat;

public class ContractTester {

	public static void test(Object value1, Object value2, Object value3) {
		Check.notNull(value1);
		Check.notNull(value2);
		Check.notNull(value3);
		equals(value1, value2, value3);
		hash(value1, value2, value3);
	}

	private static void equals(Object value1, Object value2, Object value3) {
		assertThat(value1.equals(value2)).isTrue();
		assertThat(value1.equals(value3)).isFalse();
		assertThat(value1.equals("")).isFalse();
	}

	private static void hash(Object value1, Object value2, Object value3) {
		assertThat(value1.hashCode()).isEqualTo(value2.hashCode());
		assertThat(value1.hashCode()).isNotEqualTo(value3.hashCode());
	}

}