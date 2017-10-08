import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;





public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void waitElement(WebElement element, int period) {
        new WebDriverWait(driver, period).until((ExpectedConditions.visibilityOf(element)));
    }


    public void checkPage(String pageTitle, int period) {
        new WebDriverWait(driver, period).until((ExpectedConditions.titleContains(pageTitle)));
        Assert.assertEquals(driver.getTitle(), pageTitle);
    }

    public boolean assertForAll(String expectedError, WebElement element) {
        waitElement(element, 5);
        String errorFieldText = element.getText();
        if (!errorFieldText.contains(expectedError)) {
            String errorMessage = String.format(
                    "Expected result: %s , not found. Actual error field value: %s",
                    expectedError,
                    errorFieldText);
            throw new AssertionError(errorMessage);
        }
        return false;
    }


}
