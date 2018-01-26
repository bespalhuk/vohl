package com.bespalhuk.vohl.texto.modify;

import com.bespalhuk.vohl.Check;

public class SingleSpaces implements Modifier {

	SingleSpaces() {
	}

	@Override
	public String modify(String value) {
		Check.notNull(value);
		return value.replaceAll("\\s+", " ");
	}

}