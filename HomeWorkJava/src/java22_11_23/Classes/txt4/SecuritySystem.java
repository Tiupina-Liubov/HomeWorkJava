package src.java22_11_23.Classes.txt4;

import java.time.LocalDateTime;

public class SecuritySystem extends Device implements Security,ControlInterface{
    private boolean isArmed;
    private String[] accessCodes;

    public SecuritySystem(String deviceId, String location, boolean isOn, LocalDateTime lastChecked) {
        super(deviceId, location, isOn, lastChecked);
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

    @Override
    public boolean armSystem(String code) {
        return false;
    }

    @Override
    public boolean disarmSystem(String code) {
        return false;
    }

    //
}
