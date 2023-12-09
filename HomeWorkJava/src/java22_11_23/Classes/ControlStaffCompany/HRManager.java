package java22_11_23.Classes.ControlStaffCompany;

public class HRManager extends Employee {

   private int numberOfRecruitments;
   private String [] candidateList;

    public HRManager(String name, int age, String department, float salary) {
        super(name, age, department, salary);
    }

    public int getNumberOfRecruitments() {
        return numberOfRecruitments;
    }

    public void setNumberOfRecruitments(int numberOfRecruitments) {
        this.numberOfRecruitments = numberOfRecruitments;
    }

    public String[] getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(String[] candidateList) {
        this.candidateList = candidateList;
    }

    @Override
    public void work() {
        System.out.println("Conducts an interview");
    }

    @Override
    public void takeBreak() {
        System.out.println("Taking a break now");
    }

}

