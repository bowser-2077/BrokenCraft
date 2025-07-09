/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.brokencraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.brokencraft.BrokencraftMod;

public class BrokencraftModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, BrokencraftMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> GETWORSE = REGISTRY.register("getworse", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("brokencraft", "getworse")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BIOMESOUND = REGISTRY.register("biomesound", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("brokencraft", "biomesound")));
	public static final DeferredHolder<SoundEvent, SoundEvent> WHITENOISE = REGISTRY.register("whitenoise", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("brokencraft", "whitenoise")));
}