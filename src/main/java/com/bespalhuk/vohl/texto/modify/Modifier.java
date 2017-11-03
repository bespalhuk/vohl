package com.bespalhuk.vohl.texto.modify;

public interface Modifier {

	static Modifier normalize() {
		return new Normalizer();
	}

	static Modifier lowerCase() {
		return new LowerCase();
	}

	static Modifier upperCase() {
		return new UpperCase();
	}

	static Modifier spaces() {
		return new Spaces();
	}

	static Modifier trim() {
		return new Trim();
	}

	String modify(String value);

}