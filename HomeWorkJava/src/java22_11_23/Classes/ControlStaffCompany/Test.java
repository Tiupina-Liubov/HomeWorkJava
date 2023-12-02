package java22_11_23.Classes.ControlStaffCompany;

public class Test {
    public static void main(String[] args) {
        Manager manager = new Manager("Liubov", 30, "Manager", 13.5f);
        manager.work();
        manager.takeBreak();
        Developer developer = new Developer("Lili", 24, "Developer", 3000, "Java", true);
        Developer developer1 = new Developer("Lili", 24, "Developer", 3000, "Java", false);
        developer.work();
        developer1.work();
        developer.takeBreak();
        HRManager hrManager = new HRManager("Liubov", 30, "Manager", 13000);
        hrManager.work();
        hrManager.takeBreak();
        Department department=new Department("Manager",30);


    }
}
