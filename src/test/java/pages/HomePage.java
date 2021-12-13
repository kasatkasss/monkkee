package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    private static final By CREATE_ENTRY = By.id("create-entry");
    private static final By TEXT_AREA = By.xpath("//*[@id=\"editable\"]/p");
    private static final By BACK_TO_OVERVIEW = By.id("back-to-overview");
    public HomePage(WebDriver driver){
        super(driver);
    }

    public HomePage open(){
        driver.get(BASE_URL + "entries");
        return this;
    }

    public boolean isOpened(){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.xpath("/html/body/header/div[2]/div/div/div[2]/button")));
        } catch (TimeoutException exception){
            return false;
        }
        return true;
    }

    public void createEntry(String text){
        driver.findElement(CREATE_ENTRY).click();
        driver.findElement(TEXT_AREA).sendKeys(text);
        driver.findElement(BACK_TO_OVERVIEW).click();
    }


}
