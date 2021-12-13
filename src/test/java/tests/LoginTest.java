package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test(description = "User can login with valid credentials")
    @Description("Open Login Page, enter valid credentials, submit")
    public void loginTest(){
        loginPage.open()
                .login(USER, PASSWORD);
        assertTrue(homePage.isOpened(), "Login failed");
    }

    @Test(description = "Login page successfully opened")
    public void loginPageIsOpening(){
        loginPage.open();
        Assert.assertEquals(true, loginPage.isOpened());
    }

    @Test(description = "Login with wrong credentials")
    @Description("You should see \"Login failed\" message")
    public void invalidLogin(){
        loginPage.open().login(USER, "blabla");
        assertEquals(driver.findElement(By.xpath("//*[contains(text(), 'Login failed')]")).getText(), "Login failed");
    }

}
