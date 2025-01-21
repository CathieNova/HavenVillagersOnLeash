package net.cathienova.havenvol.datagen;

import net.cathienova.havenvol.HavenVOL;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEngLangProvider extends LanguageProvider
{
    public ModEngLangProvider(PackOutput output)
    {
        super(output, HavenVOL.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations()
    {

    }
}
