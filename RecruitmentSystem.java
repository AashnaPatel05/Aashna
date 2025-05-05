import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecruitmentSystem {
    private JFrame frame;
    private ArrayList<StaffHire> StaffList;
    
    //GUI components
    private JTextField txtVacancyNumber, txtJobType, txtStaffName, txtjoinDate,
            txtAppointedBy, txtSalary, txtWeeklyHours, txtWorkingHours,
            txtWagesPerHour, txtshifts;
            
    private JTextField txtTerminateNumber;
    private JTextField txtDisplayNumber;
    
    public RecruitmentSystem() {
        StaffList = new ArrayList<>();
        frame = new JFrame("Recruitment System");
        frame.setSize(500,600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // --- Labels and Text Fields ---
        addLabel("Vacancy Number:", 40, 60);
        txtVacancyNumber = addTextField(150, 60);
        
        addLabel("Job Type:", 40, 100);
        txtJobType = addTextField(150, 100);
        
        addLabel("Staff Name:", 40, 140);
        txtStaffName = addTextField(150, 140);
        
        addLabel("join Date:",40, 180);
        txtjoinDate = addTextField(150, 180);
        
        addLabel("Appointed By:", 40, 220);
        txtAppointedBy = addTextField(150, 220);
        
        addLabel("Salary:", 400, 20);
        txtSalary = addTextField(520, 20);
        
        addLabel("Weekly Hours:", 400, 60);
        txtWeeklyHours = addTextField(520, 60);
        
        addLabel("Working Hours:", 400, 100);
        txtWorkingHours = addTextField(520, 100);
        
        addLabel("Wages Per Hour:", 400, 140);
        txtWagesPerHour = addTextField(520, 140);
        
        addLabel("shifts:", 400, 180);
        txtshifts = addTextField(520, 180);
        
        addLabel("Terminate Vacancy #:", 400, 220);
        txtTerminateNumber = addTextField(520, 220);
        
        addLabel("Display Index:", 400, 260);
        txtDisplayNumber = addTextField(520, 260);
        
        // --- Buttons ---
        addButton("Add Full Time Staff", 20, 320, e -> addFullTimeStaff());
        addButton("Add Part Time Staff", 200, 320, e -> addPartTimeStaff());
        addButton("Set Salary", 400, 320, e -> setFullTimeSalary());
        addButton("Set shifts", 20, 360, e -> setPartTimeshifts());
        addButton("Terminate", 200, 360, e -> terminatePartTimeStaff());
        addButton("Display All", 400, 360, e -> displayAllStaff());
        addButton("Clear All Fields", 400, 400, e -> clearAllFields());
        frame.setVisible(true);
    }
    
    private void addLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, 120, 25);
        frame.add(lbl);
    }
    
    private JTextField addTextField(int x, int y) {
        JTextField txt = new JTextField();
        txt.setBounds(x, y, 150, 25);
        frame.add(txt);
        return txt;
    }
    
    private void addButton(String text, int x, int y, ActionListener action) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 160, 30);
        btn.addActionListener(action);
        frame.add(btn);
    }
    
    // --- Action Methods ---
    private void addFullTimeStaff() {
        try{
            int vacNum = Integer.parseInt(txtVacancyNumber.getText());
            String JobType = txtJobType.getText();
            String name = txtStaffName.getText();
            String Date = txtjoinDate.getText();
            String appointBy = txtAppointedBy.getText();
            boolean joined = true;
            double Salary = Double.parseDouble(txtSalary.getText());
            int WeeklyHours = Integer.parseInt(txtWeeklyHours.getText());
            
            FullTimeStaffHire fullTime = new FullTimeStaffHire(
             vacNum, JobType, name, Date, appointBy, joined, Salary, 
             WeeklyHours);
             StaffList.add(fullTime);
             JOptionPane.showMessageDialog(frame, "Full-Time staff is added successfully.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: Please enter Valid Data.");
        }
    }
    
    private void addPartTimeStaff() {
        try{
            int vacNum = Integer.parseInt(txtVacancyNumber.getText());
            String JobType = txtJobType.getText();
            String name = txtStaffName.getText();
            String Date = txtjoinDate.getText();
            String appointBy = txtAppointedBy.getText();
            boolean joined = true;
            int WorkHour = Integer.parseInt(txtWorkingHours.getText());
            double wage = Double.parseDouble(txtWagesPerHour.getText());
            String shift = txtshifts.getText();
            
            PartTimeStaffHire partTime = new PartTimeStaffHire(
               vacNum, JobType, name, Date, appointBy, joined, WorkHour, wage,
               shift);
               StaffList.add(partTime);
               JOptionPane.showMessageDialog(frame, "Part-Time staff is added successfully.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: Please enter valid Data.");
        }
    }
    
    private void setFullTimeSalary() {
        try {
            int vacNum = Integer.parseInt(txtVacancyNumber.getText());
            double newSalary = Double.parseDouble(txtSalary.getText());
            for (StaffHire s : StaffList) {
                if (s instanceof FullTimeStaffHire && s.getVacancyNumber() == vacNum) {
                    ((FullTimeStaffHire) s).setSalary(newSalary);
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "salary updated successfully for Full-Time staff.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input for salary.");
        }
    }
    
    private void setPartTimeshifts() {
        try {
            int vacNum = Integer.parseInt(txtVacancyNumber.getText());
            String newshift = txtshifts.getText();
            for (StaffHire s : StaffList) {
                if (s instanceof PartTimeStaffHire && s.getVacancyNumber() == vacNum) {
                    ((PartTimeStaffHire) s).setshifts(newshift);
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "shifts updated successfully for Part-Time Staff.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Input");
        }
    }
    
        private void terminatePartTimeStaff() {
        try {
                int vacNum = Integer.parseInt(txtTerminateNumber.getText());
                for (StaffHire s : StaffList) {
                    if (s instanceof PartTimeStaffHire && s.getVacancyNumber() == vacNum) {
                        ((PartTimeStaffHire) s).terminateStaff();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(frame, "Part-Time staff terminated successfully.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input.");
            }
    }
    
    private void displayAllStaff() {
        for (StaffHire s : StaffList) {
            System.out.println("------ Staff Details ------");
            s.display();
            System.out.println("--------------------------\n");
        }
    }
    private void clearAllFields() {
        txtVacancyNumber.setText("");
        txtJobType.setText("");
        txtStaffName.setText("");
        txtjoinDate.setText("");
        txtAppointedBy.setText("");
        txtSalary.setText("");
        txtWeeklyHours.setText("");
        txtWorkingHours.setText("");
        txtWagesPerHour.setText("");
        txtshifts.setText("");
        txtTerminateNumber.setText("");
        txtDisplayNumber.setText("");
    }
    
    public static void main(String[] args) {
        new RecruitmentSystem();
    }
}
