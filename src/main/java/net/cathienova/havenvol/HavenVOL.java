package net.cathienova.havenvol;

import com.mojang.logging.LogUtils;
import net.cathienova.havenvol.config.CommonConfig;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

@Mod(HavenVOL.MOD_ID)
public class HavenVOL
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "havenvol";
    public static final String MOD_NAME = "Haven Villagers On Leash";
    static final ModConfigSpec commonSpec;
    public static final CommonConfig c_config;

    static
    {
        final Pair<CommonConfig, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(CommonConfig::new);
        commonSpec = specPair.getRight();
        c_config = specPair.getLeft();
    }

    public HavenVOL(IEventBus bus, ModContainer modContainer)
    {
        bus.addListener(this::setup);
        modContainer.registerConfig(ModConfig.Type.COMMON, commonSpec);
        bus.addListener(this::setup);
    }

    public static void Log(String message)
    {
        LogUtils.getLogger().info("[" + MOD_NAME + "] " + message);
    }

    private void setup(FMLCommonSetupEvent event)
    {
    }
    public static ResourceLocation loc(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}
