package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolBar {
    WebDriver driver;
    public ToolBar(WebDriver driver) {
        this.driver = driver;
    }


    public void clickPlanetsTab(){
        driver.findElement(By.cssSelector("[aria-label=planets]")).click();
    }
}
