package dev.skyegibney.actionapipractice;

import dev.skyegibney.actionapipractice.pages.BasePage;
import dev.skyegibney.actionapipractice.pages.ClickKeysPage;
import dev.skyegibney.actionapipractice.pages.DragAndDropPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class AutomationScript  {
    public static void main(String[] args) {
        // Setting up
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        BasePage.driver = driver;
        BasePage.resourcesPath = new File(".").getAbsolutePath() + "/src/main/resources";

        // Create test pages
        List<BasePage> pages = Arrays.asList(
                new ClickKeysPage(),
                new DragAndDropPage()
        );

        // Test each page
        for (var page: pages) {
            System.out.print(page.getClass().getSimpleName() + " - ");

            try {
                page.solve();
                System.out.println("OK");
            }
            catch (Exception e) {
                System.out.println("EXCEPTION");
                System.out.println(e.toString().split(" ")[0]);
            }
        }

        Thread.sleep(3000);

        // Cleanup
        driver.quit();
    }
}
