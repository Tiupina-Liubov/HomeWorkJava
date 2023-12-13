package src.java22_11_23.Classes.ControlStaffCompany;

public interface DepartmentOperations {
    default void addEmployee(Employee employee){}

    default Employee findEmployee(String name){
        Employee employee = null;
        return null;
    }
    default void removeEmployee(String name){}
}
