package HelpMethods;

import org.openqa.selenium.WebDriver;

public class FrameMethods {
    public WebDriver driver;

    public FrameMethods(WebDriver driver){
        this.driver = driver;
    }

    public void switchFrame (String frame){
        driver.switchTo().frame(frame);
    }

    public void switchFrame (WebDriver ){
        driver.switchTo().frame();
    }

}
