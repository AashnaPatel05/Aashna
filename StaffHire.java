public class StaffHire {
    private int VacancyNumber;
    private String JobType;
    private String StaffName;
    private String joinDate;
    private String AppointedBy;
    private boolean joined;
    
    //Constructor
    public StaffHire(int NewVacancyNumber,String NewJobType, String NewStaffName,
    String NewjoinDate,
    String NewAppointedBy,boolean join)
    {
        this.VacancyNumber = NewVacancyNumber;
        this.JobType =  NewJobType; 
        this.StaffName = NewStaffName;
        this.joinDate = NewjoinDate;
        this.AppointedBy = NewAppointedBy;
        this.joined = false;
    
    }
        
    //getter and setter methods
    public int getVacancyNumber() {
        return VacancyNumber;
    }
    
    public void setCVacancyNumber(int NewVacancyNumber) {
        this.VacancyNumber = NewVacancyNumber;
    }
    
    public String getStaffName() {
        return StaffName;
    }
    
    public void setStaffName(String NewStaffName) {
        this.StaffName = NewStaffName;
    }
    
    public String getJobType() {
        return JobType;
    }
    
    public void setJobType(String NewjobType) {
        this.JobType = NewjobType;
    }
    
    public String getJoinDate() {
        return joinDate;
    }
    
    public void setJoinDate(String NewjoinDate) {
        this.joinDate = NewjoinDate;
    }
    
    public String getAppointedBy() {
        return AppointedBy;
    }
    
    public void setAppointedBy(String NewAppointedBy) {
        this.AppointedBy = NewAppointedBy;
    }
    
    public boolean getJoined() {
        return joined;
    }
    
    public void setJoined(boolean Newjoined) {
        this.joined = Newjoined;
    }
    
    //Display method
    public void display() {
        System.out.println("Vacancy Number:" + VacancyNumber);
        System.out.println("Job Type:" + JobType);
        System.out.println("Staff Name:"+ StaffName);
        System.out.println("Join Date:"+ joinDate);
        System.out.println("AppointedBy:" + AppointedBy);
        System.out.println("Joined:" + joined);
    }
}  