package dev.skyegibney.actionapipractice.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClickKeysPage extends BasePage {
    public ClickKeysPage() {
        super("click-keys.html");
    }

    @Override
    void performActions() {
        while (90 > Integer.parseInt(progressBar.getAttribute("value"))) {
            String characterText = characterIndicator.getText();
            pressKey(characterText);
        }

        String characterText = characterIndicator.getText();
        pressKey(characterText);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent())
                        .accept();
    }

    // Helper method to interpret key presses from string inputs
    private void pressKey(String input) {
        switch (input.trim()) {
            case "up arrow" -> new Actions(driver).sendKeys(Keys.ARROW_UP).perform();
            case "left arrow" -> new Actions(driver).sendKeys(Keys.ARROW_LEFT).perform();
            case "right arrow" -> new Actions(driver).sendKeys(Keys.ARROW_RIGHT).perform();
            case "down arrow" -> new Actions(driver).sendKeys(Keys.ARROW_DOWN).perform();
            default -> new Actions(driver).sendKeys(input).perform();
        }
    }

    @FindBy(id="characterIndicator")
    WebElement characterIndicator;

    @FindBy(id="progress")
    WebElement progressBar;
}
