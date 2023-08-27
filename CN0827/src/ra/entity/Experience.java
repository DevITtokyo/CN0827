package ra.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Experience extends Employee{
    private int expInYear;
    private String proSkill;
    public Experience() {
    }
    public Experience(String id, String fullName, String email, String phone, String employeeType, Date birthDay, int employeeCount, String certificate, int expInYear, String proSkill) {
        super(id, fullName, email, phone, employeeType, birthDay, employeeCount, certificate);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }
    public int getExpInYear() {
        return expInYear;
    }
    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }
    public String getProSkill() {
        return proSkill;
    }
    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
    @Override
    public void inputData(Scanner scanner, List<Employee> employeeList) throws ParseException {
        super.inputData(scanner, employeeList);
        System.out.print("Nhập vào số năm kinh nghiệm: ");
        expInYear = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập vào kĩ năng : ");
        proSkill = scanner.nextLine();
    }
    public void showInfo() {
        System.out.println("Mã nhân viên: " + getId());
        System.out.println("Tên nhân viên: " + getFullName());
        System.out.println("Birth Day: " + getBirthDay());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Employee Type: Experience");
        System.out.println("Số năm kinh nghiệm : " + expInYear);
        System.out.println("Kĩ năng chuyên nghiệp: " + proSkill);
//        System.out.println("Chứng chỉ :");
        // Display certificates information
//        for (Certificate certificate : certificatesList) {
//            certificate.displayInfo();
//        }
    }
}
