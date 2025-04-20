public class FullTimeStaffHire extends StaffHire {
    //Attributes
    private double Salary;
    private int WeeklyHours;
    
    // Constructor
    public FullTimeStaffHire(int NewVacancyNumber, String NewJobType,
    String NewStaffName, String NewjoinDate, String NewAppointedBy,
    boolean Newjoined, double NewSalary, int NewWeeklyHours) {
        // Call the constructor of StaffHire
        super(NewVacancyNumber, NewJobType, NewStaffName, NewjoinDate, 
        NewAppointedBy, Newjoined);
        this.Salary = NewSalary;
        this.WeeklyHours = NewWeeklyHours;
    }
    
    // getters and setters
    public double getSalary() {
        return Salary;
    }
    
    public void setSalary(double NewSalary) {
        if (getJoined()) {
            System.out.println("Cannot update salary after Staff has joined.");
        } else {
            this.Salary = NewSalary;
            System.out.println("Salary is updated successfully by HR.");
        }
    }
    public int getWeeklyHours() {
        return WeeklyHours;
    }
    
    public void setWeeklyHours(int NewWeeklyHours) {
      this.WeeklyHours = NewWeeklyHours;
      System.out.println("Weekly working hours are updated successfully.");
    }
    
    // Display method
    @Override
    public void display() {
        // Call the base class method
        super.display();
        System.out.println("Salary:" + Salary);
        System.out.println("WeeklyHours:" + WeeklyHours);
    }
}