package com.bespalhuk.vohl.texto.modify;

public class Normalize implements Modifier {

	Normalize() {
	}

	@Override
	public String modify(String value) {
		return java.text.Normalizer.normalize(value, java.text.Normalizer.Form.NFD)
				.replaceAll("[^\\p{ASCII}]", "")
				.replaceAll("\\s+", " ")
				.trim();
	}

}