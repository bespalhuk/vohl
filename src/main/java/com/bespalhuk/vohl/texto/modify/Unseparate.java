package com.bespalhuk.vohl.texto.modify;

public class Unseparate implements Modifier {

	Unseparate() {
	}

	@Override
	public String modify(String value) {
		return value.replaceAll(" ", "")
				.replaceAll(",", "").replaceAll("\\.", "")
				.replaceAll("\\+", "").replaceAll("-", "")
				.replaceAll("\\*", "")
				.replaceAll("/", "").replaceAll("\\\\", "")
				.replaceAll("\\(", "").replaceAll("\\)", "")
				.replaceAll("\\[", "").replaceAll("\\]", "")
				.replaceAll("\\{", "").replaceAll("\\}", "");
	}

}