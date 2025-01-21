package net.cathienova.havenvol.config;

import net.cathienova.havenvol.HavenVOL;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;

@EventBusSubscriber(modid = HavenVOL.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ConfigSubscriber {
    @SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent event) {
        HavenConfig.bake(event.getConfig());
    }
}