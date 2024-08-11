package com.nba.utilities;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

import static java.lang.ThreadLocal.withInitial;


public enum TestContext {
    CONTEXT;
    private static final String DRIVER = "DRIVER";
    private final ThreadLocal<Map<String, Object>> testContexts = withInitial(HashMap::new);

    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        return (T) testContexts.get()
                .get(name);
    }

    public <T> void set(String name, T object) {
        testContexts.get()
                .put(name, object);
    }

    public WebDriver getDriver() {
        return get(DRIVER);
    }

    public void setDriver(WebDriver driver) {
        set(DRIVER, driver);
    }

    public void reset() {
        testContexts.get()
                .clear();
    }
}
