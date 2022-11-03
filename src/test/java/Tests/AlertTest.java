package Tests;

import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AlertTest extends SharedData
{
    @Test
    public void metodaTest()
    {
        //Click pe butonul Skip Sign IN -> sa fim pe pagina de Register, eram in Index
        WebElement skipSignIn = driver.findElement(By.id("btn2"));
        skipSignIn.click();

        //text scris intre > < inseamna ca e hardcodat, ne putem folosi de el, de ex: >SwitchTo<
        // trebuie citit doar cu Xpath
        //movetoElement - Actions - ajungem in meniul Switch
        WebElement switchToElement = driver.findElement(By.xpath("//a[text() = 'SwitchTo']")); //-> chemi o metoda text()
        Actions actiuni = new Actions(driver); //
        actiuni.moveToElement(switchToElement).perform(); //dupa ce e aleasa actiune, ii zicem si Perform
        //dam click pe Alerts din meniul Switch
        WebElement alertElement = driver.findElement(By.xpath("//a[text()='Alerts']"));
        alertElement.click();
        //A aparut o reclama, este greu de interactionat cu ea asa ca redirectam catre pagina pentru a putea continua testele
        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
        //sa accesezi URL: get asteapta ca pagina sa se incarce SAU navigate - nu asteapta ca pagina sa se incarce

    }

}
