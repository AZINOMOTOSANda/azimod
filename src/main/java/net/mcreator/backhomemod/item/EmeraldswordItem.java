
package net.mcreator.backhomemod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.entity.Entity;


import net.mcreator.backhomemod.procedures.EmeraldtoolfortuneProcedure;
import net.mcreator.backhomemod.procedures.GoodExperienceaddProcedure;
import net.mcreator.backhomemod.init.BackHomeModModTabs;

public class EmeraldswordItem extends SwordItem {
	public EmeraldswordItem() {
		super(new Tier() {
			public int getUses() {
				return 1561;
			}

			public float getSpeed() {
				return 1f;
			}

			public float getAttackDamageBonus() {
				return 5f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 0;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().tab(BackHomeModModTabs.TAB_AZIMOD));
	}
	
	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			EmeraldtoolfortuneProcedure.execute(entity);
	}


    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.hurtEnemy(stack, target, attacker);
        if (stack.getDamageValue() >= stack.getMaxDamage()) {
            triggerBreakProcedure(attacker.level, attacker);
        }
        return result;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity entity) {
        boolean result = super.mineBlock(stack, world, state, pos, entity);
        if (stack.getDamageValue() >= stack.getMaxDamage()) {
            triggerBreakProcedure(world, entity);
        }
        return result;
    }

    private void triggerBreakProcedure(Level world, LivingEntity entity) {
        
        GoodExperienceaddProcedure.execute(entity);
    }

    public void inventoryTick(ItemStack itemstack, Level world, LivingEntity entity, int slot, boolean selected) {
        if (selected) {
			
            EmeraldtoolfortuneProcedure.execute(entity);
        }
    }
}
