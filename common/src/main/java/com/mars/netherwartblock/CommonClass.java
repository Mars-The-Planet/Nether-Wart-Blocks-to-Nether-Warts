package com.mars.netherwartblock;

import com.mars.deimos.config.DeimosConfig;
import com.mars.deimos.datagen.DeimosRecipeGenerator;
import net.minecraft.resources.Identifier;

public class CommonClass {
    public static void init() {
        DeimosConfig.init("netherwartblock", NetherWartConfig.class);
        DeimosRecipeGenerator.createItemConvertorJson(Identifier.withDefaultNamespace("nether_wart_block"), Identifier.withDefaultNamespace("nether_wart"), NetherWartConfig.wartAmount);
    }
}
