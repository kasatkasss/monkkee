package tests;

import org.testng.annotations.Test;
import utils.Retry;

public class EntryTests extends BaseTest {
    @Test(retryAnalyzer = Retry.class)
    public void cteateEntry(){
        loginPage.open().login(USER, PASSWORD);
        homePage.createEntry();
    }
}
