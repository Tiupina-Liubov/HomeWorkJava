package src.java22_11_23.Classes.txt4;

import java.time.LocalDateTime;

public class SmartHome {
    private String homeName;
    private Device[] devices;
    private boolean isAwayMode;
    LocalDateTime lastUpdate;
  public boolean openHome(){
     if(isAwayMode=false){
         isAwayMode=true;
     }
      return isAwayMode;
  }
}
