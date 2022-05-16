package com.github.cantunsee;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class Main {

    private static final String ANSWER_SEARCH_BAR_IN_BASE64 = "data:image/png;base64,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";

    private static final List<String> ANSWERS = List.of(
            "/static/media/T01.774c6f95.png",
            "/static/media/T12.2cdd96c6.png",
            "/static/media/T21.51a7913d.png",

            "/static/media/00.ee5a905d.png",
            "/static/media/00.f1e4590b.png",
            "/static/media/00.3b47d30f.png",
            "/static/media/00.8fe7f9c4.png",
            "/static/media/00.98aafb88.png",

            ANSWER_SEARCH_BAR_IN_BASE64
    );

    private static final String XPATH_BUTTON_COMPARE = "//button[text()='Compare']";

    private static final String XPATH_BUTTON_NEXT = "//button[text()='Next']";

    private static final String XPATH_BUTTON_SHOW_MY_SCORE = "//button[text()='Show My Score']";

    private Main() {
    }

    public static void main(final String[] args) {

        var options = new FirefoxOptions();
        var browser = new FirefoxDriver(options);
        browser.get("https://cantunsee.space/");

        var winning = true;
        var first = true;

        while (winning) {
            runAnyQuestion(browser);
            if (first) {
                clickButton(browser, XPATH_BUTTON_COMPARE);
                first = false;
            }
            clickButton(browser, XPATH_BUTTON_NEXT);
            winning = isFinish(browser);
        }

        clickButton(browser, XPATH_BUTTON_SHOW_MY_SCORE);
        fillEmail(browser, "maximemoselle@gmail.com");
        //browser.quit();
    }

    private static void runAnyQuestion(final FirefoxDriver browser) {

        ANSWERS
                .stream()
                .map(e -> By.cssSelector("[src='" + e + "']"))
                .map(browser::findElements)
                .flatMap(Collection::stream)
                .forEach(WebElement::click);
    }

    private static void clickButton(final FirefoxDriver browser, final String xPath) {
        browser
                .findElement(By.xpath(xPath))
                .click();
    }

    private static boolean isFinish(final FirefoxDriver browser) {
        var path = By.xpath(XPATH_BUTTON_SHOW_MY_SCORE);
        var elements = browser.findElements(path);
        return elements.isEmpty();
    }

    private static void fillEmail(final  FirefoxDriver browser, final String email){
        browser
                .findElement(By.cssSelector("[type='email'"))
                .sendKeys(email);
    }

}