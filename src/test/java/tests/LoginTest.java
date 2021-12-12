package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test(description = "User can login with valid credentials")
    @Description("Open Login Page, enter valid credentials, submit")
    public void loginTest(){
        loginPage.open()
                .login(USER, PASSWORD);
        assertTrue(homePage.isOpened(), "Login failed");
    }

    @Test
    public void loginPageIsOpening(){
        loginPage.open();
        Assert.assertEquals(true, loginPage.isOpened());
    }

}
