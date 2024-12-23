package net.mcreator.backhomemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;

public class BackhomeProcedure {

    public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity == null || itemstack == null)
            return;

        if (!(entity instanceof Player _playerHasItem
                ? _playerHasItem.getMainHandItem() == itemstack
                : false)) {
            if (entity instanceof Player _player && !_player.level.isClientSide()) {
                _player.displayClientMessage(new TextComponent("cancel"), true);
            }
            return;
        }

        startCountdown(world, entity, itemstack, 3); // 3秒
    }

    private static void startCountdown(LevelAccessor world, Entity entity, ItemStack itemstack, int secondsLeft) {
        if (secondsLeft <= 0) {
            completeTeleport(world, entity, itemstack);
            return;
        }

        if (entity instanceof Player _player && !_player.level.isClientSide()) {
            _player.displayClientMessage(new TextComponent(String.valueOf(secondsLeft)), true);
        }

        scheduleWork(() -> {
            if (isItemStillHeld(entity, itemstack)) {
                startCountdown(world, entity, itemstack, secondsLeft - 1);
            } else {
                if (entity instanceof Player _player && !_player.level.isClientSide()) {
                    _player.displayClientMessage(new TextComponent("cancel"), true);
                }
            }
        }, 20);
    }

    private static void completeTeleport(LevelAccessor world, Entity entity, ItemStack itemstack) {
        if (entity instanceof Player _player && !_player.level.isClientSide()) {
            _player.displayClientMessage(new TextComponent("Back Home"), true);
        }

        itemstack.shrink(1);

        if (entity instanceof ServerPlayer _serverPlayer) {
            BlockPos respawnPos = _serverPlayer.getRespawnPosition();
            
            if (respawnPos != null) {
                boolean isBedSpawnValid = _serverPlayer.level.getBlockState(respawnPos)
                        .isBed(_serverPlayer.level, respawnPos, _serverPlayer);

                if (!isBedSpawnValid || !_serverPlayer.level.getChunkSource()
                        .hasChunk(respawnPos.getX() >> 4, respawnPos.getZ() >> 4)) {
                    respawnPos = new BlockPos(world.getLevelData().getXSpawn(),
                            world.getLevelData().getYSpawn(),
                            world.getLevelData().getZSpawn());
                }
            } else {
                respawnPos = new BlockPos(world.getLevelData().getXSpawn(),
                        world.getLevelData().getYSpawn(),
                        world.getLevelData().getZSpawn());
            }

            if (world instanceof ServerLevel serverWorld) {
                _serverPlayer.teleportTo(serverWorld,
                        respawnPos.getX() + 0.5,
                        respawnPos.getY(),
                        respawnPos.getZ() + 0.5,
                        _serverPlayer.getYRot(),
                        _serverPlayer.getXRot());
            }
        }
    }

    private static boolean isItemStillHeld(Entity entity, ItemStack itemstack) {
        return entity instanceof Player _player
                && _player.getMainHandItem() == itemstack;
    }

    private static void scheduleWork(Runnable action, int delayTicks) {
        new Thread(() -> {
            try {
                Thread.sleep(delayTicks * 50L); // 1ティック=50ミリ秒
                action.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}