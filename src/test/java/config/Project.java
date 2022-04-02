package config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static WebDriverConfig webConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static boolean isRemoteWebDriver() {
        return !webConfig.remoteUrl().equals("");
    }

    public static String browserName() {
        return webConfig.browserName();
    }

    public static String baseUrl() {
        return webConfig.getBaseUrl();
    }

}
