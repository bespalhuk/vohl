package com.bespalhuk.vohl;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ContractTester {

	public static void test(Object value, List<Object> equals, List<Object> notEquals) {
		Check.notNull(value);
		Check.notNull(equals);
		Check.notNull(notEquals);
		equals(value, equals, notEquals);
		hash(value, equals, notEquals);
	}

	private static void equals(Object value, List<Object> equals, List<Object> notEquals) {
		equals.forEach(e -> assertThat(value.equals(e)).isTrue());
		notEquals.forEach(n -> assertThat(value.equals(n)).isFalse());
		assertThat(value.equals("")).isFalse();
	}

	private static void hash(Object value, List<Object> equals, List<Object> notEquals) {
		equals.forEach(e -> assertThat(value.hashCode()).isEqualTo(e.hashCode()));
		notEquals.forEach(n -> assertThat(value.hashCode()).isNotEqualTo(n.hashCode()));
	}

}