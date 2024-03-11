package superlord.goblinsanddungeons.client;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import superlord.goblinsanddungeons.GoblinsAndDungeons;
import superlord.goblinsanddungeons.client.model.BeholderModel;
import superlord.goblinsanddungeons.client.model.GarchModel;
import superlord.goblinsanddungeons.client.model.GobModel;
import superlord.goblinsanddungeons.client.model.GobberModel;
import superlord.goblinsanddungeons.client.model.GoblinKingModel;
import superlord.goblinsanddungeons.client.model.GobloModel;
import superlord.goblinsanddungeons.client.model.GoomModel;
import superlord.goblinsanddungeons.client.model.HiddenMimicModel;
import superlord.goblinsanddungeons.client.model.HobgobModel;
import superlord.goblinsanddungeons.client.model.MimicModel;
import superlord.goblinsanddungeons.client.model.OgreModel;
import superlord.goblinsanddungeons.client.model.SittingOgreModel;
import superlord.goblinsanddungeons.client.model.SleepingGobloModel;
import superlord.goblinsanddungeons.client.model.armor.GoblinCrownModel;
import superlord.goblinsanddungeons.client.renderer.BeholderRenderer;
import superlord.goblinsanddungeons.client.renderer.BlindnessOrbRenderer;
import superlord.goblinsanddungeons.client.renderer.ExplosiveOrbRenderer;
import superlord.goblinsanddungeons.client.renderer.FallingBlockRenderer;
import superlord.goblinsanddungeons.client.renderer.GarchRenderer;
import superlord.goblinsanddungeons.client.renderer.GobKingRenderer;
import superlord.goblinsanddungeons.client.renderer.GobRenderer;
import superlord.goblinsanddungeons.client.renderer.GobberRenderer;
import superlord.goblinsanddungeons.client.renderer.GoblinSoulBulletRenderer;
import superlord.goblinsanddungeons.client.renderer.GobloRenderer;
import superlord.goblinsanddungeons.client.renderer.GoomRenderer;
import superlord.goblinsanddungeons.client.renderer.HobGobRenderer;
import superlord.goblinsanddungeons.client.renderer.LevitationOrbRenderer;
import superlord.goblinsanddungeons.client.renderer.MimicRenderer;
import superlord.goblinsanddungeons.client.renderer.OgreRenderer;
import superlord.goblinsanddungeons.client.renderer.SoulAshCampfireTileEntityRenderer;
import superlord.goblinsanddungeons.client.renderer.SoulBulletRenderer;
import superlord.goblinsanddungeons.client.renderer.TeleportationOrbRenderer;
import superlord.goblinsanddungeons.client.renderer.WeaknessOrbRenderer;
import superlord.goblinsanddungeons.common.item.GoblinsAndDungeonsSpawnEggItem;
import superlord.goblinsanddungeons.init.BlockInit;
import superlord.goblinsanddungeons.init.EntityInit;
import superlord.goblinsanddungeons.init.TileEntityInit;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = GoblinsAndDungeons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

	public static ModelLayerLocation GOB = new ModelLayerLocation(new ResourceLocation(GoblinsAndDungeons.MOD_ID, "gob"), "gob");
	public static ModelLayerLocation GOBBER = new ModelLayerLocation(new ResourceLocation(GoblinsAndDungeons.MOD_ID, "gobber"), "gobber");
	public static ModelLayerLocation HOBGOB = new ModelLayerLocation(new ResourceLocation(GoblinsAndDungeons.MOD_ID, "hobgob"), "hobgob");
	public static ModelLayerLocation GOBLO = new ModelLayerLocation(new ResourceLocation(GoblinsAndDungeons.MOD_ID, "goblo"), "goblo");
	public static ModelLayerLocation SLEEPING_GOBLO = new ModelLayerLocation(new ResourceLocation(GoblinsAndDungeons.MOD_ID, "sleeping_goblo"), "sleeping_goblo");
	public static ModelLayerLocation GARCH = new ModelLayerLocation(new ResourceLocation(GoblinsAndDungeons.MOD_ID, "garch"), "garch");
	public static ModelLayerLocation GOOM = new ModelLayerLocation(new ResourceLocation(GoblinsAndDungeons.MOD_ID, "goom"), "goom");
	public static ModelLayerLocation OGRE = new ModelLayerLocation(new ResourceLocation(GoblinsAndDungeons.MOD_ID, "ogre"), "ogre");
	public static ModelLayerLocation SITTING_OGRE = new ModelLayerLocation(new ResourceLocation(GoblinsAndDungeons.MOD_ID, "sitting_ogre"), "sitting_ogre");
	public static ModelLayerLocation MIMIC = new ModelLayerLocation(new ResourceLocation(GoblinsAndDungeons.MOD_ID, "mimic"), "mimic");
	public static ModelLayerLocation HIDDEN_MIMIC = new ModelLayerLocation(new ResourceLocation(GoblinsAndDungeons.MOD_ID, "hidden_mimic"), "hidden_mimic");
	public static ModelLayerLocation GOB_KING = new ModelLayerLocation(new ResourceLocation(GoblinsAndDungeons.MOD_ID, "gob_king"), "gob_king");
	public static ModelLayerLocation GOBLIN_CROWN = new ModelLayerLocation(new ResourceLocation(GoblinsAndDungeons.MOD_ID, "goblin_crown"), "goblin_crown");
	public static ModelLayerLocation BEHOLDER = new ModelLayerLocation(new ResourceLocation(GoblinsAndDungeons.MOD_ID, "beholder"), "beholder");
	
	@SubscribeEvent
	public static void fmlClientSetup(FMLClientSetupEvent event) {
		RenderType cutoutRenderType = RenderType.cutout();
		ItemBlockRenderTypes.setRenderLayer(BlockInit.SOUL_ASH_CAMPFIRE.get(), cutoutRenderType);
		ItemBlockRenderTypes.setRenderLayer(BlockInit.SOUL_ASH_SOUL_CAMPFIRE.get(), cutoutRenderType);
	}

	@SubscribeEvent
	public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityInit.GOB.get(), GobRenderer::new);
		event.registerEntityRenderer(EntityInit.HOBGOB.get(), HobGobRenderer::new);
		event.registerEntityRenderer(EntityInit.GOBLO.get(), GobloRenderer::new);
		event.registerEntityRenderer(EntityInit.GARCH.get(), GarchRenderer::new);
		event.registerEntityRenderer(EntityInit.GOOM.get(), GoomRenderer::new);
		event.registerEntityRenderer(EntityInit.GOBBER.get(), GobberRenderer::new);
		event.registerEntityRenderer(EntityInit.OGRE.get(), OgreRenderer::new);
		event.registerEntityRenderer(EntityInit.GOBLIN_SOUL_BULLET.get(), GoblinSoulBulletRenderer::new);
		event.registerEntityRenderer(EntityInit.SOUL_BULLET.get(), SoulBulletRenderer::new);
		event.registerEntityRenderer(EntityInit.TELEPORTATION_ORB.get(), TeleportationOrbRenderer::new);
		event.registerEntityRenderer(EntityInit.LEVITATION_ORB.get(), LevitationOrbRenderer::new);
		event.registerEntityRenderer(EntityInit.BLINDNESS_ORB.get(), BlindnessOrbRenderer::new);
		event.registerEntityRenderer(EntityInit.EXPLOSIVE_ORB.get(), ExplosiveOrbRenderer::new);
		event.registerEntityRenderer(EntityInit.WEAKNESS_ORB.get(), WeaknessOrbRenderer::new);
		event.registerEntityRenderer(EntityInit.GOB_KING.get(), GobKingRenderer::new);
		event.registerEntityRenderer(EntityInit.MIMIC.get(), MimicRenderer::new);
		event.registerEntityRenderer(EntityInit.BEHOLDER.get(), BeholderRenderer::new);
		event.registerEntityRenderer(EntityInit.FALLING_BLOCK.get(), FallingBlockRenderer::new);
		BlockEntityRenderers.register(TileEntityInit.SOUL_ASH_CAMPFIRE.get(), SoulAshCampfireTileEntityRenderer::new);
	}
	
	@SubscribeEvent
	public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(GOB, GobModel::createBodyLayer);
		event.registerLayerDefinition(GOBBER, GobberModel::createBodyLayer);
		event.registerLayerDefinition(HOBGOB, HobgobModel::createBodyLayer);
		event.registerLayerDefinition(GOBLO, GobloModel::createBodyLayer);
		event.registerLayerDefinition(SLEEPING_GOBLO, SleepingGobloModel::createBodyLayer);
		event.registerLayerDefinition(GARCH, GarchModel::createBodyLayer);
		event.registerLayerDefinition(GOOM, GoomModel::createBodyLayer);
		event.registerLayerDefinition(OGRE, OgreModel::createBodyLayer);
		event.registerLayerDefinition(SITTING_OGRE, SittingOgreModel::createBodyLayer);
		event.registerLayerDefinition(MIMIC, MimicModel::createBodyLayer);
		event.registerLayerDefinition(HIDDEN_MIMIC, HiddenMimicModel::createBodyLayer);
		event.registerLayerDefinition(GOB_KING, GoblinKingModel::createBodyLayer);
		event.registerLayerDefinition(BEHOLDER, BeholderModel::createBodyLayer);
		event.registerLayerDefinition(GOBLIN_CROWN,  () -> GoblinCrownModel.createArmorLayer(new CubeDeformation(0.5F)));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void itemColors(RegisterColorHandlersEvent.Item event) {
		ItemColors handler = event.getItemColors();
		ItemColor eggColor = (stack, tintIndex) -> ((GoblinsAndDungeonsSpawnEggItem) stack.getItem()).getColor(tintIndex);
		for (GoblinsAndDungeonsSpawnEggItem e : GoblinsAndDungeonsSpawnEggItem.UNADDED_EGGS) handler.register(eggColor, e);
	}
}
