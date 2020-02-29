package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Runner {
    private WebDriver driver;
    RegistartionFirstStep registartionFirstStep;
    RegistrationSecondStep registrationSecondStep;
    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?continue=https%3A%2F%2Fwww.google.com%2F%3Fgws_rd%3Dssl&hl=ru&dsh=S-1090403758%3A1582982738938823&gmb=exp&biz=false&flowName=GlifWebSignIn&flowEntry=SignUp");
        registartionFirstStep=new RegistartionFirstStep(driver);
        registartionFirstStep.sendNewUser("Hanna","Surname","surnamehanna",
                "Admin-123","Admin-123");
        registrationSecondStep=new RegistrationSecondStep(driver);
    }

    @Test
    public void enterDataToInputAndSubmit() {
        Assert.assertTrue(registrationSecondStep.getsizeNewP()>0);
    }
//    @Test
//    public void secondField() {
//        Assert.assertTrue(registrationSecondStep.getSizeNewPhone()>0);
//    }
}
