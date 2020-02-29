package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.By.*;

public class RegistartionFirstStep {
    private WebDriver driver;
    @FindBy(id="firstName")
    WebElement nameField;
    @FindBy(id="lastName")
    WebElement lastName;
    @FindBy (id="username")
    WebElement email;
    @FindBy(xpath ="//*[@id=\"passwd\"]/div[1]/div/div[1]/input")
    WebElement password1;
    @FindBy(name="ConfirmPasswd")
    WebElement password2;
    @FindBy(id="accountDetailsNext")
    WebElement btnConfirm;


    public RegistartionFirstStep(WebDriver driver){
this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void setNameField(String nameFiel) {
        nameField.sendKeys(nameFiel);
    }
    public  void  setLastName(String lastFiel) {
        lastName.sendKeys(lastFiel);
    }
    public void setEmail(String emailU){
        email.sendKeys(emailU);
    }
    public void setPassword1(String password1U)
    {
        password1.sendKeys(password1U);
    }
    public void setPassword2(String password2U)
    {
        password2.sendKeys(password2U);
    }
    public void clickBtn(){
        btnConfirm.click();
    }
    public void sendNewUser(String name, String lastName, String email, String pass, String pass2){
        setNameField(name);
        setLastName(lastName);
        setEmail(email);
        setPassword1(pass);
        setPassword2(pass2);
        clickBtn();
    }
}
