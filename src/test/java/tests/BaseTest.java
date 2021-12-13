package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SettingPage;
import utils.PropertyReader;
import utils.TestListener;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    public static final String USER = PropertyReader.getProperty("monkkee.user");
    public static final String PASSWORD = PropertyReader.getProperty("monkkee.password");
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    SettingPage settingPage;
    Faker faker = new Faker();
    String text = faker.book().author();

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, ITestContext context) {
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("opera")){
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
        driver.manage().window().maximize();
        context.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        settingPage = new SettingPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
