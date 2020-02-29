package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegistrationSecondStep {
    WebDriver driver;
    @FindBy(className="sfYUmb")
    List<WebElement> newp;
    @FindBy(className="whsOnd zHQkBf")
    List<WebElement> newphone;

    public RegistrationSecondStep(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public int getsizeNewP(){
        return newp.size();
    }
    public int getSizeNewPhone(){
        return newphone.size();
    }
    private static WebElement waitForElementLocatedBy(WebDriver driver, By by){
        return new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
