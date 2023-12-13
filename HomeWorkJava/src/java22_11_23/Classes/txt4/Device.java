package src.java22_11_23.Classes.txt4;

import java.time.LocalDateTime;

public abstract class Device implements ControlInterface{
    private String deviceId;
    private String location;
    private boolean isOn;
    LocalDateTime lastChecked;

    public Device(String deviceId, String location, boolean isOn, LocalDateTime lastChecked) {
        this.deviceId = deviceId;
        this.location = location;
        this.isOn = isOn;
        this.lastChecked = lastChecked;
    }
}
