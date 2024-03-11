package superlord.goblinsanddungeons.common.world.structures;

import java.util.Optional;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import superlord.goblinsanddungeons.init.StructureInit;

public class MediumGoblinCampStructure extends Structure {
	
	public static final Codec<MediumGoblinCampStructure> CODEC = simpleCodec(MediumGoblinCampStructure::new);
	
	public MediumGoblinCampStructure(Structure.StructureSettings settings) {
		super(settings);
	}

	private void generatePieces(StructurePiecesBuilder p_197233_, GenerationContext p_197234_) {
		BlockPos blockpos = new BlockPos(p_197234_.chunkPos().getMinBlockX(), 90, p_197234_.chunkPos().getMinBlockZ());
		Rotation rotation = Rotation.getRandom(p_197234_.random());
		MediumGoblinCampStructurePiece.addStructure(p_197234_.structureTemplateManager(), blockpos, rotation, p_197233_, p_197234_.random());
	}

	private boolean checkLocation(GenerationContext p_197134_) {
		int i = p_197134_.chunkPos().x >> 4;
		int j = p_197134_.chunkPos().z >> 4;
		WorldgenRandom worldgenrandom = new WorldgenRandom(new LegacyRandomSource(0L));
		worldgenrandom.setSeed((long) (i ^ j << 4) ^ p_197134_.seed());
		worldgenrandom.nextInt();

		return true;
	}
	
    @Override
    public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
    	if(this.checkLocation(context)) {
    		return onTopOfChunkCenter(context, Heightmap.Types.OCEAN_FLOOR_WG, (builder) -> {
    			this.generatePieces(builder, context);
    		});
    	}
    	return Optional.empty();
    }

	@Override
	public GenerationStep.Decoration step() {
		return GenerationStep.Decoration.SURFACE_STRUCTURES;
	}

	@Override
	public StructureType<?> type() {
		return StructureInit.MEDIUM_GOBLIN_CAMP.get();
	}
}