package src.java22_11_23.Classes.TransportSystem;

public class Tram extends Vehicle{
    int trackWidth;
    boolean electric;

    public Tram(String model, int capacity, double fare, String route, int trackWidth, boolean electric) {
        super(model, capacity, fare, route);
        this.trackWidth = trackWidth;
        this.electric = electric;
    }

    @Override
    void stop() {

    }

    @Override
    void drive() {

    }

    @Override
    void landingPassenger() {

    }

    @Override
    void disembarkationPassenger() {

    }
}
