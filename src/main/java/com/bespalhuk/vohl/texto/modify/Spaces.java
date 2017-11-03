package com.bespalhuk.vohl.texto.modify;

public class Spaces implements Modifier {

	Spaces() {
	}

	@Override
	public String modify(String value) {
		return value.replaceAll("\\s+", " ");
	}

}