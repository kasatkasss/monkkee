package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage{

    private static final By LOGIN_FIELD = By.id("login");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By CANCEL = By.xpath("/html/body/div[4]/div/div/div[3]/div/button");
    private static final By MODAL_CONTENT = By.className("modal-content");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage open(){
        driver.get(BASE_URL);
        return this;
    }

    public boolean isOpened(){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id("login")));
        } catch (TimeoutException exception){
            return false;
        }
        return true;
    }

    @Step("Login using credentials: '{user}' and '{password}'")
    public HomePage login(String user, String password){
        driver.findElement(LOGIN_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(PASSWORD_FIELD).submit();
        List<WebElement> list = new ArrayList<>(driver.findElements(MODAL_CONTENT));
        if(list.size()!=0){
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(CANCEL).click();
        }
        return new HomePage(driver);
    }
}
