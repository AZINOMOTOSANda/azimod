
package net.mcreator.backhomemod.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.backhomemod.init.BackHomeModModTabs;

public class NigitmareeyeItem extends Item {
	public NigitmareeyeItem() {
		super(new Item.Properties().tab(BackHomeModModTabs.TAB_AZIMOD).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}
}
