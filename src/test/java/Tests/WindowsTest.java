package Tests;

import HelpMethods.ElementMethod;
import HelpMethods.PageMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementMethod elementMethod = new ElementMethod(driver);
        PageMethods
        WindowMethod

        //Click pe butonul Skip Sign IN
        WebElement skipSignIn = driver.findElement(By.id("btn2"));
        //skipSignIn.click();
        elementMethod.ClickElement(skipSignIn);

        WebElement switchToElement = driver.findElement(By.xpath("//a[text() = 'SwitchTo']"));
        Actions actiuni = new Actions(driver);
        actiuni.moveToElement(switchToElement).perform();

        WebElement windowsElement = driver.findElement(By.xpath("//a[text()='Windows']"));
        actiuni.moveToElement(windowsElement).perform();

        driver.navigate().to("https://demo.automationtesting.in/Windows.html");


        List<WebElement> windowOptions = driver.findElements(By.cssSelector(".nav-stacked>li>a"));
        windowOptions.get(0).click();

        WebElement clickSeleniumWeb = driver.findElement(By.cssSelector("#Tabbed button"));
        clickSeleniumWeb.click();

        System.out.println(driver.getTitle());
        ArrayList<String> tabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabList.get(1));
        System.out.println(driver.getTitle());
        driver.close(); // -> inchide tabul curent; quit inchide browserul

        driver.switchTo().window(tabList.get(0));
        windowOptions.get(1).click();

        WebElement clickSeleniumNewWindow = driver.findElement(By.cssSelector("#Seperate button"));
        clickSeleniumNewWindow.click();

        System.out.println(driver.getTitle());
        ArrayList<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        System.out.println(driver.getTitle());
        driver.close();

        driver.switchTo().window(tabList.get(0));
        windowOptions.get(2).click();

        WebElement clickSeleniumTwoWindows = driver.findElement(By.cssSelector("#Multiple button"));
        clickSeleniumTwoWindows.click();

        System.out.println(driver.getTitle());
        ArrayList<String> windowsList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(2));
        System.out.println(driver.getTitle());
        driver.close();

        driver.switchTo().window(windowsList.get(1));
        System.out.println(driver.getTitle());
        driver.close();

        driver.switchTo().window(windowsList.get(0));
        System.out.println(driver.getTitle());
    }
}
