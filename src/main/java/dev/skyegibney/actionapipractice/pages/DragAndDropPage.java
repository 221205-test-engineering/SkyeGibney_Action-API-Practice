package dev.skyegibney.actionapipractice.pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage() {
        super("drag-and-drop.html");
    }

    @Override
    void performActions() {
        new Actions(driver)
                .clickAndHold(toDrag)
                .moveToElement(targetDiv)
                .release()
                .perform();
    }

    @FindBy(id="toDrag")
    WebElement toDrag;

    @FindBy(xpath="//div")
    WebElement targetDiv;
}
