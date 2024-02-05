package org.quiltmc.qsl.base.impl.util;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import org.quiltmc.qsl.base.api.util.PassedValues;

public class PassedValuesImpl implements PassedValues {

	public static PassedValues of(Object object) {
		return ((ObjectPassedValues) object).qsl$getPassedValues();
	}

	private final Int2ObjectMap<Object> values = new Int2ObjectOpenHashMap<>();

	public <T> void insert(int index, T value) {
		this.values.put(index, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T retrieve(int index) {
		return (T) this.values.get(index);
	}

	public void delete(int index) {
		this.values.remove(index);
	}

	public <T> T extract(int index) {
		T value = this.retrieve(index);
		this.delete(index);
		return value;
	}
}
