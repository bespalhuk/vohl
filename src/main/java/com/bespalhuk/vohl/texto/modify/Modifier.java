package com.bespalhuk.vohl.texto.modify;

public interface Modifier {

	static Modifier normalize() {
		return new Normalize();
	}

	static Modifier lowerCase() {
		return new LowerCase();
	}

	static Modifier upperCase() {
		return new UpperCase();
	}

	static Modifier singleSpaces() {
		return new SingleSpaces();
	}

	static Modifier trim() {
		return new Trim();
	}

	static Modifier unseparate() {
		return new Unseparate();
	}

	String modify(String value);

}