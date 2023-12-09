package Java20_11_23.Classes.TransportFleetManagementSystem;


import java.util.Arrays;

public class Car {
    String make;
    String model;

    int yearOfManufacture;
    boolean technicalInspection;

    public Car(String make, String model, int yearOfManufacture) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setTechnicalInspection(boolean technicalInspection) {
        this.technicalInspection = technicalInspection;
    }

    public String carInformation() {
        return "Car" +
                "\nMake = " + make + "\nModel = " + model +
                " \nYear of manufacture = " + yearOfManufacture;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", technicalInspection=" + technicalInspection +
                '}';
    }

    public static void technicalInspection(Car car) {
        if (car.technicalInspection == true) {
            System.out.println("Technical inspection passed. Everything is fine!");
        } else {
            System.out.println("Technical inspection failed.");
        }

    }

}

