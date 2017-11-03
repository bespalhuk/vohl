package com.bespalhuk.vohl.texto;

import com.bespalhuk.vohl.texto.modify.Modifier;

public class Nome extends Texto<Nome> {

	public static final int MAX_LENGTH = 60;

	public static final String REGEX =
			"^[a-zA-ZàáâäąòóôöèéëêęìíïîçćùúûüÿńñźżśæœßłÀÁÂÄĄÒÓÔÖÈÉËÊĘÌÍÏÎÇĆÙÚÛÜŸŃÑŹŻŚÆŒẞŁ ]*$";

	private Nome(Builder builder) {
		super(builder);
	}

	public static Nome of(String value) {
		Builder builder = Texto.builder(value)
				.between(1, 60)
				.matches(REGEX)
				.modifiers(Modifier.trim())
				.notBlank();
		return new Nome(builder);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Nome) {
			return super.equals(obj);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}