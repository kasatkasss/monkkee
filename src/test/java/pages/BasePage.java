package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

public abstract class BasePage {
    public static final String BASE_URL = PropertyReader.getProperty("monkkee.url");
    WebDriver driver;
    WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
}
