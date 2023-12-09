package java22_11_23.Classes.txt1;

public class Maneger extends Employee {
    int teamSize;
    String [] teamMembers=new String[teamSize] ;

    public Maneger(String name, int age, String department, float salary) {
        super(name, age, department, salary);
    }

    @Override
    public void work() {
        System.out.println(" Manager working");
    }

    @Override
    public void takeBreak() {
        System.out.println(" Drink Coffee");
    }
}
