package com.bespalhuk.vohl.texto;

import com.bespalhuk.vohl.texto.modify.Modifier;

public class Namee extends Texto<Namee> {

	public static final int MAX_LENGTH = 60;

	public static final String REGEX =
			"^[a-zA-ZàáâäąòóôöèéëêęìíïîçćùúûüÿńñźżśæœßłÀÁÂÄĄÒÓÔÖÈÉËÊĘÌÍÏÎÇĆÙÚÛÜŸŃÑŹŻŚÆŒẞŁ ]*$";

	protected Namee(Builder builder) {
		super(builder);
	}

	public static Namee of(String value) {
		Builder builder = Texto.builder(value)
				.matches(REGEX)
				.modifiers(Modifier.trim(), Modifier.singleSpaces())
				.between(1, MAX_LENGTH);
		return new Namee(builder);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Namee && super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}