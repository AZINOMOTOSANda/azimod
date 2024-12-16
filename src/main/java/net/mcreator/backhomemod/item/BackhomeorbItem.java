
package net.mcreator.backhomemod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.backhomemod.procedures.BackhomeProcedure;

import java.util.List;

public class BackhomeorbItem extends Item {
	public BackhomeorbItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64).rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent(
				"\u4F7F\u7528\u5F8C\uFF13\u79D2(2\u79D2\u4EE5\u5185\u306B\u6301\u3061\u304B\u3048\u308C\u3070\u30AD\u30E3\u30F3\u30BB\u30EB\u53EF\u80FD)\u3067\u30EA\u30B9\u30DD\u30FC\u30F3\u5730\u70B9\u306B\u5E30\u9084\u3002"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		BackhomeProcedure.execute(world, entity, itemstack);
		return ar;
	}
}
