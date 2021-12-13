package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EntryTests extends BaseTest {
    @Test(description = "Create entry with random value")
    public void createEntry(){
        loginPage.open().login(USER, PASSWORD);
        homePage.createEntry(text);
        Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]"))
                .getText(), text);
    }

    @Test(description = "Select all entries and delete them")
    public void deleteEntry(){
        loginPage.open().login(USER, PASSWORD);
        homePage.createEntry(text);
        homePage.createEntry("Blabla");
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/span/input")).click();
        driver.findElement(By.id("delete-entries")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        String message = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div/div/div[2]")).getText();
        Assert.assertEquals(message, "No entries found");
    }

    @Test(description = "Search is working")
    public void searchEntry(){
        loginPage.open().login(USER, PASSWORD);
        homePage.createEntry(text);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("appendedInputButton")).click();
        driver.findElement(By.id("appendedInputButton")).sendKeys(text);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/section[1]/div/div/form/div/button")).submit();
        List<WebElement> searchList = new ArrayList<>(driver.findElements(By.xpath("//*[contains(text(), '" + text + "')]")));
        assertTrue(searchList.size()>=2);
    }
}
