package com.nba.utilities;

import lombok.experimental.UtilityClass;
import org.aeonbits.owner.ConfigCache;

@UtilityClass
public class ConfigFactory {
    public static FrameworkConfiguration getConfig() {
        return ConfigCache.getOrCreate(FrameworkConfiguration.class);
    }
}