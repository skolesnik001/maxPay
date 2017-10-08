import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by siava on 08.10.2017.
 */
public class LoginPage extends BasePage {



    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='login-email']")
    private WebElement emailField;

    @FindBy(xpath = ".//*[@id='login-password']")
    private WebElement passwordField;

    public void loginUser(String email, String password){
        emailField.click();
        emailField.sendKeys(email);
        passwordField.click();
        passwordField.sendKeys(password);
        passwordField.submit();
    }


}
