package net.pastek.chemicalscience.common.block.decoration;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CSHalideLamp extends FaceAttachedHorizontalDirectionalBlock {
    public CSHalideLamp(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(FACE, AttachFace.WALL));
    }

    public static final MapCodec<CSHalideLamp> CODEC = simpleCodec(CSHalideLamp::new);
    @Override
    protected MapCodec<? extends FaceAttachedHorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    public static final VoxelShape NORTH_SHAPE = Block.box(0, 0, 14, 16, 16, 16);
    public static final VoxelShape EAST_SHAPE = Block.box(0, 0, 0, 2, 16, 16);
    public static final VoxelShape SOUTH_SHAPE = Block.box(0, 0, 0, 16, 16, 2);
    public static final VoxelShape WEST_SHAPE = Block.box(14, 0, 0, 16, 16, 16);
    public static final VoxelShape UP_SHAPE_X = Block.box(0, 14, 0, 16, 16, 16);
    public static final VoxelShape UP_SHAPE_Z = Block.box(0, 14, 0, 16, 16, 16);
    public static final VoxelShape DOWN_SHAPE_X = Block.box(0, 0, 0, 16, 2, 16);
    public static final VoxelShape DOWN_SHAPE_Z = Block.box(0, 0, 0, 16, 2, 16);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACE)) {
            case FLOOR -> state.getValue(FACING).getAxis() == Direction.Axis.X ? DOWN_SHAPE_X : DOWN_SHAPE_Z;
            case WALL -> switch (state.getValue(FACING)) {
                case EAST -> EAST_SHAPE;
                case SOUTH -> SOUTH_SHAPE;
                case WEST -> WEST_SHAPE;
                default -> NORTH_SHAPE;
            };
            case CEILING -> state.getValue(FACING).getAxis() == Direction.Axis.X ? UP_SHAPE_X : UP_SHAPE_Z;
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, FACE);
    }
}