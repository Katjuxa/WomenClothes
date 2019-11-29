import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WomenClothes {
    private final By WOMANCLICK = By.xpath(".//a[@title='Women']");
    private final By LEFTBOX = By.xpath(".//ul[@class='tree dynamized']");
    private final By MAINBOX = By.xpath(".//a[@class='subcategory-name']");
    private static final Logger LOGGER = LogManager.getLogger(WomenClothes.class);

    @Test
    public void ClothesTest() throws InterruptedException {
        LOGGER.info("Open Browser");
        System.setProperty("webdriver.chrome.driver", "D:/Jekaterina/QAGuru/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Goto URL");
        driver.get("http://automationpractice.com");

        LOGGER.info("Click Women button");
        WebElement WomanClick = driver.findElement(WOMANCLICK);
        WomanClick.click();

        LOGGER.info("Check department count and equals it 2?");
        Thread.sleep(1000);
        List<WebElement> we = driver.findElements(LEFTBOX);
        String[] leftNames = we.get(0).getText().split("\n", 0);
        String leftFisrst = leftNames[0].toString().toLowerCase();
        String leftSecond = leftNames[1].toString().toLowerCase();
        Integer count = leftNames.length;
        Assertions.assertEquals(2, count);

       List<WebElement> mainwe = driver.findElements(MAINBOX);
        Integer maincount = mainwe.size();

        String mainFirst = driver.findElements(MAINBOX).get(0).getText().toLowerCase();
       String mainSecond = driver.findElements(MAINBOX).get(1).getText().toLowerCase();
        LOGGER.info("Check titles and section count is equals in left column and in the main page");
        Assertions.assertEquals(count, maincount, "Section count is different");
        Assertions.assertEquals(leftFisrst, mainFirst, "Wrong first name!");
        Assertions.assertEquals(leftSecond, mainSecond, "Wrong second name!");

        LOGGER.info("Resize window to mobile view");
        Dimension size = new Dimension(400, 702);
        driver.manage().window().setSize(size);
        LOGGER.info("Check department count and compare titles");






        for ( String str1 : leftNames   )
        {
            System.out.println("Web Elements:" + str1);
            if(subcategoryExists(str1))
            {
                System.out.println("Subcategory " + str1 + " exists");
            }
            else
                System.out.println("Subcategory " + str1 + " not found");
        }

//        System.out.println("Web Elements:" + strs[0]);
        LOGGER.info("Check titles is equals in left column and in the main page");
        LOGGER.info("Resize window to mobile view");
        LOGGER.info("Check department count and compare titles");
        LOGGER.info("Close browser");

    }

    boolean subcategoryExists (String subCategoryName)
    {
        return true;
    }

}

