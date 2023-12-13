package src.java22_11_23.Classes.TransportSystem;

public class Bus extends Vehicle{

    private boolean accessibility;
    private int busNumber;

    public Bus(String model, int capacity, double fare, String route, boolean accessibility, int busNumber) {
        super(model, capacity, fare, route);
        this.accessibility = accessibility;
        this.busNumber = busNumber;
    }

    @Override
    void stop(
    ) {

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
