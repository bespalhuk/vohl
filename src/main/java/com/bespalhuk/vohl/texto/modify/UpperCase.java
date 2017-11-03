package com.bespalhuk.vohl.texto.modify;

public class UpperCase implements Modifier {

	UpperCase() {
	}

	@Override
	public String modify(String value) {
		return value.toUpperCase();
	}

}