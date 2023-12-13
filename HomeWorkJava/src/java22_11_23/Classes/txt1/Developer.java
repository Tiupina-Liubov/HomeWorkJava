package src.java22_11_23.Classes.txt1;

public class Developer extends Employee {
    String programmingLanguage;
    boolean remote;

    public Developer(String name, int age, String department, float salary) {
        super(name, age, department, salary);
    }

    @Override
    public void work() {
        if(remote==true){
            System.out.println("Home working");
        }

    }

    @Override
    public void takeBreak() {
        if(remote==false){
            System.out.println("Take a minute");
        }

    }
}
