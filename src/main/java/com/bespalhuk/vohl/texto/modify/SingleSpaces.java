package com.bespalhuk.vohl.texto.modify;

public class SingleSpaces implements Modifier {

	SingleSpaces() {
	}

	@Override
	public String modify(String value) {
		return value.replaceAll("\\s+", " ");
	}

}