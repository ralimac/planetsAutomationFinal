package Strategies;

import Models.Planet;

public class NameMatchingStrategy implements MatchingStrategy{


    private final String name;

    public NameMatchingStrategy(String name) {
        this.name = name;
    }

    @Override
    public boolean match(Planet planet) {
        return planet.getName().equalsIgnoreCase(name);
    }
}
