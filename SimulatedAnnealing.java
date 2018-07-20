import java.util.Random;

public class SimulatedAnnealing {

    private Random random;
    private double currentCoordinateX, nextCoordinateX, bestCoordinateX;

    public SimulatedAnnealing() {
        this.random = new Random();
    }

    public double getEnergy(double x) {
        return f(x);
    }

    private double f(double x) {
        return ((x*x*x)) - (3*(x*x)) + 2;
    }

    public double acceptanceProbability(double energy, double newEnergy, double tempeture) {
        if( newEnergy < energy) {
            return 1;
        } else {
            return Math.exp((energy - newEnergy)) / tempeture;
        }
    }

    public void findOptimum() {
        double tempeture = Constants.getMaxTemperature();

        while (tempeture > Constants.getMinTemperature()) {
            nextCoordinateX = getRandomXCoordinate();

            double currentEnergy = getEnergy(currentCoordinateX);
            double newEnergy = getEnergy(nextCoordinateX);

            if(acceptanceProbability(currentEnergy, newEnergy, tempeture) > Math.random()) {
                currentCoordinateX = nextCoordinateX;
            }

            if(f(currentEnergy) < f(bestCoordinateX)) {
                bestCoordinateX = currentCoordinateX;
            }

            tempeture*=1-Constants.getCoolingRate();

        }

        System.out.println("Global extremum guess: x= " + bestCoordinateX + "where f(x)= " + f(bestCoordinateX));

    }


    public double getRandomXCoordinate() {
        return random.nextDouble()*(Constants.getMaxCoordinate()-Constants.getMinCoordinate()) + Constants.getMinCoordinate();
    }
}
