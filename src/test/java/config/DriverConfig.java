package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverConfig {
    public static void configure() {
        Configuration.browser = Project.webConfig.browserName();
        Configuration.browserVersion = Project.webConfig.browserVersion();
        Configuration.browserSize = Project.webConfig.browserSize();
        Configuration.baseUrl = Project.webConfig.getBaseUrl();


        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (Project.isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = Project.webConfig.remoteUrl();
        }
        Configuration.browserCapabilities = capabilities;

    }
}
