package Models;

import Strategies.MatchingStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlanetPage {
    private WebDriver driver;
    public PlanetPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<Planet> getPlanets(){
        List<Planet> planetList = new ArrayList<>();
        List<WebElement> planetElementList = driver.findElements(By.className("planet"));
        for (WebElement element: planetElementList){
            planetList.add(new Planet(element));
        }
        return planetList;
    }

    public Planet getPlanet(Predicate<Planet> strategy){
        for (Planet planet: getPlanets()){
            if(strategy.test(planet)){
                return planet;
            }
        }
        throw  new NotFoundException("Planet not found");
    }

}
