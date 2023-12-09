package src.Java20_11_23.Classes.TransportFleetManagementSystem;

public class Fleet {
    String nameFleet;
    String addressFleet;
    FleetManager[] fleetManagersFleet= new FleetManager[20];

    public Fleet(String nameFleet) {
        this.nameFleet = nameFleet;
    }

    public String getNameFleet() {
        return nameFleet;
    }

    public String getAddressFleet() {
        return addressFleet;
    }

    public void setAddressFleet(String addressFleet) {
        this.addressFleet = addressFleet;
    }

    public FleetManager[] getFleetManagersFleet() {
        return fleetManagersFleet;
    }

    public void setFleetManagersFleet(FleetManager[] fleetManagersFleet) {
        this.fleetManagersFleet = fleetManagersFleet;
    }

    public void addFleetManager(FleetManager fleetManager){
        for (int i = 0; i < fleetManagersFleet.length; i++) {
            if(fleetManagersFleet[i]==null){
                fleetManagersFleet[i]=fleetManager;
                break;
            }
        }
    }
    public void removeFleetManager(FleetManager fleetManager){
        for (int i = 0; i < fleetManagersFleet.length; i++) {
            if(fleetManagersFleet[i]==fleetManager){
                fleetManagersFleet[i]=null;
                break;
            }
        }
    }
    public void searchManagerName(String nameFleetManager) {
        FleetManager fleetManager1=new FleetManager(null);
        for (int i = 0; i < fleetManagersFleet.length; i++) {
            if (fleetManagersFleet[i].nameManager == nameFleetManager) {
                System.out.println(fleetManagersFleet[i]);
                break;
            }
        }
    }

}
