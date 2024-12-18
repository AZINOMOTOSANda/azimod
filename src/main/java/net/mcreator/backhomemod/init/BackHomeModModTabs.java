
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.backhomemod.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class BackHomeModModTabs {
	public static CreativeModeTab TAB_AZIMOD;

	public static void load() {
		TAB_AZIMOD = new CreativeModeTab("tabazimod") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(BackHomeModModItems.EMERALDAPICKEL.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
