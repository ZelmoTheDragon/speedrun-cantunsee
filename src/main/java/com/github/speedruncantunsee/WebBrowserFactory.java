package com.github.speedruncantunsee;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverLogLevel;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

final class WebBrowserFactory {

    private static final Dimension WINDOW_SIZE = new Dimension(800, 900);

    private WebBrowserFactory() {
    }

    static WebDriver createFirefox() {
        WebDriverManager.firefoxdriver().setup();

        var options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setLogLevel(FirefoxDriverLogLevel.WARN);
        options.setHeadless(false);

        var browser = new FirefoxDriver(options);
        browser
                .manage()
                .window()
                .setSize(WINDOW_SIZE);

        return browser;
    }

    static WebDriver createChromium() {
        WebDriverManager.chromiumdriver().setup();

        var options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setLogLevel(ChromeDriverLogLevel.WARNING);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setHeadless(false);
        var browser = new ChromeDriver(options);

        browser
                .manage()
                .window()
                .setSize(WINDOW_SIZE);

        return browser;
    }
}
