package ra.entity;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Intern extends Employee{
    private String majors;
    private String semester;
    private String universityName;
    public Intern() {
    }
    public Intern(String id, String fullName, String email, String phone, String employeeType, Date birthDay, int employeeCount, String certificate, String majors, String semester, String universityName) {
        super(id, fullName, email, phone, employeeType, birthDay, employeeCount, certificate);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }
    @Override
    public void inputData(Scanner scanner, List<Employee> employeeList) throws ParseException {
        super.inputData(scanner, employeeList);
        System.out.print("Chuyên ngành : ");
        majors = scanner.nextLine();

        System.out.print("Học kỳ: ");
        semester = scanner.nextLine();

        System.out.print("Nhập tên trường đại học: ");
        universityName = scanner.nextLine();

    }
    public void showInfo(){
        System.out.println("Mã nhân viên : " + getId());
        System.out.println("Tên nhân viên : " + getFullName());
        System.out.println("Birth Day : " + getBirthDay());
        System.out.println("Phone : " + getPhone());
        System.out.println("Email : " + getEmail());
        System.out.println("Employee Type : Intern");
        System.out.println("Chuyên ngành : " + majors);
        System.out.println("Học kỳ : " + semester);
        System.out.println("Tên trường : " + universityName);
    }
}
