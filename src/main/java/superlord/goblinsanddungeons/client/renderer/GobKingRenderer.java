package superlord.goblinsanddungeons.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;
import superlord.goblinsanddungeons.GoblinsAndDungeons;
import superlord.goblinsanddungeons.client.model.GoblinKingModel;
import superlord.goblinsanddungeons.entity.GobKingEntity;

public class GobKingRenderer extends MobRenderer<GobKingEntity, GoblinKingModel<GobKingEntity>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(GoblinsAndDungeons.MOD_ID, "textures/entities/goblin_king.png");
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GobKingRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new GoblinKingModel<>(), 0.375F);
		this.addLayer(new HeldItemLayer(this));
	}

	@Override
	public ResourceLocation getEntityTexture(GobKingEntity entity) {
		return TEXTURE;
	}

}
