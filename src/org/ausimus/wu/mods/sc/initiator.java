package org.ausimus.wu.mods.sc;

import com.wurmonline.server.items.CreationCategories;
import com.wurmonline.server.items.CreationEntryCreator;
import com.wurmonline.server.items.ItemList;
import com.wurmonline.server.skills.SkillList;
import org.gotti.wurmunlimited.modloader.interfaces.Configurable;
import org.gotti.wurmunlimited.modloader.interfaces.ServerStartedListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

import java.util.Properties;

public class initiator implements WurmServerMod, ServerStartedListener, Configurable
{
    private double minSkill;

    @Override
    public void configure(Properties properties)
    {
        minSkill = Double.parseDouble(properties.getProperty("minSkill", Double.toString(minSkill)));
    }

    @Override
    public void onServerStarted()
    {
        CreationEntryCreator.createSimpleEntry(
                SkillList.MASONRY, ItemList.rock, ItemList.clay, ItemList.concrete,
                true, true, 0.0f, false, false,
                0, minSkill, CreationCategories.CONSTRUCTION_MATERIAL);
    }
}