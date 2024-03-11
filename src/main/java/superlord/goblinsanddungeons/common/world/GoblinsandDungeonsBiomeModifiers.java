package superlord.goblinsanddungeons.common.world;

import com.mojang.serialization.Codec;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo.BiomeInfo.Builder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.goblinsanddungeons.GoblinsAndDungeons;
import superlord.goblinsanddungeons.config.GoblinsDungeonsConfig;
import superlord.goblinsanddungeons.init.EntityInit;

public class GoblinsandDungeonsBiomeModifiers implements BiomeModifier {
	
    private static final RegistryObject<Codec<? extends BiomeModifier>> SERIALIZER = RegistryObject.create(new ResourceLocation(GoblinsAndDungeons.MOD_ID, "goblinsanddungeons_modifiers"), ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, GoblinsAndDungeons.MOD_ID);

    public GoblinsandDungeonsBiomeModifiers() {
    	
    }

	@Override
	public void modify(Holder<Biome> biome, Phase phase, Builder builder) {
		if (phase == Phase.ADD) {
			builder.getGenerationSettings().addFeature(Decoration.UNDERGROUND_ORES, GoblinsAndDungeonsFeatures.ORE_SCORIA_LOWER);
			builder.getGenerationSettings().addFeature(Decoration.UNDERGROUND_ORES, GoblinsAndDungeonsFeatures.ORE_SCORIA_UPPER);
			
			if (biome.is(Tags.Biomes.IS_PLAINS) || biome.is(Tags.Biomes.IS_SWAMP) || biome.is(BiomeTags.IS_TAIGA) || biome.is(BiomeTags.IS_FOREST)) {
				builder.getMobSpawnSettings().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(EntityInit.OGRE.get(), GoblinsDungeonsConfig.ogreSpawnWeight, 1, 1));
			}
		}
	}

	@Override
	public Codec<? extends BiomeModifier> codec() {
		return SERIALIZER.get();
	}
	
    public static Codec<GoblinsandDungeonsBiomeModifiers> makeCodec() {
        return Codec.unit(GoblinsandDungeonsBiomeModifiers::new);
    }
}
