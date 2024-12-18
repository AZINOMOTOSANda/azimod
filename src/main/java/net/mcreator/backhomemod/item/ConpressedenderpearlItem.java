
package net.mcreator.backhomemod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.backhomemod.init.BackHomeModModTabs;

public class ConpressedenderpearlItem extends Item {
	public ConpressedenderpearlItem() {
		super(new Item.Properties().tab(BackHomeModModTabs.TAB_AZIMOD).stacksTo(64).rarity(Rarity.RARE));
	}
}
