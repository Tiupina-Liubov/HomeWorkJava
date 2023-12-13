package src.java22_11_23.Classes.TransportSystem;

public class Taxi extends Vehicle {
    String licensePlate;
    boolean available;

    public Taxi(String model, int capacity, double fare, String route, String licensePlate, boolean available) {
        super(model, capacity, fare, route);
        this.licensePlate = licensePlate;
        this.available = available;
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
