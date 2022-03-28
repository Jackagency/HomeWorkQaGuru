package config;

import com.codeborne.selenide.Browser;
import org.aeonbits.owner.Config;

import java.net.URL;

public interface WebDriverConfig extends Config {

    @Key("baseUrl")//читаем значение
    @DefaultValue("https://demoqa.com")//обрабатываем дефолтное
    String getBaseUrl();//конвертируем результат

    @Key("browser")//читаем значение
    @DefaultValue("CHROME")//обрабатываем дефолтное
    Browser getBrowser();//конвертируем результат

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("remoteUrl")
    URL getRemoteUrl();

}
