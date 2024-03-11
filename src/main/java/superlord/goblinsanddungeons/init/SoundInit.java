package superlord.goblinsanddungeons.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import superlord.goblinsanddungeons.GoblinsAndDungeons;

@Mod.EventBusSubscriber(modid = GoblinsAndDungeons.MOD_ID, bus = Bus.MOD)
public class SoundInit {
	
	public static final SoundEvent OGRE_IDLE;
	public static final SoundEvent OGRE_HURT;
	public static final SoundEvent OGRE_DEATH;
	public static final SoundEvent OGRE_ROAR;
	
	public static final SoundEvent GARCH_IDLE;
	public static final SoundEvent GARCH_HURT;
	public static final SoundEvent GARCH_DEATH;
	
	public static final SoundEvent GOOM_IDLE;
	public static final SoundEvent GOOM_HURT;
	public static final SoundEvent GOOM_DEATH;
	public static final SoundEvent GOOM_WARNING;
	
	public static final SoundEvent HOBGOB_IDLE;
	public static final SoundEvent HOBGOB_HURT;
	public static final SoundEvent HOBGOB_DEATH;
	
	public static final SoundEvent GOB_IDLE;
	public static final SoundEvent GOB_HURT;
	public static final SoundEvent GOB_DEATH;
	
	public static final SoundEvent MIMIC_IDLE;
	public static final SoundEvent MIMIC_HURT;
	public static final SoundEvent MIMIC_DEATH;
	
	public static final SoundEvent GOBBER_IDLE;
	public static final SoundEvent GOBBER_HURT;
	public static final SoundEvent GOBBER_DEATH;
	public static final SoundEvent GOBBER_SNORING;
	
	public static final SoundEvent GOBLO_IDLE;
	public static final SoundEvent GOBLO_HURT;
	public static final SoundEvent GOBLO_DEATH;
	public static final SoundEvent GOBLO_SNORING;
	public static final SoundEvent GOBLO_EATING;
	
	public static final SoundEvent GOBLIN_KING_IDLE;
	public static final SoundEvent GOBLIN_KING_LAUGH;
	public static final SoundEvent GOBLIN_KING_HURT;
	public static final SoundEvent GOBLIN_KING_DEATH;
	
	public static final SoundEvent SPELL_CASTING;
	public static final SoundEvent SOUL_BULLET_LAUNCH;
	public static final SoundEvent SOUL_BULLET_COLLISION;

	public static final SoundEvent URN_PLACE;
	public static final SoundEvent URN_FALL;
	public static final SoundEvent URN_HIT;
	public static final SoundEvent URN_BREAK;
	public static final SoundEvent URN_STEP;
	
	@SubscribeEvent
	public static void registerSounds(final RegisterEvent evt) {
		evt.register(ForgeRegistries.Keys.SOUND_EVENTS, helper -> {
			helper.register(OGRE_IDLE.getLocation(), OGRE_IDLE);
			helper.register(OGRE_HURT.getLocation(), OGRE_HURT);
			helper.register(OGRE_DEATH.getLocation(), OGRE_DEATH);
			helper.register(OGRE_ROAR.getLocation(), OGRE_ROAR);
			helper.register(GARCH_IDLE.getLocation(), GARCH_IDLE);
			helper.register(GARCH_HURT.getLocation(), GARCH_HURT);
			helper.register(GARCH_DEATH.getLocation(), GARCH_DEATH);
			helper.register(GOOM_IDLE.getLocation(), GOOM_IDLE);
			helper.register(GOOM_HURT.getLocation(), GOOM_HURT);
			helper.register(GOOM_DEATH.getLocation(), GOOM_DEATH);
			helper.register(GOOM_WARNING.getLocation(), GOOM_WARNING);
			helper.register(HOBGOB_IDLE.getLocation(), HOBGOB_IDLE);
			helper.register(HOBGOB_HURT.getLocation(), HOBGOB_HURT);
			helper.register(HOBGOB_DEATH.getLocation(), HOBGOB_DEATH);
			helper.register(GOB_IDLE.getLocation(), GOB_IDLE);
			helper.register(GOB_HURT.getLocation(), GOB_HURT);
			helper.register(GOB_DEATH.getLocation(), GOB_DEATH);
			helper.register(MIMIC_IDLE.getLocation(), MIMIC_IDLE);
			helper.register(MIMIC_HURT.getLocation(), MIMIC_HURT);
			helper.register(MIMIC_DEATH.getLocation(), MIMIC_DEATH);
			helper.register(GOBBER_IDLE.getLocation(), GOBBER_IDLE);
			helper.register(GOBBER_HURT.getLocation(), GOBBER_HURT);
			helper.register(GOBBER_DEATH.getLocation(), GOBBER_DEATH);
			helper.register(GOBBER_SNORING.getLocation(), GOBBER_SNORING);
			helper.register(GOBLO_IDLE.getLocation(), GOBLO_IDLE);
			helper.register(GOBLO_HURT.getLocation(), GOBLO_HURT);
			helper.register(GOBLO_DEATH.getLocation(), GOBLO_DEATH);
			helper.register(GOBLO_SNORING.getLocation(), GOBLO_SNORING);
			helper.register(GOBLO_EATING.getLocation(), GOBLO_EATING);
			helper.register(GOBLIN_KING_IDLE.getLocation(), GOBLIN_KING_IDLE);
			helper.register(GOBLIN_KING_LAUGH.getLocation(), GOBLIN_KING_LAUGH);
			helper.register(GOBLIN_KING_HURT.getLocation(), GOBLIN_KING_HURT);
			helper.register(GOBLIN_KING_DEATH.getLocation(), GOBLIN_KING_DEATH);
			helper.register(SPELL_CASTING.getLocation(), SPELL_CASTING);
			helper.register(SOUL_BULLET_LAUNCH.getLocation(), SOUL_BULLET_LAUNCH);
			helper.register(SOUL_BULLET_COLLISION.getLocation(), SOUL_BULLET_COLLISION);
			helper.register(URN_PLACE.getLocation(), URN_PLACE);
			helper.register(URN_BREAK.getLocation(), URN_BREAK);
			helper.register(URN_FALL.getLocation(), URN_FALL);
			helper.register(URN_HIT.getLocation(), URN_HIT);
			helper.register(URN_STEP.getLocation(), URN_STEP);	
		});
	}
	
	private static SoundEvent createEvent(final String soundName) {
		final ResourceLocation soundId = new ResourceLocation(GoblinsAndDungeons.MOD_ID, soundName);
		return new SoundEvent(soundId);
	}
	
	static {
		OGRE_IDLE = createEvent("ogre_idle");
		OGRE_HURT = createEvent("ogre_hurt");
		OGRE_DEATH = createEvent("ogre_death");
		OGRE_ROAR = createEvent("ogre_roar");
		GARCH_IDLE = createEvent("garch_idle");
		GARCH_HURT = createEvent("garch_hurt");
		GARCH_DEATH = createEvent("garch_death");
		GOOM_IDLE = createEvent("goom_idle");
		GOOM_HURT = createEvent("goom_hurt");
		GOOM_DEATH = createEvent("goom_death");
		GOOM_WARNING = createEvent("goom_warning");
		HOBGOB_IDLE = createEvent("hobgob_idle");
		HOBGOB_HURT = createEvent("hobgob_hurt");
		HOBGOB_DEATH = createEvent("hobgob_death");
		GOB_IDLE = createEvent("gob_idle");
		GOB_HURT = createEvent("gob_hurt");
		GOB_DEATH = createEvent("gob_death");
		MIMIC_IDLE = createEvent("mimic_idle");
		MIMIC_HURT = createEvent("mimic_hurt");
		MIMIC_DEATH = createEvent("mimic_death");
		GOBBER_IDLE = createEvent("gobber_idle");
		GOBBER_HURT = createEvent("gobber_hurt");
		GOBBER_DEATH = createEvent("gobber_death");
		GOBBER_SNORING = createEvent("gobber_snoring");
		GOBLO_IDLE = createEvent("goblo_idle");
		GOBLO_HURT = createEvent("goblo_hurt");
		GOBLO_DEATH = createEvent("goblo_death");
		GOBLO_SNORING = createEvent("goblo_snoring");
		GOBLO_EATING = createEvent("goblo_eating");
		GOBLIN_KING_IDLE = createEvent("goblin_king_idle");
		GOBLIN_KING_HURT = createEvent("goblin_king_hurt");
		GOBLIN_KING_DEATH = createEvent("goblin_king_death");
		GOBLIN_KING_LAUGH = createEvent("goblin_king_laugh");
		SPELL_CASTING = createEvent("spell_casting");
		SOUL_BULLET_LAUNCH = createEvent("soul_bullet_launch");
		SOUL_BULLET_COLLISION = createEvent("soul_bullet_collision");
		URN_PLACE = createEvent("urn_place");
		URN_BREAK = createEvent("urn_break");
		URN_FALL = createEvent("urn_fall");
		URN_HIT = createEvent("urn_hit");
		URN_STEP = createEvent("urn_step");
	}

}
