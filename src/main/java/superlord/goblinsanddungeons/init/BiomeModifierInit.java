package superlord.goblinsanddungeons.init;

import com.mojang.serialization.Codec;

import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.goblinsanddungeons.GoblinsAndDungeons;
import superlord.goblinsanddungeons.common.world.GoblinsandDungeonsBiomeModifiers;

public class BiomeModifierInit {
	public static final DeferredRegister<Codec<? extends BiomeModifier>> REGISTER = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, GoblinsAndDungeons.MOD_ID);
	public static final RegistryObject<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = REGISTER.register("goblinsanddungeons_modifiers", GoblinsandDungeonsBiomeModifiers::makeCodec);
}
