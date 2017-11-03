package com.bespalhuk.vohl;

import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckTest {

	@Test
	public void checkConstructor()
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Constructor<Check> constructor = Check.class.getDeclaredConstructor();
		assertThat(Modifier.isPrivate(constructor.getModifiers())).isTrue();
		constructor.setAccessible(true);
		constructor.newInstance();
		constructor.setAccessible(false);
	}

	@Test
	public void messagesConstructor()
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Constructor<Check.Messages> messages = Check.Messages.class.getDeclaredConstructor();
		assertThat(Modifier.isPrivate(messages.getModifiers())).isTrue();
		messages.setAccessible(true);
		messages.newInstance();
		messages.setAccessible(false);
	}

	@Test
	public void messages() {
		assertThat(Check.Messages.NOT_BLANK).isEqualTo("Value cannot be blank.");
		assertThat(Check.Messages.NOT_NULL).isEqualTo("Value cannot be null.");
		assertThat(Check.Messages.DIDNT_MATCH).isEqualTo("Value didn't match.");
	}

	@Test
	public void argumentTrue() {
		Check.argument(true);
		Check.argument(true, "Error");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void argumentFalse() {
		Check.argument(false);
	}

	@Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Error")
	public void argumentFalseMessage() {
		Check.argument(false, "Error");
	}

	@Test
	public void isBlank() {
		assertThat(Check.isBlank(null)).isTrue();
		assertThat(Check.isBlank("")).isTrue();
		assertThat(Check.isBlank(" ")).isTrue();
		assertThat(Check.isBlank("Bespalhuk")).isFalse();
	}

	@Test
	public void isEmpty() {
		assertThat(Check.isEmpty("")).isTrue();
		assertThat(Check.isEmpty(" ")).isTrue();
		assertThat(Check.isEmpty("Bespalhuk")).isFalse();
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void isEmptyNull() {
		Check.isEmpty(null);
	}

	@Test
	public void isNull() {
		assertThat(Check.isNull(null)).isTrue();
		assertThat(Check.isNull("")).isFalse();
		assertThat(Check.isNull(" ")).isFalse();
		assertThat(Check.isNull("Bespalhuk")).isFalse();
	}

	@Test
	public void notBlank() {
		Check.notBlank("Bespalhuk");
		Check.notBlank("Bespalhuk", "Error");
	}

	@Test(expectedExceptions = NullPointerException.class,
			expectedExceptionsMessageRegExp = "Value cannot be null.")
	public void notBlankNull() {
		Check.notBlank(null);
	}

	@Test(expectedExceptions = NullPointerException.class, expectedExceptionsMessageRegExp = "Error")
	public void notBlankNullMessage() {
		Check.notBlank(null, "Error");
	}

	@Test(expectedExceptions = IllegalArgumentException.class,
			expectedExceptionsMessageRegExp = "Value cannot be blank.")
	public void notBlankEmpty() {
		Check.notBlank("");
	}

	@Test(expectedExceptions = IllegalArgumentException.class,
			expectedExceptionsMessageRegExp = "Error")
	public void notBlankEmptyMessage() {
		Check.notBlank("", "Error");
	}

	@Test(expectedExceptions = IllegalArgumentException.class,
			expectedExceptionsMessageRegExp = "Value cannot be blank.")
	public void notBlankSpace() {
		Check.notBlank(" ");
	}

	@Test(expectedExceptions = IllegalArgumentException.class,
			expectedExceptionsMessageRegExp = "Error")
	public void notBlankSpaceMessage() {
		Check.notBlank(" ", "Error");
	}

	@Test
	public void notNull() {
		Check.notNull("");
		Check.notNull(" ");
		Check.notNull("Bespalhuk");
		Check.notNull("Bespalhuk", "Error");
	}

	@Test(expectedExceptions = NullPointerException.class,
			expectedExceptionsMessageRegExp = "Value cannot be null.")
	public void notNullNull() {
		Check.notNull(null);
	}

	@Test(expectedExceptions = NullPointerException.class, expectedExceptionsMessageRegExp = "Error")
	public void notNullNullMessage() {
		Check.notNull(null, "Error");
	}

	@Test
	public void stateTrue() {
		Check.state(true);
		Check.state(true, "Error");
	}

	@Test(expectedExceptions = IllegalStateException.class)
	public void stateFalse() {
		Check.state(false);
	}

	@Test(expectedExceptions = IllegalStateException.class, expectedExceptionsMessageRegExp = "Error")
	public void stateFalseMessage() {
		Check.state(false, "Error");
	}

}