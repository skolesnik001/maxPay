import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static sessionsVariables.Variables.*;

public class LoginTest extends Initialization {



    LoginPage loginPage = new LoginPage(driver);

    @DataProvider(name = "invalidDataToLogin")
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {MAIL_INVALID_1, PASS_INVALID_1},
                {MAIL_INVALID_2, PASS_INVALID_2},
                {MAIL_INVALID_3, PASS_INVALID_3},
        };
    }
    @Test
    public void successfulLoginTest(){
        loginPage.loginUser(EMAIL_VALID, PASSWORD_VALID);
        loginPage.checkPage(DASHBOARD_PAGE_TITLE,10);

    }

    @Test(dataProvider = "invalidDataToLogin")
    public void negativeLoginTest(String mail, String password){
        loginPage.loginUser(mail, password);
        loginPage.assertForAll(ERROR_MESSAGE_INVALID_PASS_MAIL, loginPage.getErrorMessage());
    }


}
