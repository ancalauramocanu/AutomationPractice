package HelpMethods;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WindowMethods {
    public WebDriver driver;
    public WindowMethod(WebDriver driver){
        this.driver = driver;
    }

    public void switchSpecificWindow(Integer index){
        ArrayList<String> tabList = new ArrayList<>(driver.getWindowHandles());

    }

    public void CloseWindow(Integer index){
        driver.close();
    }

}
