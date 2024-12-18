package net.mcreator.backhomemod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Random;
import java.util.Iterator;

public class GoodExperienceaddProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;

        if (new Random().nextInt(10) == 0) { 
            if (entity instanceof Player _player)
                _player.giveExperiencePoints(5000);

            if (entity instanceof ServerPlayer _player) {
                Advancement _adv = _player.server.getAdvancements()
                        .getAdvancement(new ResourceLocation("back_home_mod:good_experience"));
                if (_adv != null) { 
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) { 
                        Iterator<String> _iterator = _ap.getRemainingCriteria().iterator();
                        while (_iterator.hasNext()) {
                            _player.getAdvancements().award(_adv, _iterator.next());
                        }
                    }
                }
            }
        }
    }
}
