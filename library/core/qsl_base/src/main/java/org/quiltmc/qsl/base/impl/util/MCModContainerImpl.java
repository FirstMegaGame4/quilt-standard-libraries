package org.quiltmc.qsl.base.impl.util;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.ModMetadata;
import org.quiltmc.qsl.base.api.util.MCModContainer;

import java.nio.file.Path;
import java.util.List;

public class MCModContainerImpl implements MCModContainer {

	private final ModContainer source;

	public MCModContainerImpl(ModContainer source) {
		this.source = source;
	}

	@Override
	public Identifier createId(String path) {
		return new Identifier(this.metadata().id(), path);
	}

	@Override
	public <T> RegistryKey<T> createKey(RegistryKey<? extends Registry<T>> registry, String path) {
		return RegistryKey.of(registry, new Identifier(this.metadata().id(), path));
	}

	@Override
	public ModMetadata metadata() {
		return this.source.metadata();
	}

	@Override
	public Path rootPath() {
		return this.source.rootPath();
	}

	@Override
	public List<List<Path>> getSourcePaths() {
		return this.source.getSourcePaths();
	}

	@Override
	public BasicSourceType getSourceType() {
		return this.source.getSourceType();
	}

	@Override
	public ClassLoader getClassLoader() {
		return this.source.getClassLoader();
	}
}
