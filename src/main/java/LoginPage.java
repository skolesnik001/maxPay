import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    @FindBy(css = ".alert.alert-danger.alert-dismissable.push-15")
    private WebElement errorMessage;



    public void loginUser(String email, String password){
        emailField.click();
        emailField.sendKeys(email);
        passwordField.click();
        passwordField.sendKeys(password);
        passwordField.submit();
    }


}
