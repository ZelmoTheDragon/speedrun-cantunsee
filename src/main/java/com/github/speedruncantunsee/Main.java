package com.github.speedruncantunsee;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class Main {

    private Main() {
    }

    public static void main(final String[] args) {

        var options = new FirefoxOptions();
        var browser = new FirefoxDriver(options);
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
