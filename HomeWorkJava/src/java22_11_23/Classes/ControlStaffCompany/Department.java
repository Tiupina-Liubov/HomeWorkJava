package java22_11_23.Classes.ControlStaffCompany;


public class Department implements DepartmentOperations{
    private String departmentName;
    private Employee[] employees;

    private int currentSize=0;
    private int maxSize = 10;

    public Department(String departmentName, int currentSize) {
        this.departmentName = departmentName;
        this.currentSize = currentSize;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Employee[] getEmployee(Employee[] employees) {
        return employees;
    }

    public void setEmployee(Employee[] employees) {
        this.employees = employees;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void addEmployee(Employee employee) {
        int length = maxSize;
        for (int i = 0; i < length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                currentSize+=1;
                break;
            }
        }
    }

    @Override
    public Employee findEmployee(String name) {
        int length = currentSize;
        Employee employee = null;
        for (int i = 0; i < length; i++) {
            if (employees[i].getName().equalsIgnoreCase(name)) {
                employee= employees[i] ;
                break;
            }
        }
        return employee;
    }

    @Override
    public void removeEmployee(String name) {
        int length = currentSize;
        Employee employee = null;
        for (int i = 0; i < length; i++) {
            if (employees[i].getName().equalsIgnoreCase(name)) {
                employees[i]=null;
                currentSize-=1;
                break;
            }
        }
    }
}