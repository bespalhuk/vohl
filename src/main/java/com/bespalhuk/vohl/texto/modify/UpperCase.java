package com.bespalhuk.vohl.texto.modify;

import com.bespalhuk.vohl.Check;

public class UpperCase implements Modifier {

	UpperCase() {
	}

	@Override
	public String modify(String value) {
		Check.notNull(value);
		return value.toUpperCase();
	}

}