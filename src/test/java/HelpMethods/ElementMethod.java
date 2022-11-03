package HelpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

public class ElementMethod {

    public WebDriver driver;
    public ElementMethod(WebDriver driver){
        this.driver = driver;
    }

    //WAIT
    //2 feluri de wait-uri: implicit si explicit

    public void ClickElement(WebElement element){
        WaitVisibleElement(element);
        element.click();
    }

    public void WaitVisibleElement(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }

    public void FillElement(WebElement element, String value){
        WaitVisibleElement(element);
        element.sendKeys(value);
    }

    public void SelectDropDownText(WebElement element, String value){
        WaitVisibleElement(element);
        Select elementSelect = new Select(element);
        elementSelect.selectByVisibleText(value);
    }

    public void SelectDropDownValue(WebElement element, String value){
        WaitVisibleElement(element);
        Select elementSelect = new Select(element);
        elementSelect.selectByValue(value);
    }

    public void ValidateElementMessage(WebElement element, String value){
        WaitVisibleElement(element);
        String actualMessage = element.getText();
        Assert.assertEquals(actualMessage, value, "Textul de pe element nu e corect");
    }

    public void MovetoElement(){
        WaitVisibleElement(Ex);
    }





}
