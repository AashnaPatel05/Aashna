public class PartTimeStaffHire extends StaffHire {
    //Attributes
    private int WorkingHours;
    private double WagesPerHour;
    private String shifts;
    private boolean terminated;
    
    //Constructor
    public PartTimeStaffHire(int NewVacancyNumber, String NewJobType,
    String NewStaffName,
    String NewjoinDate, String NewAppointedBy, boolean Newjoined,
    int NewWorkingHours, double NewWagesPerHour,String Newshifts) {
        super(NewVacancyNumber, NewJobType, NewStaffName, NewjoinDate,
        NewAppointedBy, Newjoined);
        this.WorkingHours = NewWorkingHours;
        this.WagesPerHour = NewWagesPerHour;
        this.shifts = Newshifts;
        this.terminated = false;   // default
        
    }
    
    //getters and setters
    public int getworkingHours() {
        return WorkingHours;
    }
    
    public void setWorkingHours(int NewWorkingHours) {
        this.WorkingHours = NewWorkingHours;
    }
    
    public double getWagesPerHour() {
        return WagesPerHour;
    }
    
    public void setWagesPerHour(double NewWagesPerHour) {
        this.WagesPerHour = NewWagesPerHour;
    }
    
    public String getshifts() {
        return shifts;
    }
    
    public void setshifts(String Newshifts) {
        if (getJoined()) {
            this.shifts = Newshifts;
            System.out.println("shifts updated to:" + shifts);
        } else {
            System.out.println("cannot change shift.staff has not joined");
        }
    }
    
    public boolean isTerminated() {
        return terminated;
    }
    
    public void terminateStaff() {
        if (terminated) {
            System.out.println("Staff is already terminated by Hiring manager");
        } else {
            // Clear all personal data and update status
            setStaffName("John");
            setJoinDate("14-04-2025");
            setAppointedBy("Hiring Manager");
            setJoined(false);
            this.terminated = true;
            System.out.println("Staff are terminated");
        }
    }
    
    //Display method
    @Override
    public void display() {
        super.display(); //base display
        System.out.println("Working Hours:" + WorkingHours);
        System.out.println("Wages Per Hour:" + WagesPerHour);
        System.out.println("Shifts:" + shifts);
        System.out.println("Terminated:" + terminated);
        System.out.println("Daily Income:" + (WorkingHours * WagesPerHour));
    }
}
