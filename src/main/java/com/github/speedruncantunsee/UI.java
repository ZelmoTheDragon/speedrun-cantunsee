package com.github.speedruncantunsee;

import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

final class UI {

    private final WebDriver browser;

    private final String webSiteAddress;

    private final String email;

    private final By buttonCompare;

    private final By buttonNext;

    private final By buttonShowMyScore;

    private final List<By> answers;

    UI(final WebDriver browser, final Properties properties) {
        this.browser = browser;
        this.webSiteAddress = properties.getProperty(Configuration.KEY_WEBSITE_URL);
        this.email = properties.getProperty(Configuration.USER_EMAIL);
        this.buttonCompare = By.xpath(properties.getProperty(Configuration.KEY_BUTTON_COMPARE));
        this.buttonNext = By.xpath(properties.getProperty(Configuration.KEY_BUTTON_NEXT));
        this.buttonShowMyScore = By.xpath(properties.getProperty(Configuration.KEY_BUTTON_SHOW));
        this.answers = Stream
                .of(properties.getProperty(Configuration.KEY_QUESTION_ANSWERS))
                .flatMap(e -> Stream.of(e.split(Configuration.ANSWER_SEPARATOR_REGEX)))
                .map(e -> By.cssSelector("[src='" + e + "']"))
                .toList();
    }

    void play() {
        this.browser.get(this.webSiteAddress);
        var first = true;
        while (this.hasNextQuestion()) {
            this.answerQuestion();
            if (first) {
                this.clickButton(this.buttonCompare);
                first = false;
            }
            this.clickButton(this.buttonNext);
        }
        this.clickButton(this.buttonShowMyScore);
        this.fillEmail();
    }

    void close() {
        this.browser.quit();
    }

    private void answerQuestion() {
        this.answers
                .stream()
                .map(browser::findElements)
                .flatMap(Collection::stream)
                .forEach(WebElement::click);
    }

    private void clickButton(final By locator) {
        this.browser
                .findElement(locator)
                .click();
    }

    private boolean hasNextQuestion() {
        var elements = this.browser.findElements(this.buttonShowMyScore);
        return elements.isEmpty();
    }

    private void fillEmail() {
        this.browser
                .findElement(By.cssSelector("[type='email'"))
                .sendKeys(this.email);
    }
}
