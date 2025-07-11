/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.brokencraft.init;

import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.biome.FeatureSorter;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;

import java.util.List;
import java.util.ArrayList;

import com.mojang.datafixers.util.Pair;

import com.google.common.base.Suppliers;

@EventBusSubscriber
public class BrokencraftModBiomes {
	@SubscribeEvent
	public static void onServerAboutToStart(ServerAboutToStartEvent event) {
		MinecraftServer server = event.getServer();
		Registry<LevelStem> levelStemTypeRegistry = server.registryAccess().lookupOrThrow(Registries.LEVEL_STEM);
		Registry<Biome> biomeRegistry = server.registryAccess().lookupOrThrow(Registries.BIOME);
		for (LevelStem levelStem : levelStemTypeRegistry.stream().toList()) {
			Holder<DimensionType> dimensionType = levelStem.type();
			if (dimensionType.is(BuiltinDimensionTypes.OVERWORLD)) {
				ChunkGenerator chunkGenerator = levelStem.generator();
				// Inject biomes to biome source
				if (chunkGenerator.getBiomeSource() instanceof MultiNoiseBiomeSource noiseSource) {
					List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<>(noiseSource.parameters().values());
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.point(0.0f),
							Climate.Parameter.span(-2f, 2f), 0), biomeRegistry.getOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("brokencraft", "unique")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.point(1.0f),
							Climate.Parameter.span(-2f, 2f), 0), biomeRegistry.getOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("brokencraft", "unique")))));
					chunkGenerator.biomeSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(parameters));
					chunkGenerator.featuresPerStep = Suppliers
							.memoize(() -> FeatureSorter.buildFeaturesPerStep(List.copyOf(chunkGenerator.biomeSource.possibleBiomes()), biome -> chunkGenerator.generationSettingsGetter.apply(biome).features(), true));
				}
				if (chunkGenerator instanceof NoiseBasedChunkGenerator noiseGenerator) {
					((BrokencraftModNoiseGeneratorSettings) (Object) noiseGenerator.settings.value()).setbrokencraftDimensionTypeReference(dimensionType);
				}
			}
			if (dimensionType.is(BuiltinDimensionTypes.NETHER)) {
				ChunkGenerator chunkGenerator = levelStem.generator();
				// Inject biomes to biome source
				if (chunkGenerator.getBiomeSource() instanceof MultiNoiseBiomeSource noiseSource) {
					List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<>(noiseSource.parameters().values());
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.point(0.0f),
							Climate.Parameter.span(-2f, 2f), 0), biomeRegistry.getOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("brokencraft", "unique")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.span(-2f, 2f), Climate.Parameter.point(1.0f),
							Climate.Parameter.span(-2f, 2f), 0), biomeRegistry.getOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("brokencraft", "unique")))));
					chunkGenerator.biomeSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(parameters));
					chunkGenerator.featuresPerStep = Suppliers
							.memoize(() -> FeatureSorter.buildFeaturesPerStep(List.copyOf(chunkGenerator.biomeSource.possibleBiomes()), biome -> chunkGenerator.generationSettingsGetter.apply(biome).features(), true));
				}
				if (chunkGenerator instanceof NoiseBasedChunkGenerator noiseGenerator) {
					((BrokencraftModNoiseGeneratorSettings) (Object) noiseGenerator.settings.value()).setbrokencraftDimensionTypeReference(dimensionType);
				}
			}
		}
	}

	public static SurfaceRules.RuleSource adaptSurfaceRule(SurfaceRules.RuleSource currentRuleSource, Holder<DimensionType> dimensionType) {
		if (dimensionType.is(BuiltinDimensionTypes.OVERWORLD))
			return injectOverworldSurfaceRules(currentRuleSource);
		if (dimensionType.is(BuiltinDimensionTypes.NETHER))
			return injectNetherSurfaceRules(currentRuleSource);
		return currentRuleSource;
	}

	private static SurfaceRules.RuleSource injectOverworldSurfaceRules(SurfaceRules.RuleSource currentRuleSource) {
		List<SurfaceRules.RuleSource> customSurfaceRules = new ArrayList<>();
		customSurfaceRules.add(preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("brokencraft", "unique")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.STONE.defaultBlockState(),
				Blocks.GRAVEL.defaultBlockState()));
		if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
			customSurfaceRules.addAll(sequenceRuleSource.sequence());
			return SurfaceRules.sequence(customSurfaceRules.toArray(SurfaceRules.RuleSource[]::new));
		} else {
			customSurfaceRules.add(currentRuleSource);
			return SurfaceRules.sequence(customSurfaceRules.toArray(SurfaceRules.RuleSource[]::new));
		}
	}

	private static SurfaceRules.RuleSource injectNetherSurfaceRules(SurfaceRules.RuleSource currentRuleSource) {
		List<SurfaceRules.RuleSource> customSurfaceRules = new ArrayList<>();
		customSurfaceRules
				.add(anySurfaceRule(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("brokencraft", "unique")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState()));
		if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
			customSurfaceRules.addAll(sequenceRuleSource.sequence());
			return SurfaceRules.sequence(customSurfaceRules.toArray(SurfaceRules.RuleSource[]::new));
		} else {
			customSurfaceRules.add(currentRuleSource);
			return SurfaceRules.sequence(customSurfaceRules.toArray(SurfaceRules.RuleSource[]::new));
		}
	}

	private static SurfaceRules.RuleSource preliminarySurfaceRule(ResourceKey<Biome> biomeKey, BlockState groundBlock, BlockState undergroundBlock, BlockState underwaterBlock) {
		return SurfaceRules.ifTrue(SurfaceRules.isBiome(biomeKey),
				SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
						SurfaceRules.sequence(
								SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
										SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.state(groundBlock)), SurfaceRules.state(underwaterBlock))),
								SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(undergroundBlock)))));
	}

	private static SurfaceRules.RuleSource anySurfaceRule(ResourceKey<Biome> biomeKey, BlockState groundBlock, BlockState undergroundBlock, BlockState underwaterBlock) {
		return SurfaceRules.ifTrue(SurfaceRules.isBiome(biomeKey),
				SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.aboveBottom(5), 0),
						SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.belowTop(5), 0)),
								SurfaceRules.sequence(
										SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
												SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.state(groundBlock)), SurfaceRules.state(underwaterBlock))),
										SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(undergroundBlock))))));
	}

	private static void addParameterPoint(List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters, Pair<Climate.ParameterPoint, Holder<Biome>> point) {
		if (!parameters.contains(point))
			parameters.add(point);
	}

	public interface BrokencraftModNoiseGeneratorSettings {
		void setbrokencraftDimensionTypeReference(Holder<DimensionType> dimensionType);
	}
}