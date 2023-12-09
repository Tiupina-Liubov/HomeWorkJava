package Java20_11_23.Classes.TransportFleetManagementSystem;

import java.util.Arrays;

public class FleetManager {
    String nameManager;
    Car[] listCars = new Car [20];
    Driver[]listDrivers;
    public FleetManager(String nameManager) {
        this.nameManager = nameManager;
    }

    public String getNameManager() {
        return nameManager;
    }

    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }

    public Car[] getListCars() {
        return listCars;
    }

    public void setListCars(Car[] listCars) {
        this.listCars = listCars;
    }

    public Driver[] getListDrivers() {
        return listDrivers;
    }

    public void setListDrivers(Driver[] listDrivers) {
        this.listDrivers = listDrivers;
    }

    public void addCarToFleet(Car car, Car [] listCars){
        for (int i = 0; i < listCars.length; i++) {
            if(listCars[i]==null){
                listCars[i]=car;
                break;
            }
        }
    }
    public void removeСarFromFleet(Car car, Car [] listCars){
        for (int i = 0; i < listCars.length; i++) {
            if(listCars[i]==car){
                listCars[i]=null;
                break;
            }
        }
    }
    public void assignCarDriver(Driver driver, Car car){
        driver.assignCar(car);
    }
    public void releaseCarDriver(Driver driver, Car car){
        driver.releaseCar(car);
    }

    @Override
    public String toString() {
        return "FleetManager" +
                "\nNameManager= " + nameManager  +"\nListCars=" + Arrays.toString(listCars) +
                " \nListDrivers=" + Arrays.toString(listDrivers);

    }
}
