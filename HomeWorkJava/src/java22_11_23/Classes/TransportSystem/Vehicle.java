package src.java22_11_23.Classes.TransportSystem;

public abstract class Vehicle {
   String model;
    int capacity;
    double fare;
    String route;

    public Vehicle(String model, int capacity, double fare, String route) {
        this.model = model;
        this.capacity = capacity;
        this.fare = fare;
        this.route = route;
    }

    abstract void stop();
    abstract void drive();
    abstract void landingPassenger();
    abstract void disembarkationPassenger();
}

