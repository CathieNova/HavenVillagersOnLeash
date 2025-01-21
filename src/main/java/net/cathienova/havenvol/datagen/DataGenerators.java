package net.cathienova.havenvol.datagen;

import net.cathienova.havenvol.HavenVOL;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {
    @EventBusSubscriber(modid = HavenVOL.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
    public static class ModRecipeProvider {
        @SubscribeEvent
        public static void gatherData(GatherDataEvent event) {
            DataGenerator generator = event.getGenerator();
            PackOutput output = generator.getPackOutput();

            boolean includeClient = event.includeClient();

            if (includeClient) {
                generator.addProvider(includeClient, new ModEngLangProvider(output));
            }
        }
    }
}
