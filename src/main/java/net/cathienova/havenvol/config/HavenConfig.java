package net.cathienova.havenvol.config;

import net.cathienova.havenvol.HavenVOL;
import net.neoforged.fml.config.ModConfig;

public class HavenConfig
{
    public static boolean enableVillagerLeashed;
    public static boolean enableBabyVillagerLeashed;

    public static void bake(ModConfig config)
    {
        enableVillagerLeashed = HavenVOL.c_config.enableVillagerLeashed.get();
        enableBabyVillagerLeashed = HavenVOL.c_config.enableBabyVillagerLeashed.get();
    }
}