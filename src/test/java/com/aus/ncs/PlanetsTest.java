package com.aus.ncs;

import Models.PlanetPage;
import Models.ToolBar;
import Strategies.DistanceMatchingStrategy;
import Strategies.NameMatchingStrategy;
import org.junit.jupiter.api.*;
import org.hamcrest.Matchers.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlanetsTest {

    WebDriver driver = getWebDriver();


    @BeforeEach
    public void setup(){
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");

    }

    @Test
    public void exploreEarth(){
        new ToolBar(driver).clickPlanetsTab();
        new PlanetPage(driver).getPlanet(planet -> planet.getName().equalsIgnoreCase("Earth")).clickExplore();
        new PlanetPage(driver).getPlanet(planet -> planet.getDistance() == (2871000000L));
        //String distance = new PlanetPage(driver).getPlanet("Uranus").getDistance();
        //assertEquals("2,871,000,000 km", distance);

    }

    private WebDriver getWebDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }

    @AfterEach
    public void afterAll(){
        driver.quit();
    }
}
