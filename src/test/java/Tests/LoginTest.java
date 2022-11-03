package Tests;

//import HelpMethods.ElementMethod;
import HelpMethods.ElementMethod;
import HelpMethods.PageMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    public WebDriver driver;

    @Test
    public void metodaTest()
    {
        ElementMethod elementMethod = new ElementMethod((driver));
        PageMethods pageMethods = new PageMethods(driver);

        //Trebuie sa setam driverul de Chrome.
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        // Accesam un anumit URL
        driver.get("https://demo.automationtesting.in/Index.html");

        // Validam o anumita pagina
        String signInTitlu = "Index";
        //Assert.assertEquals(driver.getTitle(), signInTitlu, "Titlul este diferit");
        pageMethods.ValidatePageTitle(signInTitlu);

        //Facem browserul in modul Maximize.
        driver.manage().window().maximize();

        //Identificam un element
        WebElement signInElement = driver.findElement(By.id("btn1"));
        //signInElement.click();
        elementMethod.ClickElement(signInElement);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue="mail@mail.com";
        //emailElement.sendKeys(emailValue);
        elementMethod.FillElement(emailElement,emailValue);

        WebElement passElement = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passValue="passwordabcd";
        passElement.sendKeys(passValue);


        WebElement enterElement = driver.findElement(By.id("enterbtn"));
        enterElement.click();

        WebElement errorElement = driver.findElement(By.id("errormsg"));
        String expectedMessage = "Invalid User Name or PassWord";
        //String actualMessage = errorElement.getText();
        //Assert.assertEquals(actualMessage,expectedMessage, "Textul de pe element nu e corect.");
        elementMethod.ValidateElementMessage(errorElement, expectedMessage);

        // Inchide toate taburile
        driver.quit();
        //Inchide tabul curent
        driver.close();

    }




}
