package dev.skyegibney.actionapipractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public static WebDriver driver;
    public static String resourcesPath;
    protected String filePath;

    public BasePage(String filename) {
        this.filePath = "file:///" + resourcesPath + "/" + filename;
        PageFactory.initElements(driver, this);
    }

    public void solve() {
        driver.get(filePath);
        performActions();
    }

    abstract void performActions();
}
