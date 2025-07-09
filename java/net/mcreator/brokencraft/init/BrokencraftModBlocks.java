/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.brokencraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.brokencraft.block.AmethystOreBlock;
import net.mcreator.brokencraft.block.AmethystBlockBlock;
import net.mcreator.brokencraft.BrokencraftMod;

import java.util.function.Function;

public class BrokencraftModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(BrokencraftMod.MODID);
	public static final DeferredBlock<Block> AMETHYST_ORE = register("amethyst_ore", AmethystOreBlock::new);
	public static final DeferredBlock<Block> AMETHYST_BLOCK = register("amethyst_block", AmethystBlockBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier, BlockBehaviour.Properties.of());
	}
}