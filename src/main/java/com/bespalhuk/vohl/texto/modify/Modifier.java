package com.bespalhuk.vohl.texto.modify;

import com.bespalhuk.vohl.Check;

public interface Modifier {

	static Modifier lowerCase() {
		return new LowerCase();
	}

	static Modifier normalize() {
		return new Normalize();
	}

	static Modifier singleSpaces() {
		return new SingleSpaces();
	}

	static Modifier trim() {
		return new Trim();
	}

	static Modifier truncate(int i) {
		Check.notNull(i);
		return new Truncate(i);
	}

	static Modifier truncate(int i, String replacer) {
		Check.notNull(i);
		Check.notNull(replacer);
		return new Truncate(i, replacer);
	}

	static Modifier unseparate() {
		return new Unseparate();
	}

	static Modifier upperCase() {
		return new UpperCase();
	}

	String modify(String value);

}