package com.mars.netherwartblock;

import com.mars.deimos.config.DeimosConfig;
import com.mars.deimos.datagen.DeimosRecipeGenerator;
import com.mars.netherwartblock.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

public class CommonClass {
    public static void init() {
        DeimosConfig.init("netherwartblock", NetherWartConfig.class);
        DeimosRecipeGenerator.createItemConvertorJson(ResourceLocation.withDefaultNamespace("nether_wart_block"), ResourceLocation.withDefaultNamespace("nether_wart"), NetherWartConfig.wartAmount);
    }
}
