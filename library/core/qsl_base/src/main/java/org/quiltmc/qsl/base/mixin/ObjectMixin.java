package org.quiltmc.qsl.base.mixin;

import org.quiltmc.qsl.base.impl.util.ObjectPassedValues;
import org.quiltmc.qsl.base.api.util.PassedValues;
import org.quiltmc.qsl.base.impl.util.PassedValuesImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Object.class)
public class ObjectMixin implements ObjectPassedValues {

	private final PassedValues passedValues = this.initPassedValues();

	@Override
	public PassedValues qsl$getPassedValues() {
		return this.passedValues;
	}

	@Unique
	private PassedValues initPassedValues() {
		return this instanceof PassedValues ? null : new PassedValuesImpl();
	}
}
