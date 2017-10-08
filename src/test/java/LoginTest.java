import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by siava on 08.10.2017.
 */
public class LoginTest extends Initialization {

    LoginPage loginPage = new LoginPage(driver);

    @DataProvider(name = "invalidDataToLogin")
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {"123", "321"},
                {"abc", "!!!!!!!!!!!!!!!!!!!!!"},
                {"zxc", "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"},
        };
    }
    @Test
    public void successfulLoginTest(){
        loginPage.loginUser("test_user@test.com", "Qwerty123");
        loginPage.checkPage("Dashboard — Merchant portal",10);
    }

    @Test(dataProvider = "invalidDataToLogin")
    public void negativeLoginTest(String mail, String password){
        loginPage.loginUser(mail, password);
    }


}
