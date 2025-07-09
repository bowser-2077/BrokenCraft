/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.brokencraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.brokencraft.BrokencraftMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BrokencraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BrokencraftMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(BrokencraftModItems.THETHING_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(BrokencraftModItems.AMETHYST_INGOT.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(BrokencraftModBlocks.AMETHYST_ORE.get().asItem());
			tabData.accept(BrokencraftModBlocks.AMETHYST_BLOCK.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(BrokencraftModItems.AMETHYST_PICKAXE.get());
			tabData.accept(BrokencraftModItems.AMETHYST_AXE.get());
			tabData.accept(BrokencraftModItems.AMETHYST_SHOVEL.get());
			tabData.accept(BrokencraftModItems.AMETHYST_HOE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(BrokencraftModItems.AMETHYST_SWORD.get());
			tabData.accept(BrokencraftModItems.AMETHYST_ARMOR_HELMET.get());
			tabData.accept(BrokencraftModItems.AMETHYST_ARMOR_CHESTPLATE.get());
			tabData.accept(BrokencraftModItems.AMETHYST_ARMOR_LEGGINGS.get());
			tabData.accept(BrokencraftModItems.AMETHYST_ARMOR_BOOTS.get());
		}
	}
}