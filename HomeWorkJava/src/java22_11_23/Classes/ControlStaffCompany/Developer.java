import java22_11_23.Classes.ControlStaffCompany.Employee;

public class Developer extends Employee {
    String programmingLanguage;
    boolean remote;

    public Developer(String name, int age, String department, float salary, String programmingLanguage, boolean remote) {
        super(name, age, department, salary);
        this.programmingLanguage = programmingLanguage;
        this.remote = remote;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }


    @Override
    public void work() {
        if(remote==true){
            System.out.println("Developer works from home");
        }else{
            System.out.println("Developer works from office");
        }


    }

    @Override
    public void takeBreak() {
        if(remote==true){
            System.out.println("Developer is offline. Took a break");
        }else{
            System.out.println("Taking a break now");
        }

    }
}


