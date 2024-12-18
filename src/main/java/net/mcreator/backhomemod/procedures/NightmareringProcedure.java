package net.mcreator.backhomemod.procedures;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class NightmareringProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;


        long currentTime = entity.level.getGameTime();

        if (entity.getPersistentData().contains("nightmarering_cooldown")) {
            long lastUsed = entity.getPersistentData().getLong("nightmarering_cooldown");

            if ((currentTime - lastUsed) < 20) {
                return;
            }
        }

        entity.getPersistentData().putLong("nightmarering_cooldown", currentTime);

        if (entity instanceof Player player) {
            ItemStack itemInHand = player.getMainHandItem();
            if (!itemInHand.isEmpty()) {

                itemInHand.hurtAndBreak(1, player, (p) -> {
                    p.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
        }


        double targetX = entity.level.clip(new ClipContext(
                entity.getEyePosition(1f),
                entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 0.5;
        double targetY = entity.level.clip(new ClipContext(
                entity.getEyePosition(1f),
                entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 0.5;
        double targetZ = entity.level.clip(new ClipContext(
                entity.getEyePosition(1f),
                entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 0.5;


        if (world instanceof ServerLevel _level) {
            _level.sendParticles(ParticleTypes.PORTAL, targetX, targetY, targetZ, 200, 2, 2, 2, 0.05);
        }

        entity.teleportTo(targetX, targetY, targetZ);
        if (entity instanceof ServerPlayer serverPlayer) {
            serverPlayer.connection.teleport(targetX, targetY, targetZ, entity.getYRot(), entity.getXRot());
        }

        new Object() {
            private int ticks = 0;
            private float waitTicks;
            private LevelAccessor world;

            public void start(LevelAccessor world, int waitTicks) {
                this.waitTicks = waitTicks;
                MinecraftForge.EVENT_BUS.register(this);
                this.world = world;
            }

            @SubscribeEvent
            public void tick(TickEvent.ServerTickEvent event) {
                if (event.phase == TickEvent.Phase.END) {
                    this.ticks += 1;
                    if (this.ticks >= this.waitTicks)
                        run();
                }
            }

            private void run() {
                if (world instanceof ServerLevel _serverLevel) {
                    _serverLevel.playSound(null, new BlockPos(targetX, targetY, targetZ),
                            ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")),
                            net.minecraft.sounds.SoundSource.PLAYERS, 1.0f, 1.0f);
                }
                MinecraftForge.EVENT_BUS.unregister(this);
            }
        }.start(world, 1); 
    }
}
