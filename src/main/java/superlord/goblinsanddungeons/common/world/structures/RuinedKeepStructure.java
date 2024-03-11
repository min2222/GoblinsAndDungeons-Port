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

public class RuinedKeepStructure extends Structure {
	
	public static final Codec<RuinedKeepStructure> CODEC = simpleCodec(RuinedKeepStructure::new);
	
	public RuinedKeepStructure(Structure.StructureSettings settings) {
		super(settings);
	}

	private void generatePieces(StructurePiecesBuilder p_197233_, GenerationContext context) {
        BlockPos blockpos1 = context.chunkPos().getMiddleBlockPosition(0);
        int topLandY = context.chunkGenerator().getBaseHeight(blockpos1.getX(), blockpos1.getZ(), Heightmap.Types.OCEAN_FLOOR_WG, context.heightAccessor(), context.randomState());
		BlockPos blockpos = new BlockPos(context.chunkPos().getMinBlockX(), topLandY, context.chunkPos().getMinBlockZ());
		Rotation rotation = Rotation.getRandom(context.random());
		RuinedKeepStructurePiece.addStructure(context.structureTemplateManager(), blockpos, rotation, p_197233_, context.random());
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
		return StructureInit.RUINED_KEEP.get();
	}
}