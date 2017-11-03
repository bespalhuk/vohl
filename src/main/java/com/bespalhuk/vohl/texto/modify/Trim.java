package com.bespalhuk.vohl.texto.modify;

public class Trim implements Modifier {

	Trim() {
	}

	@Override
	public String modify(String value) {
		return value.trim();
	}

}