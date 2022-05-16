package com.github.speedruncantunsee;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

final class UI {

    private final WebDriver browser;

    private final String webSiteAddress;

    private final String buttonCompare;

    private final String buttonNext;

    private final String buttonShowMyScore;

    private final String email;

    private final List<String> answers;

    public UI(final WebDriver browser, final Properties properties) {
        this.browser = browser;
        this.webSiteAddress = properties.getProperty(Configuration.KEY_WEBSITE_URL);
        this.buttonCompare = properties.getProperty(Configuration.KEY_BUTTON_COMPARE);
        this.buttonNext = properties.getProperty(Configuration.KEY_BUTTON_NEXT);
        this.buttonShowMyScore = properties.getProperty(Configuration.KEY_BUTTON_SHOW);
        this.email = properties.getProperty(Configuration.USER_EMAIL);
        this.answers = List.of(properties.getProperty(Configuration.KEY_QUESTION_ANSWERS).split(Configuration.ANSWER_SEPARATOR_REGEX));
    }

    void play() {
        this.browser.get(this.webSiteAddress);
        var winning = true;
        var first = true;
        while (winning) {
            runAnyQuestion();
            if (first) {
                this.clickButton(this.buttonCompare);
                first = false;
            }
            this.clickButton(this.buttonNext);
            winning = isFinish();
        }
        this.clickButton(this.buttonShowMyScore);
        this.fillEmail();
    }

    void close() {
        this.browser.quit();
    }

    private void runAnyQuestion() {
        this.answers
                .stream()
                .map(e -> By.cssSelector("[src='" + e + "']"))
                .map(browser::findElements)
                .flatMap(Collection::stream)
                .forEach(WebElement::click);
    }

    private void clickButton(final String xPath) {
        this.browser
                .findElement(By.xpath(xPath))
                .click();
    }

    private boolean isFinish() {
        var path = By.xpath(this.buttonShowMyScore);
        var elements = this.browser.findElements(path);
        return elements.isEmpty();
    }

    private void fillEmail() {
        this.browser
                .findElement(By.cssSelector("[type='email'"))
                .sendKeys(this.email);
    }
}
