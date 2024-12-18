
package net.mcreator.backhomemod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.backhomemod.init.BackHomeModModTabs;

public class CompressedcopperingotItem extends Item {
	public CompressedcopperingotItem() {
		super(new Item.Properties().tab(BackHomeModModTabs.TAB_AZIMOD).stacksTo(64).rarity(Rarity.EPIC));
	}
}
