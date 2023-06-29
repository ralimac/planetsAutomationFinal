package Strategies;

import Models.Planet;

public class DistanceMatchingStrategy implements MatchingStrategy{

    private long distance;

    public DistanceMatchingStrategy(long distance) {
        this.distance = distance;
    }

    @Override
    public boolean match(Planet planet) {
        return planet.getDistance() == distance;
    }
}
