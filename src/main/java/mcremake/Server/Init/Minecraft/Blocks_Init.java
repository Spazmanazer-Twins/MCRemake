package mcremake.Server.Init.Minecraft;

import mcremake.Server.Blocks.FacingLayeredBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

public class Blocks_Init {
    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {

        // Create a registry key for the block
        ResourceKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.setId(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            ResourceKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ID_Init.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ID_Init.MOD_ID, name));
    }
    public static void initialize() {}

    public static final Block OAK_WALL = register("oak_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block SPRUCE_WALL = register("spruce_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block BIRCH_WALL = register("birch_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block JUNGLE_WALL = register("jungle_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block ACACIA_WALL = register("acacia_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block CHERRY_WALL = register("cherry_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block DARK_OAK_WALL = register("dark_oak_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block PALE_OAK_WALL = register("pale_oak_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block MANGROVE_WALL = register("mangrove_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block BAMBOO_WALL = register("bamboo_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block CRIMSON_WALL = register("crimson_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_STEM).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.NETHER_WOOD).forceSolidOn(), true);
    public static final Block WARPED_WALL = register("warped_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_STEM).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.NETHER_WOOD).forceSolidOn(), true);

    public static final Block LAYERED_OAK_PLANKS = register("layered_oak_planks", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_SPRUCE_PLANKS = register("layered_spruce_planks", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_BIRCH_PLANKS = register("layered_birch_planks", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_JUNGLE_PLANKS = register("layered_jungle_planks", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_ACACIA_PLANKS = register("layered_acacia_planks", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_CHERRY_PLANKS = register("layered_cherry_planks", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_DARK_OAK_PLANKS = register("layered_dark_oak_planks", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_PALE_OAK_PLANKS = register("layered_pale_oak_planks", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_MANGROVE_PLANKS = register("layered_mangrove_planks", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_BAMBOO_PLANKS = register("layered_bamboo_planks", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_CRIMSON_PLANKS = register("layered_crimson_planks", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_STEM).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).forceSolidOn(), true);
    public static final Block LAYERED_WARPED_PLANKS = register("layered_warped_planks", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_STEM).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).forceSolidOn(), true);
	
	public static final Block OAK_WOOD_WALL = register("oak_wood_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block SPRUCE_WOOD_WALL = register("spruce_wood_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block BIRCH_WOOD_WALL = register("birch_wood_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block JUNGLE_WOOD_WALL = register("jungle_wood_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block ACACIA_WOOD_WALL = register("acacia_wood_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block CHERRY_WOOD_WALL = register("cherry_wood_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block DARK_OAK_WOOD_WALL = register("dark_oak_wood_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block PALE_OAK_WOOD_WALL = register("pale_oak_wood_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block MANGROVE_WOOD_WALL = register("mangrove_wood_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block CRIMSON_HYPHAE_WALL = register("crimson_hyphae_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_STEM).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.NETHER_WOOD).forceSolidOn(), true);
    public static final Block WARPED_HYPHAE_WALL = register("warped_hyphae_wall", WallBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_STEM).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.NETHER_WOOD).forceSolidOn(), true);
	
	public static final Block LAYERED_OAK_WOOD = register("layered_oak_wood", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_SPRUCE_WOOD = register("layered_spruce_wood", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_BIRCH_WOOD = register("layered_birch_wood", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_JUNGLE_WOOD = register("layered_jungle_wood", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_ACACIA_WOOD = register("layered_acacia_wood", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_CHERRY_WOOD = register("layered_cherry_wood", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_DARK_OAK_WOOD = register("layered_dark_oak_wood", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_PALE_OAK_WOOD = register("layered_pale_oak_wood", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_MANGROVE_WOOD = register("layered_mangrove_wood", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava().forceSolidOn(), true);
    public static final Block LAYERED_CRIMSON_HYPHAE = register("layered_crimson_hyphae", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.CRIMSON_STEM).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).forceSolidOn(), true);
    public static final Block LAYERED_WARPED_HYPHAE = register("layered_warped_hyphae", FacingLayeredBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.WARPED_STEM).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).forceSolidOn(), true);
}