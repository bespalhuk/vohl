package com.bespalhuk.vohl.texto.modify;

import com.bespalhuk.vohl.Check;

public class Unseparate implements Modifier {

	Unseparate() {
	}

	@Override
	public String modify(String value) {
		Check.notNull(value);
		return value.replaceAll(" ", "")
				.replaceAll(",", "").replaceAll("\\.", "")
				.replaceAll("'", "").replaceAll("\"", "")
				.replaceAll("\\+", "").replaceAll("-", "")
				.replaceAll("\\*", "")
				.replaceAll("/", "").replaceAll("\\\\", "")
				.replaceAll("\\(", "").replaceAll("\\)", "")
				.replaceAll("\\[", "").replaceAll("\\]", "")
				.replaceAll("\\{", "").replaceAll("\\}", "");
	}

}