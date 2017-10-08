import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class Initialization {

    private static final String URL_ROZETKA = "https://my-sandbox.maxpay.com/#/signin";

    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void before() {
        driver.get(URL_ROZETKA);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(25, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public void after() {
        driver.close();
        driver.quit();
    }
}

