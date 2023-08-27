package ra.entity;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Fresher extends Employee {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    public Fresher(String id, String fullName, String email, String phone, String employeeType, Date birthDay, int employeeCount, String certificate, String graduationDate, String graduationRank, String education) {
        super(id, fullName, email, phone, employeeType, birthDay, employeeCount, certificate);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void inputData(Scanner scanner, List<Employee> employeeList) throws ParseException {
        super.inputData(scanner, employeeList);
        System.out.print("Ngày tốt nghiệp: ");
        graduationDate = scanner.nextLine();

        System.out.print("Xếp hạng tốt nghiệp: ");
        graduationRank = scanner.nextLine();

        System.out.print("Trình độ học vấn: ");
        education = scanner.nextLine();
    }

    @Override
    public void showInfo() {
        System.out.println("Mã nhân viên: " + getId());
        System.out.println("Tên nhân viên: " + getFullName());
        System.out.println("Birth Day: " + getBirthDay());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Employee Type: Fresher");
        System.out.println("Ngày tốt nghiệp : " + graduationDate);
        System.out.println("Xếp hạng tốt nghiệp : " + graduationRank);
        System.out.println("Trình độ học vấn : " + education);
        System.out.println("Chứng chỉ :");

//        for (Certificate certificate : certificatesList) {
//            certificate.displayInfo();
//        }
    }
}
