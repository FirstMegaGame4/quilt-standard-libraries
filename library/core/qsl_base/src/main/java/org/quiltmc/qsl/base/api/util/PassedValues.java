package org.quiltmc.qsl.base.api.util;

import org.quiltmc.qsl.base.impl.util.PassedValuesImpl;

public interface PassedValues {

	/**
	 * Allows to retrieve the {@link PassedValues} instance of a specific object
	 * @param object the specific object
	 * @return the {@link PassedValues} instance
	 */
	static PassedValues of(Object object) {
		return PassedValuesImpl.of(object);
	}

	/**
	 * Allows to insert a value at a specific index
	 * @param index the index where the value will be stored
	 * @param value the value that will be stored
	 * @param <T> the type of that value
	 */
	<T> void insert(int index, T value);

	/**
	 * Allows to retrieve a value at a specific index
	 * @param index the index where the value should be stored
	 * @return the found value
	 * @param <T> the type of the found value
	 */
	<T> T retrieve(int index);

	/**
	 * Allows to delete a value at a specific index
	 * @param index the index where the value should be stored
	 */
	void delete(int index);

	/**
	 * Allows to extract a value at a specific index, meaning that you will get the value and delete it just after
	 * @param index the index where the value should be stored
	 * @return the found value
	 * @param <T> the type of the found value
	 */
	<T> T extract(int index);
}
