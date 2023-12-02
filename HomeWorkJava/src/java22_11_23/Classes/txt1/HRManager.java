package java22_11_23.Classes.txt1;

public class HRManager extends Employee {


    public HRManager(String name, int age, String department, float salary) {
        super(name, age, department, salary);
    }
    int numberOfRecruitments;
    String [] candidateList;

    @Override
    public void work() {
        System.out.println("Put a stampe ");
    }

    @Override
    public void takeBreak() {
        System.out.println("Drink Coffee with Manager");
    }
}

