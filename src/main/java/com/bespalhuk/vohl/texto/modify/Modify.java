package com.bespalhuk.vohl.texto.modify;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class Modify implements Modifier {

	private final List<Modifier> modifiers;

	private Modify(List<Modifier> modifiers) {
		this.modifiers = modifiers;
	}

	public static Modify of(Modifier... modifiers) {
		return new Modify(ImmutableList.copyOf(modifiers));
	}

	@Override
	public String modify(String value) {
		for (Modifier modifier : modifiers) {
			value = modifier.modify(value);
		}
		return value;
	}

}