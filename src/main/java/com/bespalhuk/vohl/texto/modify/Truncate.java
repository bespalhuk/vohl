package com.bespalhuk.vohl.texto.modify;

public class Truncate implements Modifier {

	private final int limit;

	private final String replacer;

	Truncate(int limit) {
		this.limit = limit;
		this.replacer = "";
	}

	Truncate(int limit, String replacer) {
		this.limit = limit;
		this.replacer = replacer;
	}

	@Override
	public String modify(String value) {
		int l = limit - replacer.length();
		if (value.length() > limit && l > 0) {
			return String.format("%s%s", value.substring(0, limit - replacer.length()), replacer);
		}
		return value.substring(0, limit);
	}

}