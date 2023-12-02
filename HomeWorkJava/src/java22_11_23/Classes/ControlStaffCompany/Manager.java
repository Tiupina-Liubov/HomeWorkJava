package java22_11_23.Classes.ControlStaffCompany;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;

public class Manager extends Employee {
    int teamSize;
    String[] teamMembers = new String[teamSize];

    public Manager(String name, int age, String department, float salary) {
        super(name, age, department, salary);

    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public String[] getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(String[] teamMembers) {
        this.teamMembers = teamMembers;
    }

    @Override
    public void work() {

            System.out.println("Be in the office");

    }

    @Override
    public void takeBreak() {
        System.out.println("Taking a break now");
    }
}
