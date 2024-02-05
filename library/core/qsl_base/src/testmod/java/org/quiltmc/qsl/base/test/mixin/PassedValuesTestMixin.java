package org.quiltmc.qsl.base.test.mixin;

import org.quiltmc.qsl.base.api.util.PassedValues;
import org.quiltmc.qsl.base.test.QuiltBaseTestMod;
import org.quiltmc.qsl.base.test.event.EventTests;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = QuiltBaseTestMod.class, remap = false)
public class PassedValuesTestMixin {

	@ModifyArg(method = "onInititialize", at = @At(value = "INVOKE", target = "Lorg/quiltmc/qsl/base/test/QuiltBaseTestMod;eventTests(Lorg/quiltmc/qsl/base/test/event/EventTests;)Lorg/quiltmc/qsl/base/test/event/EventTests;"), index = 0)
	private void passValue(EventTests tests) {
		PassedValues.of(tests).insert(0, true);
	}

	@Inject(method = "eventTests", at = @At("TAIL"))
	private static void useValue(CallbackInfoReturnable<EventTests> cir) {
		if (PassedValues.of(cir.getReturnValue()).retrieve(0)) {
			QuiltBaseTestMod.LOGGER.info("PassedValues Test");
		}
	}
}
