package src.java22_11_23.Classes.txt4;

import java.time.LocalDateTime;

public class Lighting extends Device{
   private int brightnessLevel;
   private String colorTemperature;

    public Lighting(String deviceId, String location, boolean isOn, LocalDateTime lastChecked, int brightnessLevel, String colorTemperature) {
        super(deviceId, location, isOn, lastChecked);
        this.brightnessLevel = brightnessLevel;
        this.colorTemperature = colorTemperature;
    }

    public int getBrightnessLevel() {
        return brightnessLevel;
    }

    public void setBrightnessLevel(int brightnessLevel) {
        this.brightnessLevel = brightnessLevel;
    }

    public String getColorTemperature() {
        return colorTemperature;
    }

    public void setColorTemperature(String colorTemperature) {
        this.colorTemperature = colorTemperature;
    }
    public void lightingControl(int brightnessLevelPerson,String colorTemperaturePerson){
        setBrightnessLevel(brightnessLevelPerson);
        setColorTemperature(colorTemperaturePerson);
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
