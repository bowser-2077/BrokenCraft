/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.brokencraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.brokencraft.item.AmethystSwordItem;
import net.mcreator.brokencraft.item.AmethystShovelItem;
import net.mcreator.brokencraft.item.AmethystPickaxeItem;
import net.mcreator.brokencraft.item.AmethystIngotItem;
import net.mcreator.brokencraft.item.AmethystHoeItem;
import net.mcreator.brokencraft.item.AmethystAxeItem;
import net.mcreator.brokencraft.item.AmethystArmorItem;
import net.mcreator.brokencraft.BrokencraftMod;

import java.util.function.Function;

public class BrokencraftModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(BrokencraftMod.MODID);
	public static final DeferredItem<Item> THETHING_SPAWN_EGG = register("thething_spawn_egg", properties -> new SpawnEggItem(BrokencraftModEntities.THETHING.get(), properties));
	public static final DeferredItem<Item> AMETHYST_INGOT = register("amethyst_ingot", AmethystIngotItem::new);
	public static final DeferredItem<Item> AMETHYST_ORE = block(BrokencraftModBlocks.AMETHYST_ORE);
	public static final DeferredItem<Item> AMETHYST_BLOCK = block(BrokencraftModBlocks.AMETHYST_BLOCK);
	public static final DeferredItem<Item> AMETHYST_PICKAXE = register("amethyst_pickaxe", AmethystPickaxeItem::new);
	public static final DeferredItem<Item> AMETHYST_AXE = register("amethyst_axe", AmethystAxeItem::new);
	public static final DeferredItem<Item> AMETHYST_SWORD = register("amethyst_sword", AmethystSwordItem::new);
	public static final DeferredItem<Item> AMETHYST_SHOVEL = register("amethyst_shovel", AmethystShovelItem::new);
	public static final DeferredItem<Item> AMETHYST_HOE = register("amethyst_hoe", AmethystHoeItem::new);
	public static final DeferredItem<Item> AMETHYST_ARMOR_HELMET = register("amethyst_armor_helmet", AmethystArmorItem.Helmet::new);
	public static final DeferredItem<Item> AMETHYST_ARMOR_CHESTPLATE = register("amethyst_armor_chestplate", AmethystArmorItem.Chestplate::new);
	public static final DeferredItem<Item> AMETHYST_ARMOR_LEGGINGS = register("amethyst_armor_leggings", AmethystArmorItem.Leggings::new);
	public static final DeferredItem<Item> AMETHYST_ARMOR_BOOTS = register("amethyst_armor_boots", AmethystArmorItem.Boots::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), properties);
	}
}