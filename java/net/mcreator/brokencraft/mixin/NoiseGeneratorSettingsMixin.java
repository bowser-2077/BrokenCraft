package net.mcreator.brokencraft.mixin;

import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.core.Holder;

import net.mcreator.brokencraft.init.BrokencraftModBiomes;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin implements BrokencraftModBiomes.BrokencraftModNoiseGeneratorSettings {
	@Unique
	private Holder<DimensionType> brokencraft_dimensionTypeReference;

	@WrapMethod(method = "surfaceRule")
	public SurfaceRules.RuleSource surfaceRule(Operation<SurfaceRules.RuleSource> original) {
		SurfaceRules.RuleSource retval = original.call();
		if (this.brokencraft_dimensionTypeReference != null) {
			retval = BrokencraftModBiomes.adaptSurfaceRule(retval, this.brokencraft_dimensionTypeReference);
		}
		return retval;
	}

	@Override
	public void setbrokencraftDimensionTypeReference(Holder<DimensionType> dimensionType) {
		this.brokencraft_dimensionTypeReference = dimensionType;
	}
}