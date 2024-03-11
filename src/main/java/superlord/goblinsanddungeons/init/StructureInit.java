package superlord.goblinsanddungeons.init;

import java.util.Locale;
import java.util.function.Supplier;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.goblinsanddungeons.GoblinsAndDungeons;
import superlord.goblinsanddungeons.common.world.structures.LargeGoblinCampStructure;
import superlord.goblinsanddungeons.common.world.structures.LargeGoblinCampStructurePiece;
import superlord.goblinsanddungeons.common.world.structures.MediumGoblinCampStructure;
import superlord.goblinsanddungeons.common.world.structures.MediumGoblinCampStructurePiece;
import superlord.goblinsanddungeons.common.world.structures.RuinedKeepStructure;
import superlord.goblinsanddungeons.common.world.structures.RuinedKeepStructurePiece;
import superlord.goblinsanddungeons.common.world.structures.SmallGoblinCampStructure;
import superlord.goblinsanddungeons.common.world.structures.SmallGoblinCampStructurePiece;

@Mod.EventBusSubscriber(modid = GoblinsAndDungeons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class StructureInit {
	
    public static final DeferredRegister<StructureType<?>> REGISTER = DeferredRegister.create(Registry.STRUCTURE_TYPE_REGISTRY, GoblinsAndDungeons.MOD_ID);
    
    public static final RegistryObject<StructureType<SmallGoblinCampStructure>> SMALL_GOBLIN_CAMP = registerStructure("small_goblin_camp", () -> () -> SmallGoblinCampStructure.CODEC);
    public static final RegistryObject<StructureType<MediumGoblinCampStructure>> MEDIUM_GOBLIN_CAMP = registerStructure("medium_goblin_camp", () -> () -> MediumGoblinCampStructure.CODEC);
    public static final RegistryObject<StructureType<LargeGoblinCampStructure>> LARGE_GOBLIN_CAMP = registerStructure("large_goblin_camp", () -> () -> LargeGoblinCampStructure.CODEC);
    public static final RegistryObject<StructureType<RuinedKeepStructure>> RUINED_KEEP = registerStructure("ruined_keep", () -> () -> RuinedKeepStructure.CODEC);
    
    private static <T extends Structure> RegistryObject<StructureType<T>> registerStructure(String name, Supplier<StructureType<T>> structure) {
        return REGISTER.register(name, structure);
    }
	public static StructurePieceType SMALL_GOBLIN_CAMP_PIECE;
	public static StructurePieceType MEDIUM_GOBLIN_CAMP_PIECE;
	public static StructurePieceType LARGE_GOBLIN_CAMP_PIECE;
	public static StructurePieceType RUINED_KEEP_PIECE;
	
	static StructurePieceType setPieceId(StructurePieceType.StructureTemplateType type, String name) {
		return Registry.register(Registry.STRUCTURE_PIECE, name.toLowerCase(Locale.ROOT), type);
	}
	
	public static void init() {
		SMALL_GOBLIN_CAMP_PIECE = setPieceId(SmallGoblinCampStructurePiece.Piece::new, "SGCSP");
		MEDIUM_GOBLIN_CAMP_PIECE = setPieceId(MediumGoblinCampStructurePiece.Piece::new, "MGCSP");
		LARGE_GOBLIN_CAMP_PIECE = setPieceId(LargeGoblinCampStructurePiece.Piece::new, "LGCSP");
		RUINED_KEEP_PIECE = setPieceId(RuinedKeepStructurePiece.Piece::new, "RKSP");
	}
	
	@SuppressWarnings("unused")
	private static String prefix(String path) {
		return "goblinsanddungeons:" + path;
	}
}
