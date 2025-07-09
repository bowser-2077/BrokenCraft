package net.mcreator.brokencraft.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class AmethystSwordItem extends SwordItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 361, 7f, 0, 18, TagKey.create(Registries.ITEM, ResourceLocation.parse("brokencraft:amethyst_sword_repair_items")));

	public AmethystSwordItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 4f, 0f, properties);
	}
}