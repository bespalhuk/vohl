package com.bespalhuk.vohl.texto.modify;

public class LowerCase implements Modifier {

	LowerCase() {
	}

	@Override
	public String modify(String value) {
		return value.toLowerCase();
	}

}