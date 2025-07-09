package net.mcreator.brokencraft.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class AmethystOreBlock extends Block {
	public AmethystOreBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(3.9f, 6.1677205204f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.HARP));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}