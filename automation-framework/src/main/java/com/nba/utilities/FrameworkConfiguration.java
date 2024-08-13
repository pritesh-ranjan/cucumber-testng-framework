package com.nba.utilities;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config.properties"})
public interface FrameworkConfiguration extends Config {

    @Key("browser")
    String browser();

    @Key("core-product-url")
    String coreProductUrl();

    @Key("derived-product1-url")
    String derivedProduct1Url();

    @Key("derived-product2-url")
    String derivedProduct2Url();
    @Key("output-file")
    String getOutputFile();
}