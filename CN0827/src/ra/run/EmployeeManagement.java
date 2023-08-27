package ra.run;

import ra.entity.Employee;
import ra.entity.Experience;
import ra.entity.Fresher;
import ra.entity.Intern;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class EmployeeManagement {
    public static List<Employee> employeeList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        readDataFromFile();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*********************** Employee Management System ***********************");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Cập nhât nhân viên");
            System.out.println("3. Xoá Employee");
            System.out.println("4. Tìm tất cả nhân viên thực tập");
            System.out.println("5. Tìm tất cả nhân viên có kinh nghiệm lâu năm");
            System.out.println("6. Tìm tất cả nhân viên mới ra trường");
            System.out.println("7. Sắp xếp nhân viên theo ngày sinh");
            System.out.println("8. Sắp xếp nhân viên theo tên");
            System.out.println("9. Hiển thị nhân viên");
            System.out.println("10. Thoát");
            try{
                System.out.print("Lựa chọn của bạn là : ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addEmployee();
                        writeDataFromFile(employeeList);
                        break;
                    case 2:
                        updateEmployee(scanner);
                        writeDataFromFile(employeeList);
                        break;
                    case 3:
                        deleteEmployee();
                        writeDataFromFile(employeeList);
                        break;
                    case 4:
                        findAllInterns();
                        break;
                    case 5:
                        findAllExperiencedEmployees();
                        break;
                    case 6:
                        findAllFreshers();
                        break;
                    case 7:
                        sortBirthday();
                        break;
                    case 8:
                        sortName();
                        break;
                    case 9:
                        displayEmployees();
                        break;
                    case 10:
                        writeDataFromFile(employeeList);
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Vui lòng nhập từ 0-10");
                }
            }catch (NumberFormatException nfe){
                System.err.println("Dữ liệu không phải là số, vui lòng nhập lại");
            }catch (Exception ex){
                System.err.println("Đã xảy ra trong quá  xử lý, vui lòng nhập lại");
            }

        } while (true);
    }
    // 1. Thêm nhân viên
    public static void addEmployee() throws ParseException {
        System.out.println("********* Hãy chọn nghiệp vụ nhân viên: **********");
        System.out.println("0. Nhân viên có kinh nghiệm lâu năm");
        System.out.println("1. Nhân viên mới ra trường");
        System.out.println("2. Nhân viên thực tập");
        System.out.print("Lựa chọn của bạn là: ");
        int employeeType = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào số lượng nhân viên bạn muốn thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            if (employeeType == 0) {
                Experience experience = new Experience();
                experience.inputData(scanner, employeeList);
                employeeList.add(experience);
            } else if (employeeType == 1) {
                Fresher fresher = new Fresher();
                fresher.inputData(scanner, employeeList);
                employeeList.add(fresher);
            } else {
                Intern intern = new Intern();
                intern.inputData(scanner, employeeList);
                employeeList.add(intern);
            }
            System.out.println("-------------------------------------------------");
        }
    }
    // 2. Cập nhật thông tin nhân viên
    public static void updateEmployee(Scanner scanner) throws ParseException {
        System.out.print("Nhập mã nhân viên muốn sửa : ");
        String updateId = scanner.nextLine();
        boolean isExitsId = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(updateId)) {
                isExitsId = true;
                System.out.println("********* Hãy chọn nghiệp vụ nhân viên: **********");                System.out.println("0. Nhân viên có kinh nghiệm lâu năm");
                System.out.println("1. Nhân viên mới ra trường");
                System.out.println("2. Nhân viên thực tập");
                System.out.print("Lựa chọn của bạn là: ");
                int employeeType = Integer.parseInt(scanner.nextLine());
                if (employeeType == 0) {
                    Experience experience = new Experience();
                    experience.inputData(scanner, employeeList);
                    employeeList.set(i, experience);
                } else if (employeeType == 1) {
                    Fresher fresher = new Fresher();
                    fresher.inputData(scanner, employeeList);
                    employeeList.set(i, fresher);
                } else {
                    Intern intern = new Intern();
                    intern.inputData(scanner, employeeList);
                    employeeList.set(i, intern);
                }
                break;
            }
        }
        if (!isExitsId) {
            System.err.println("Mã nhân viên nhập không tồn tại ");
        }
    }
    // 3. Xoá nhân viên
    public static void deleteEmployee() {
        System.out.print("Nhập mã nhân viên muốn xoá: ");
        String editId = scanner.nextLine();
        boolean isExits = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(editId)) {
                isExits = true;
                employeeList.remove(i);
                break;
            }
        }
        if (!isExits) {
            System.err.println("Mã nhân viên không tồn tại");
        }else {
            System.out.println("Đã xóa thành công!");
        }
    }
    // Phương thức tìm nhân viên bằng Id
//    private static Employee findEmployeeById(String employeeId) {
//        for (Employee employee : employeeList) {
//            if (employee.getId() == employeeId) {
//                return employee;
//            }
//        }
//        return null;
//    }
    // 4. Find All Interns
    public static void findAllInterns() {
        System.out.println("Danh sách nhân viên thực tập :");
        for (Employee employee : employeeList) {
            if (employee instanceof Intern) {
                employee.showInfo();
                System.out.println("----------------------");
            }
        }
    }
    // 5. Find All Experienced Employees
    public static void findAllExperiencedEmployees() {
        System.out.println("Danh sách nhân viên có kinh nghiệm lâu năm :");
        for (Employee employee : employeeList) {
            if (employee instanceof Experience) {
                employee.showInfo();
                System.out.println("----------------------");
            }
        }
    }
    // 6. Find All Freshers
    public static void findAllFreshers() {
        System.out.println("Danh sách nhân viên mới ra trường : ");
        for (Employee employee : employeeList) {
            if (employee instanceof Fresher) {
                employee.showInfo();
                System.out.println("----------------------");
            }
        }
    }
    // 7. Sort Employees by BirthDay
    public static void sortBirthday(){
        Collections.sort(employeeList, Comparator.comparing(Employee::getBirthDay));
        System.out.println("Danh sách nhân viên sắp xếp theo ngày sinh tăng dần:");
        for (Employee employee : employeeList) {
            employee.showInfo();
            System.out.println("----------------------");
        }
    }
    // 8. Sort Employees by FullName
    public static void sortName(){
        Collections.sort(employeeList, Comparator.comparing(Employee::getFullName).reversed());
        System.out.println("Danh sách nhân viên sắp xếp theo tên giảm dần:");
        for (Employee employee : employeeList) {
            employee.showInfo();
            System.out.println("----------------------");
        }
    }
    // 9. Display Employyee
    public static void displayEmployees() {
        for (Employee employee : employeeList) {
            employee.showInfo();
            System.out.println("----------------------");
        }
    }
    public static void writeDataFromFile(List<Employee> employeeList){
        // Khởi tạo đối tượng file để làm việc với file - tương đối
        File file = new File("employeeList.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            // Khởi tạo đối tượng FileOutputStream từ file - Checked Exception
            fos = new FileOutputStream(file);
            //Khởi tạo đối tượng ObjectOutputStream từ fos
            oos = new ObjectOutputStream(fos);
            //Sử dụng writeObject để ghi object ra file
            oos.writeObject(employeeList);
            //2.5. Đẩy dữ liệu từ Stream xuống file
            oos.flush();
        }catch (FileNotFoundException ex1){
            System.err.println("File không tồn tại");
        }catch (IOException ex2){
            System.err.println("Lỗi khi ghi dữ liệu ra file");
        }catch (Exception ex){
            System.err.println("Xảy ra lỗi trong quá trình ghi dữ liệu ra file");
        }finally {
            //Đóng các stream
            try {
                if (oos != null){
                    oos.close();
                }
                if (fos != null){
                    fos.close();
                }
            }catch (IOException ex1){
                System.err.println("Xảy ra lỗi khi đóng các stream");
            }catch (Exception ex2){
                System.err.println("Xảy ra lỗi trong quá trình đóng các stream");
            }
        }

    }
    public static List<Employee> readDataFromFile(){
        //Khởi tạo đối tượng File
        File file = new File("listStudent.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Employee> employeeListRead = null;
        try {
            // Khởi tạo đối tượng FileInputStream
            fis = new FileInputStream(file);
            //3. Khởi tạo đối tượng ObjectInputStream
            ois = new ObjectInputStream(fis);
            //4. Đọc dữ liệu object từ file (readObject())
            employeeListRead = (List<Employee>) ois.readObject();
        }catch (FileNotFoundException ex1){
            System.err.println("File không tồn tại");
        }catch (IOException ex2){
            System.err.println("Lỗi khi đọc dữ liệu từ file");
        }catch (Exception ex){
            System.err.println("Xảy ra lỗi trong quá trình đọc dữ liệu từ file");
        }finally {
            //Đóng các stream
            try {
                if (fis != null){
                    fis.close();
                }
                if (ois != null){
                    ois.close();
                }
            }catch (IOException ex1){
                System.err.println("Xảy ra lỗi khi đóng các stream");
            }catch (Exception ex){
                System.err.println("Xảy ra lỗi trong quá trình đóng các stream");
            }
        }
        return employeeListRead;
    }
}

