package com.bespalhuk.vohl.texto.modify;

import com.bespalhuk.vohl.Check;

public class LowerCase implements Modifier {

	LowerCase() {
	}

	@Override
	public String modify(String value) {
		Check.notNull(value);
		return value.toLowerCase();
	}

}