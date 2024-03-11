package superlord.goblinsanddungeons.common.compat;

import com.google.gson.JsonObject;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;
import superlord.goblinsanddungeons.GoblinsAndDungeons;

public class QuarkFlagRecipeCondition implements ICondition {
	
	private final ResourceLocation location;
	private final String flag;
	
	public QuarkFlagRecipeCondition(ResourceLocation location, String flag) {
		this.location = location;
		this.flag = flag;
	}
	
	@Override
	public ResourceLocation getID() {
		return this.location;
	}
	
	@Override
	public boolean test(IContext ctx) {
		if (ModList.get().isLoaded("quark")) {
			JsonObject dummyObject = new JsonObject();
			dummyObject.addProperty("type", "quark:flag");
			dummyObject.addProperty("flag", this.flag);
			return CraftingHelper.getCondition(dummyObject).test(ctx);
		}
		return false;
	}

	public static class Serializer implements IConditionSerializer<QuarkFlagRecipeCondition> {
		private final ResourceLocation location;
		
		public Serializer() {
			this.location = new ResourceLocation(GoblinsAndDungeons.MOD_ID, "quark_flag");
		}
		
		@Override
		public void write(JsonObject json, QuarkFlagRecipeCondition value) {
			json.addProperty("flag", value.flag);
		}
		
		@Override
		public QuarkFlagRecipeCondition read(JsonObject json) {
			return new QuarkFlagRecipeCondition(this.location, json.getAsJsonPrimitive("flag").getAsString());
		}
		
		@Override
		public ResourceLocation getID() {
			return this.location;
		}
	}
	
}
