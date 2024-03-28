package org.quiltmc.qsl.base.api.util;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.impl.util.MCModContainerImpl;

public interface MCModContainer extends ModContainer {

	static MCModContainer of(ModContainer source) {
		return new MCModContainerImpl(source);
	}

	Identifier createId(String path);

	<T> RegistryKey<T> createKey(RegistryKey<? extends Registry<T>> registry, String path);
}
