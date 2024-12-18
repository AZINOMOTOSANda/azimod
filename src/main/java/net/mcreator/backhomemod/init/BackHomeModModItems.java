
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.backhomemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.backhomemod.item.NigitmareeyeItem;
import net.mcreator.backhomemod.item.NightmareringitemItem;
import net.mcreator.backhomemod.item.EmeraldswordItem;
import net.mcreator.backhomemod.item.EmeraldshovelItem;
import net.mcreator.backhomemod.item.EmeraldpickelItem;
import net.mcreator.backhomemod.item.EmeraldhoeItem;
import net.mcreator.backhomemod.item.EmeraldaxeItem;
import net.mcreator.backhomemod.item.CopperswordItem;
import net.mcreator.backhomemod.item.CoppersovelItem;
import net.mcreator.backhomemod.item.CopperpickelItem;
import net.mcreator.backhomemod.item.ConpressedenderpearlItem;
import net.mcreator.backhomemod.item.ConpressCopperpickelItem;
import net.mcreator.backhomemod.item.CompressedcopperingotItem;
import net.mcreator.backhomemod.item.BackhomeorbItem;
import net.mcreator.backhomemod.BackHomeModMod;

public class BackHomeModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BackHomeModMod.MODID);
	public static final RegistryObject<Item> COMPRESSEDCOPPERINGOT = REGISTRY.register("compressedcopperingot",
			() -> new CompressedcopperingotItem());
	public static final RegistryObject<Item> BACKHOMEORB = REGISTRY.register("backhomeorb", () -> new BackhomeorbItem());
	public static final RegistryObject<Item> COMPRESSEDCOPPERBLOCK = block(BackHomeModModBlocks.COMPRESSEDCOPPERBLOCK,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> COPPERPICKEL = REGISTRY.register("copperpickel", () -> new CopperpickelItem());
	public static final RegistryObject<Item> COPPERSOVEL = REGISTRY.register("coppersovel", () -> new CoppersovelItem());
	public static final RegistryObject<Item> CONPRESSEDENDERPEARL = REGISTRY.register("conpressedenderpearl", () -> new ConpressedenderpearlItem());
	public static final RegistryObject<Item> NIGITMAREEYE = REGISTRY.register("nigitmareeye", () -> new NigitmareeyeItem());
	public static final RegistryObject<Item> NIGHTMARERINGITEM = REGISTRY.register("nightmareringitem", () -> new NightmareringitemItem());
	public static final RegistryObject<Item> CONPRESS_COPPERPICKEL = REGISTRY.register("conpress_copperpickel", () -> new ConpressCopperpickelItem());
	public static final RegistryObject<Item> COPPERSWORD = REGISTRY.register("coppersword", () -> new CopperswordItem());
	public static final RegistryObject<Item> EMERALDPICKEL = REGISTRY.register("emeraldpickel", () -> new EmeraldpickelItem());
	public static final RegistryObject<Item> EMERALDSWORD = REGISTRY.register("emeraldsword", () -> new EmeraldswordItem());
	public static final RegistryObject<Item> EMERALDSHOVEL = REGISTRY.register("emeraldshovel", () -> new EmeraldshovelItem());
	public static final RegistryObject<Item> EMERALDAXE = REGISTRY.register("emeraldaxe", () -> new EmeraldaxeItem());
	public static final RegistryObject<Item> EMERALDHOE = REGISTRY.register("emeraldhoe", () -> new EmeraldhoeItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
