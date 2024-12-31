package com.mars.netherwartblock;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class Netherwartblock {
    public Netherwartblock(IEventBus eventBus) {
        CommonClass.init();
    }
}
