package Tests;

//import HelpMethods.ElementMethod;
import HelpMethods.ElementMethod;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterTest extends SharedData
{


    @Test
    public void metodaTest() {

        ElementMethod elementMethod = new ElementMethod(driver);

        //Click pe butonul Skip Sign IN
        WebElement skipSignIn = driver.findElement(By.id("btn2"));
        //skipSignIn.click();
        elementMethod.ClickElement(skipSignIn);

        //Adaugam text in field-ul First Name
        WebElement firstName = driver.findElement(By.cssSelector("input[ng-model='FirstName']"));
        String firstNameValue = "Anca";
        //firstName.sendKeys(firstNameValue);
        elementMethod.FillElement(firstName, firstNameValue);

        // Adaugam text in field-ul Last Name  //input[@ng-model='LastName']
        WebElement lastName = driver.findElement(By.xpath("//input[@ng-model='LastName']"));
        String lastNameValue = "Mocanu";
        //lastName.sendKeys(lastNameValue);
        elementMethod.FillElement(lastName, lastNameValue);

        //Skills este lista de selectie (are select in cod)
        WebElement skillsSelector = driver.findElement(By.id("Skills"));
        String skillsValue = "Java"; // element simplu
        //Select skillsSelect = new Select(skillsSelector); // ii zici ca e Select
        //skillsSelect.selectByVisibleText(skillsValue);
        elementMethod.SelectDropDownText(skillsSelector, skillsValue);

        //Year este lista de selectie (are select in cod) - select by value; merge si select by text ca la Skills
        WebElement yearSelector = driver.findElement(By.id("yearbox"));
        String yearValue = "1998";
        //Select yearSelect = new Select(yearSelector);
        //yearSelect.selectByValue(yearValue);
        elementMethod.SelectDropDownValue(yearSelector,yearValue);

        //Language este lista de selectie dar trebuie prima oara un click pe element; ar trebui identificate toate languages;
        WebElement languageElement = driver.findElement(By.id("msdd"));
        languageElement.click();
        //identific o multime de elemente - FindElements, cu s; in CSS cautare dupa clasa se face cu punct .
        List<WebElement> languageList = driver.findElements(By.cssSelector(".ui-autocomplete>li>a"));
        for(Integer index=0; index<languageList.size(); index++)
        {
            if (languageList.get(index).getText().equals("Estonian")) //iei elementul cu getText si iei valoare de pe element cu equals
            {
                languageList.get(index).click();
                break;
            }
        }

        //trebuie inchis un click pe langa ca sa iasa din lista -> mergem pe Gender
        WebElement genderElement = driver.findElement(By.cssSelector("input[value='FeMale']"));
        genderElement.click();

        //Select country - lista unde cauti si selectezi cu click si enter
        WebElement selectCountryElement = driver.findElement(By.cssSelector(".select2-selection--single"));
        selectCountryElement.click();

        WebElement selectCountryInput = driver.findElement(By.cssSelector(".select2-search__field"));
        selectCountryInput.sendKeys("Denmark");
        selectCountryInput.sendKeys(Keys.ENTER); //comanda din tastatura -> sa dea Enter

        //upload poza - sa fie Input si sa fie type File!! a vrut path absolut; nu a mers cu Path from content root
        WebElement fileElement = driver.findElement(By.id("imagesrc"));
        fileElement.sendKeys("C:\\Users\\anmocanu\\IdeaProjects\\AutomationProject\\src\\test\\resources\\imagine.jpg");



        // TEMA
        //adaugam adresa
        WebElement adresaElement = driver.findElement(By.xpath("//textarea"));
        String adresaValue = "Brasov Raului street 11A";
        adresaElement.sendKeys(adresaValue);

        //adaugam e-mail
        WebElement emailElement = driver.findElement(By.cssSelector("input[ng-model='EmailAdress']"));
        String emailValue = "abcd@gmail.com";
        emailElement.sendKeys(emailValue);

        //adaugam telefon
        WebElement phoneElement = driver.findElement(By.cssSelector("input[ng-model='Phone']"));
        String phoneValue = "0040789475";
        phoneElement.sendKeys(phoneValue);

        //check a hobby
        WebElement hobbyElement = driver.findElement(By.id("checkbox1"));
        hobbyElement.click();

        //Month
        WebElement monthSelector = driver.findElement(By.cssSelector("select[placeholder='Month']"));
        String monthValue = "January";
        Select monthSelect = new Select(monthSelector);
        monthSelect.selectByValue(monthValue);

        //Day
        WebElement daySelector = driver.findElement(By.id("daybox"));
        String dayValue = "17";
        Select daySelect = new Select(daySelector);
       daySelect.selectByValue(dayValue);

       //password
        WebElement passElement = driver.findElement(By.id("firstpassword"));
        String passValue = "abcd";
        passElement.sendKeys(passValue);

        //confirm password
        WebElement confirmPassElement = driver.findElement(By.id("secondpassword"));
        String confirmPassValue = "abcd";
        confirmPassElement.sendKeys(confirmPassValue);

    }

}
