package com.mars.netherwartblock;

import com.mars.deimos.config.DeimosConfig;
import com.mars.deimos.datagen.DeimosRecipeGenerator;
import net.minecraft.resources.ResourceLocation;

public class CommonClass {
    public static void init() {
        DeimosConfig.init("netherwartblock", NetherWartConfig.class);
        DeimosRecipeGenerator.createItemConvertorJson(new ResourceLocation("nether_wart_block"), new ResourceLocation("nether_wart"), NetherWartConfig.wartAmount);
    }
}