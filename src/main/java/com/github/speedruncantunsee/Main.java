package com.github.speedruncantunsee;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public final class Main {

    private static final String CHROMIUM_BROWSER = "-chromium";

    private static final String CHROME_BROWSER = "-chrome";

    private static final String FIREFOX_BROWSER = "-firefox";

    private Main() {
    }

    public static void main(final String[] args) {

        var params = List.of(args);
        WebDriver browser;
        if (params.contains(CHROMIUM_BROWSER) || params.contains(CHROME_BROWSER)) {
            browser = WebBrowserFactory.createChrome();
        } else if (params.contains(FIREFOX_BROWSER)) {
            browser = WebBrowserFactory.createFirefox();
        } else {
            browser = WebBrowserFactory.createFirefox();
        }

        var properties = loadProperties();
        var ui = new UI(browser, properties);
        ui.play();
        //ui.close();
    }

    private static Properties loadProperties() {
        var configuration = Main.class
                .getClassLoader()
                .getResourceAsStream("application.properties");

        try (configuration) {
            var properties = new Properties();
            properties.load(configuration);
            return properties;
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }


}
