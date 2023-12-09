package Java20_11_23.Classes.TransportFleetManagementSystem;

public class Driver {
    String nameDriver;
    int drivingExperience;
    Car car;

    public String getNameDriver() {
        return nameDriver;
    }

    public Driver(String nameDriver) {
        this.nameDriver = nameDriver;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public Car getCar() {
        return car;
    }



    public void assignCar(Car car) {
       this.car=(car);
    }
   public  void releaseCar(Car car){
        this.car=null;

   }

    @Override
    public String toString() {
        return "Driver{" +
                "nameDriver='" + nameDriver + '\'' +
                ", drivingExperience=" + drivingExperience +
                ", car=" + car +
                '}';
    }
}