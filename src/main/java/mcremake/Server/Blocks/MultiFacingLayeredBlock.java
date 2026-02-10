package mcremake.Server.Blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;


public class MultiFacingLayeredBlock extends Block implements SimpleWaterloggedBlock {
    public static final MapCodec<MultiFacingLayeredBlock> CODEC =
            simpleCodec(MultiFacingLayeredBlock::new);
    public MapCodec<MultiFacingLayeredBlock> codec() {
        return CODEC;
    }

    public static final EnumProperty<Direction> FACING;
    public static final IntegerProperty LAYERS;
    public static final BooleanProperty WATERLOGGED;
    public static final VoxelShape[] LAYERS_UP;
    public static final VoxelShape[] LAYERS_DOWN;
    public static final VoxelShape[] LAYERS_NORTH;
    public static final VoxelShape[] LAYERS_SOUTH;
    public static final VoxelShape[] LAYERS_WEST;
    public static final VoxelShape[] LAYERS_EAST;
    public MultiFacingLayeredBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.UP)
                .setValue(LAYERS, 1)
                .setValue(WATERLOGGED, false)
        );
    }



    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction direction = ctx.getClickedFace();
        BlockPos pos = ctx.getClickedPos();
        BlockState neighbour = ctx.getLevel().getBlockState(pos.relative(direction.getOpposite()));
        BlockState state = this.defaultBlockState().setValue(FACING, neighbour.is(this) && neighbour.getValue(FACING) == direction ? direction.getOpposite() : direction);
        boolean water = ctx.getLevel()
                .getFluidState(pos)
                .getType() == Fluids.WATER;
        return state.setValue(WATERLOGGED, water && state.getValue(LAYERS) < 15);
    }
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) && state.getValue(LAYERS) < 15
                ? Fluids.WATER.getSource(false)
                : Fluids.EMPTY.defaultFluidState();
    }
    public BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction dir, BlockPos neighborPos, BlockState neighborState, RandomSource random) {

        if (state.getValue(LAYERS) == 15 && state.getValue(WATERLOGGED)) {
            return state.setValue(WATERLOGGED, false);
        }
        if (state.getValue(WATERLOGGED)) {
            ticks.scheduleTick(
                    pos,
                    Fluids.WATER,
                    Fluids.WATER.getTickDelay(level)
            );
        }
        return super.updateShape(
                state, level, ticks, pos, dir, neighborPos, neighborState, random
        );
    }
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }
    public float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(LAYERS) == 16 ? 0.2F : 1.0F;
    }
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        int layers = state.getValue(LAYERS);
        return switch (state.getValue(FACING)) {
            case DOWN  -> LAYERS_DOWN[layers];
            case UP    -> LAYERS_UP[layers];
            case NORTH -> LAYERS_NORTH[layers];
            case SOUTH -> LAYERS_SOUTH[layers];
            case EAST  -> LAYERS_EAST[layers];
            case WEST  -> LAYERS_WEST[layers];
        };
    }



    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, LAYERS, WATERLOGGED);
    }
    static {
        FACING = BlockStateProperties.FACING;
        LAYERS = IntegerProperty.create("layers", 1, 16);
        WATERLOGGED = BlockStateProperties.WATERLOGGED;

        LAYERS_UP    = Block.boxes(17, layers -> Block.box(0, 0, 0, 16, layers, 16));
        LAYERS_DOWN  = Block.boxes(17, layers -> Block.box(0, 16 - layers, 0, 16, 16, 16));
        LAYERS_NORTH = Block.boxes(17, layers -> Block.box(0, 0, 16 - layers, 16, 16, 16));
        LAYERS_SOUTH = Block.boxes(17, layers -> Block.box(0, 0, 0, 16, 16, layers));
        LAYERS_WEST  = Block.boxes(17, layers -> Block.box(16 - layers, 0, 0, 16, 16, 16));
        LAYERS_EAST  = Block.boxes(17, layers -> Block.box(0, 0, 0, layers, 16, 16));
    }
}