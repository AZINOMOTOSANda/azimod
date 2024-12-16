
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.backhomemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.backhomemod.block.CompressedcopperblockBlock;
import net.mcreator.backhomemod.BackHomeModMod;

public class BackHomeModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, BackHomeModMod.MODID);
	public static final RegistryObject<Block> COMPRESSEDCOPPERBLOCK = REGISTRY.register("compressedcopperblock",
			() -> new CompressedcopperblockBlock());
}
