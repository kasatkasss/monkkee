package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SettingsTest extends BaseTest{
    @Test(description = "Change language to French")
    public void changeLanguageTest(){
        loginPage.open().login(USER, PASSWORD);
        settingPage.open().changeLanguage();
        String message = driver.findElement(By.xpath("//*[@id=\"settings-content\"]/h1")).getText();
        Assert.assertEquals(message, "Sélection de la langue");
        //settingPage.revertToEnglish();
    }
}
