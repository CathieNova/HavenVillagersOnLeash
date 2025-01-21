package net.cathienova.havenvol.handler;

import net.cathienova.havenvol.config.HavenConfig;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber
public class EntityInteractHandler
{
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event)
    {
        if (event.getTarget() instanceof Villager villager)
        {
            if (!HavenConfig.enableVillagerLeashed) return;
            Player player = event.getEntity();
            InteractionHand hand = event.getHand();

            if (player.getItemInHand(event.getHand()).is(Items.LEAD))
            {
                if (!villager.isLeashed())
                {
                    if (villager.isBaby() && HavenConfig.enableBabyVillagerLeashed)
                    {
                        LeashVillager(villager, player, hand);
                    }
                    else if (!villager.isBaby())
                    {
                        LeashVillager(villager, player, hand);
                    }
                }
                else
                {
                    villager.dropLeash(true, !player.isCreative());
                }
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        }
    }

    private static void LeashVillager(Villager villager, Player player, InteractionHand hand)
    {
        villager.setLeashedTo(player, true);
        if (!player.isCreative())
            player.getItemInHand(hand).shrink(1);
    }
}
