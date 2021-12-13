package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SettingPage extends BasePage{
    public SettingPage(WebDriver driver) {
        super(driver);
    }

    public SettingPage open(){
        driver.get(BASE_URL + "settings/locale");
        return this;
    }

    public boolean isOpened(){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("//*[@id=\"settings-menu\"]/ul/li[1]/a")));
        } catch (TimeoutException exception){
            return false;
        }
        return true;
    }

    public void changeLanguage(){
        driver.findElement(By.xpath("//*[@id=\"settings-menu\"]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"settings-content\"]/form/div[3]/div/select")).click();
        driver.findElement(By.xpath("//*[@id=\"settings-content\"]/form/div[3]/div/select/option[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"settings-content\"]/form/div[4]/div/button/div")).click();
    }

    public void revertToEnglish(){
        driver.findElement(By.xpath("//*[@id=\"settings-menu\"]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"settings-content\"]/form/div[3]/div/select")).click();
        driver.findElement(By.xpath("//*[@id=\"settings-content\"]/form/div[3]/div/select/option[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"settings-content\"]/form/div[4]/div/button/div")).click();
    }
}
