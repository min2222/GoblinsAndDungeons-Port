package superlord.goblinsanddungeons.client.renderer;

import org.apache.commons.lang3.mutable.MutableInt;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.goblinsanddungeons.GoblinsAndDungeons;
import superlord.goblinsanddungeons.client.mana.ClientManaData;
import superlord.goblinsanddungeons.config.GoblinsDungeonsConfig;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = GoblinsAndDungeons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ManaGUIRenderer {

	public static final ResourceLocation GUI_ICONS = new ResourceLocation(GoblinsAndDungeons.MOD_ID, "textures/gui/icons.png");

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerOverlays(RegisterGuiOverlaysEvent event) {
		event.registerAbove(VanillaGuiOverlay.FOOD_LEVEL.id(), "Mana Level", (gui, mStack, partialTicks, screenWidth, screenHeight) -> {
			boolean isMounted = gui.minecraft.player.getVehicle() instanceof LivingEntity;
			if (!isMounted && !gui.minecraft.options.hideGui && gui.shouldDrawSurvivalElements()) {
				gui.setupOverlayRenderState(true, false, GUI_ICONS);
				int left = screenWidth / 2 + 91;
				int top = screenHeight - gui.rightHeight;
				renderMana(gui, mStack, new MutableInt(), left, top, true);
				gui.rightHeight += 10;
			}
		});
	}

	@OnlyIn(Dist.CLIENT)
	public static void renderMana(Gui gui, PoseStack matrixStack, MutableInt moveUp, int j1, int k1, boolean forgeOverlay) {
		if (GoblinsDungeonsConfig.magicalWorld) {
			gui.minecraft.getProfiler().push("mana");
			if (!forgeOverlay) {
				RenderSystem.setShader(GameRenderer::getPositionTexShader);
				RenderSystem.setShaderTexture(0, GUI_ICONS);
			}
			for (int k6 = 0; k6 < 10; ++k6) {
				int i7 = k1;
				int k7 = 16;
				int i8 = 0;
				int k8 = j1 - k6 * 8 - 9;
				gui.blit(matrixStack, k8, i7 - moveUp.getValue(), 16 + i8 * 9, 54, 9, 9);
				if (k6 * 2 + 1 < ClientManaData.getPlayerMana()) {
					gui.blit(matrixStack, k8, i7 - moveUp.getValue(), k7 + 36, 54, 9, 9);
				}

				if (k6 * 2 + 1 == ClientManaData.getPlayerMana()) {
					gui.blit(matrixStack, k8, i7 - moveUp.getValue(), k7 + 45, 54, 9, 9);
				}
			}
			moveUp.add(10);
			gui.minecraft.getProfiler().pop();
			if (!forgeOverlay) {
				RenderSystem.setShader(GameRenderer::getPositionTexShader);
				RenderSystem.setShaderTexture(0, GuiComponent.GUI_ICONS_LOCATION);
			}
		}
	}

}