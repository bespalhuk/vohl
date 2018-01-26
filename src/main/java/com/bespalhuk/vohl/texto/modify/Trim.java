package com.bespalhuk.vohl.texto.modify;

import com.bespalhuk.vohl.Check;

public class Trim implements Modifier {

	Trim() {
	}

	@Override
	public String modify(String value) {
		Check.notNull(value);
		return value.trim();
	}

}