import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class RunnerRegisterGoogle {
   private WebDriver driver;
    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?continue=https%3A%2F%2Fwww.google.com%2F%3Fgws_rd%3Dssl&hl=ru&dsh=S-1090403758%3A1582982738938823&gmb=exp&biz=false&flowName=GlifWebSignIn&flowEntry=SignUp");

    }

    @Test
    public void enterDataToInputAndSubmit() {
        WebElement nameField = waitForElementLocatedBy(driver, By.id("firstName"));
        nameField.sendKeys("Hanna");
        WebElement lastName = waitForElementLocatedBy(driver, By.id("lastName"));
        lastName.sendKeys("Surname");
        WebElement email = waitForElementLocatedBy(driver, By.id("username"));
        email.sendKeys("surnamehanna");
        WebElement password1 = waitForElementLocatedBy(driver, By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input"));
        password1.sendKeys("Admin-123");
        WebElement password2 = waitForElementLocatedBy(driver, By.name("ConfirmPasswd"));
        password2.sendKeys("Admin-123");
        WebElement btnSubmit = waitForElementLocatedBy(driver, By.id("accountDetailsNext"));
        btnSubmit.click();
       List<WebElement>  newp=driver.findElements(By.className("sfYUmb"));

        Assert.assertTrue(newp.size()>0);

    }
@Test(dependsOnMethods={"enterDataToInputAndSubmit"})
public void testTelField(){
    List<WebElement>  newphone=driver.findElements(By.className("whsOnd zHQkBf"));

    Assert.assertTrue(newphone.size()>0);
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by){
        return new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(by));
    }
    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
