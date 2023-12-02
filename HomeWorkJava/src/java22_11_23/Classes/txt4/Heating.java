package java22_11_23.Classes.txt4;

import java.time.LocalDateTime;

public class Heating extends Device {
    private double currentTemperature;
    private double targetTemperature;

    public Heating(String deviceId, String location, boolean isOn, LocalDateTime lastChecked, double targetTemperature) {
        super(deviceId, location, isOn, lastChecked);
        this.targetTemperature = targetTemperature;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }
    public boolean TurnHeating( double currentTemperature){
        boolean turnHeating=false;
        if(currentTemperature<targetTemperature){
            turnHeating=true;
        }
        return turnHeating;
    }
    public boolean TurnOffHeating( double currentTemperature){
        boolean turnHeating=false;
        if(currentTemperature>targetTemperature){
            turnHeating=true;
        }
        return turnHeating;
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public String getStatus() {
        return null;
    }
}