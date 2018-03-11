package com.bespalhuk.vohl.numerico;

import com.bespalhuk.vohl.Check;
import org.joox.Content;

import java.io.Serializable;
import java.util.Formattable;

public interface Numeral<T extends Numeral, N extends Number>
		extends Comparable<T>, Formattable, Content, Serializable {

	static String numerify(String value) {
		Check.notNull(value);
		Check.argument(value.matches("^\\d+(((,\\d+)*(\\.\\d+))|((\\.\\d+)*(,\\d+)))*$"));
		if (value.lastIndexOf(",") > value.lastIndexOf(".")) {
			return value.replaceAll("\\.", "").replaceAll(",", ".");
		}
		return value.replaceAll(",", "");
	}

	boolean isPositivo();

	boolean isNegativo();

	boolean isZero();

	boolean isMinimoZero();

	boolean isMaximoZero();

	boolean isMaiorQue(T value);

	boolean isMaiorOuIgualQue(T value);

	N getValue();

}