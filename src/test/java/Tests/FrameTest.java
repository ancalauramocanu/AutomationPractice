package Tests;

import HelpMethods.ElementMethod;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class FrameTest extends SharedData {
    @Test
    public void metodaTest()
    {
        ElementMethod elementMethod = new ElementMethod();


    WebElement skipSignIn = driver.findElement(By.id("btn2"));
    //skipSignIn.click();
    elementMethod.ClickElement(skipSignIn);

    WebElement switchToElement = driver.findElement(By.xpath("//a[text() = 'SwitchTo']"));
    Actions actiuni = new Actions(driver);
    actiuni.moveToElement(switchToElement).perform();

    WebElement framesElement = driver.findElement(By.xpath("//a[text()='Frames']"));
    framesElement.click();

    driver.navigate().to("https://demo.automationtesting.in/Frames.html");

    List<WebElement> buttonList = driver.findElements(By.cssSelector(".nav-tabs a"));
    buttonList.get(0).click();

    driver.switchTo().frame("singleframe");
    WebElement inputElement = driver.findElement(By.cssSelector("input[type= 'text']"));
    inputElement.sendKeys("Ana are mere");

    driver.switchTo().defaultContent(); //revine la frameul initial

    buttonList.get(1).click();

    driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[scr='MultipleFrames.html']")));
    driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[scr='SingleFrame.html']")));


    WebElement inputElement2 = driver.findElement(By.cssSelector("input[type= 'text']"));
    inputElement2.sendKeys("Ana are mere");

}
}