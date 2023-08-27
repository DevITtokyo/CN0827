package ra.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Employee {
    public String id, fullName, email, phone, employeeType;
    public Date birthDay;
    public int employeeCount;
    public String certificate;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmployeeType() {
        return employeeType;
    }
    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
    public Date getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
    public int getEmployeeCount() {
        return employeeCount;
    }
    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }
    public String getCertificate() {
        return certificate;
    }
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
    public Employee() {
    }
    public Employee(String id, String fullName, String email, String phone, String employeeType, Date birthDay, int employeeCount, String certificate) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.employeeType = employeeType;
        this.birthDay = birthDay;
        this.employeeCount = employeeCount;
        this.certificate = certificate;
    }
    public String validateEmployeeId(Scanner scanner, List<Employee> employeeList){
        System.out.print("Nhập vào mã nhân viên : ");
        do {
            String id = scanner.nextLine();
                boolean isExistId = false;
                for (Employee employee : employeeList) {
                    if (employee.getId().equals(id)){
                        isExistId = true;
                        break;
                    }
                }
                if (!isExistId) {
                    return id;
                }else {
                    System.err.println("Mã nhân viên đã tồn tại, vui lòng nhập lại");
                }
        } while (true);
    }
    public static String validateEmployeeName (Scanner scanner){
        System.out.print("Nhập vào tên nhân viên :");
        boolean checkEmployeeName = true;
        do {
            String fullName = scanner.nextLine();
            if (fullName.length() > 5 && fullName.length() < 50) {
                return fullName;
            } else {
                System.err.println("Tên nhân viên phải trong khoảng 6 - 50 ký tự, vui lòng nhập lại");
            }
        } while (checkEmployeeName);
        return null;
    }
    public static String validateEmail(Scanner scanner){
        System.out.print("Nhập vào email : ");
        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        boolean checkEmail = true;
        do {
            String email = scanner.nextLine();
            if (Pattern.matches(emailRegex, email)) {
                return email;
            } else {
                System.err.println("Email không đúng định dạng, vui lòng nhập lại");
            }
        } while (checkEmail);
        return null;
    }
    public static String validatePhone (Scanner scanner){
        System.out.print("Nhập vào số điện thoại : ");
        boolean checkPhone = true;
        String phoneRegex = "[0-9]{10}";
        do {
            String phone = scanner.nextLine();
            if (Pattern.matches(phoneRegex, phone)) {
                return phone;
            } else {
                System.err.println("Số điện thoại không đúng định dạng, vui lòng nhập lại");
            }
        } while (checkPhone);
        return null;
    }
    public static Date validateBirthday (Scanner scanner) throws ParseException {
        System.out.print("Nhập vào ngày sinh của nhân viên theo định dạng dd/MM/yyyy: ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        do {
            try {
                Date birthday = sdf.parse(scanner.nextLine());
                Calendar cal = Calendar.getInstance();
                cal.setTime(birthday);
                if (cal.get(Calendar.YEAR) < 2005) {
                    return birthday;
                } else {
                    System.err.println("Năm sinh phải trước năm 2005, vui lòng nhập lại");
                }
            }catch (ParseException ex1) {
                System.err.println("Ngày sinh phải có định dạng dd/MM/yyyy, vui lòng nhập lại");
            }
        } while (true);
    }

//    public static boolean isValidDate(String dateString) {
//        // First check for the pattern
//        if (!Pattern.matches("^\\d{1,2}/\\d{1,2}/\\d{4}", dateString)) {
//            return false;
//        }
//        // Parse the date parts to integers
//        String[] parts = dateString.split("/");
//        int day = Integer.parseInt(parts[0]);
//        int month = Integer.parseInt(parts[1]);
//        int year = Integer.parseInt(parts[2]);
//        // Check the ranges of month and year
//        if (year < 1000 || year > 3000 || month == 0 || month > 12) {
//            return false;
//        }
//        int[] monthLength = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//        // Adjust for leap years
//        if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
//            monthLength[1] = 29;
//        }
//        // Check the range of the day
//        return day > 0 && day <= monthLength[month - 1];
//    }
    public void inputData(Scanner scanner, List<Employee> employeeList) throws ParseException {
        this.id = validateEmployeeId(scanner, employeeList);
        this.fullName = validateEmployeeName(scanner);
        this.email = validateEmail(scanner);
        this.phone = validatePhone(scanner);
        this.birthDay = validateBirthday(scanner);
//        System.out.println("Nhập vào năng lực nhân viên : ");
//        System.out.println("0. Experience");
//        System.out.println("1. Fresher");
//        System.out.println("2. Intern");
//        do {
//            int n = Integer.parseInt(scanner.nextLine());
//            if (n == 0) {
//                this.employeeType = "EXPERIENCE";
//                break;
//            } else if (n == 1) {
//                this.employeeType = "FRESHER";
//                break;
//            } else {
//                this.employeeType = "INTERN";
//                break;
//            }
//        } while (true);
    }

    public abstract void showInfo();
    @Override
    public String toString() {
        return"Employee{" + "id='" + id + '\'' + "- Tên nhân viên : '" + fullName + '\'' + "- Email :'" + email + '\'' + "- Số điện thoại : '" + phone + '\'' + "- EmployeeType : '" + employeeType + '\'' + "- BirthDay : " + birthDay + "- EmployeeCount : " + employeeCount + "- Certificate : '" + certificate + '\'' + '}';
    }
}
