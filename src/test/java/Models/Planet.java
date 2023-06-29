package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Planet {
    public Planet(WebElement planetElement) {
        this.planetElement = planetElement;
    }

    WebElement planetElement;

    public String getName(){
        return planetElement.findElement(By.className("name")).getText();
    }

    public void clickExplore(){
        planetElement.findElements(By.cssSelector("[type=button]"));
    }

    public Long getDistance() {
        WebElement element = planetElement.findElement(By.tagName("dl"));
        String distanceStr = element.findElement(By.className("distance")).getText().replaceAll("[^\\d.]", ""); //"[^\\d.]"
        Long distance = Long.parseLong(distanceStr);
        return distance;
    }
}
