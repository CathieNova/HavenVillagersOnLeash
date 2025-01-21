package net.cathienova.havenvol.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CommonConfig {
    public final ModConfigSpec.BooleanValue enableVillagerLeashed;
    public final ModConfigSpec.BooleanValue enableBabyVillagerLeashed;

    public CommonConfig(ModConfigSpec.Builder builder) {
        enableVillagerLeashed = builder
                .comment("Enable leashing of adult villagers")
                .define("enableVillagerLeashed", true);

        enableBabyVillagerLeashed = builder
                .comment("Enable leashing of baby villagers")
                .define("enableBabyVillagerLeashed", false);
    }
}