package superlord.goblinsanddungeons.init;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import superlord.goblinsanddungeons.GoblinsAndDungeons;

@Mod.EventBusSubscriber(modid = GoblinsAndDungeons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleRegistry {
	
	public static final Map<ParticleType<?>, ResourceLocation> PARTICLE_TYPES = new HashMap<>();
	
	public static <T extends ParticleType<?>> T registerParticle(String name, T particle) {
		PARTICLE_TYPES.put(particle, new ResourceLocation(GoblinsAndDungeons.MOD_ID, name));
		return particle;
	}
	
	@SubscribeEvent
	public static void registerParticles(RegisterEvent event) {
		event.register(ForgeRegistries.Keys.PARTICLE_TYPES, helper -> {
			for (ParticleType<?> particle : PARTICLE_TYPES.keySet()) {
				helper.register(PARTICLE_TYPES.get(particle), particle);
			}
		});
	}
}
