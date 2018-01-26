package com.bespalhuk.vohl.texto.modify;

import com.bespalhuk.vohl.Check;

public class Normalize implements Modifier {

	Normalize() {
	}

	@Override
	public String modify(String value) {
		Check.notNull(value);
		return java.text.Normalizer.normalize(value, java.text.Normalizer.Form.NFD)
				.replaceAll("[^\\p{ASCII}]", "")
				.replaceAll("\\s+", " ")
				.trim();
	}

}