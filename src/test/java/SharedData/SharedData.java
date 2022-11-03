 package SharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

 public class SharedData
{
     public WebDriver driver;

    @BeforeMethod
    public void prepareDriver()
    {
        //Trebuie sa setam driverul de Chrome.
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        // Accesam un anumit URL
        driver.get("https://demo.automationtesting.in/Index.html");

        //Facem browserul in modul Maximize.
        driver.manage().window().maximize();

        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /* @AfterMethod
    public void closeDriver()
    {
        driver.quit();
    } */



}
