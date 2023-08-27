package ra.entity;

import java.util.Scanner;

public class Certificate {
    private int certificatedID;
    private String certificatedName;
    private String certificatedRank;
    private String certificatedDate;

    public Certificate() {
    }
    public Certificate(int certificatedID, String certificatedName, String certificatedRank, String certificatedDate) {
        this.certificatedID = certificatedID;
        this.certificatedName = certificatedName;
        this.certificatedRank = certificatedRank;
        this.certificatedDate = certificatedDate;
    }

    public int getCertificatedID() {
        return certificatedID;
    }
    public void setCertificatedID(int certificatedID) {
        this.certificatedID = certificatedID;
    }
    public String getCertificatedName() {
        return certificatedName;
    }
    public void setCertificatedName(String certificatedName) {
        this.certificatedName = certificatedName;
    }
    public String getCertificatedRank() {
        return certificatedRank;
    }
    public void setCertificatedRank(String certificatedRank) {
        this.certificatedRank = certificatedRank;
    }
    public String getCertificatedDate() {
        return certificatedDate;
    }
    public void setCertificatedDate(String certificatedDate) {
        this.certificatedDate = certificatedDate;
    }
    public void inputCertificate(Scanner scanner){
        System.out.print("Nhập vào mã của bằng cấp : ");
        this.certificatedID = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập vào tên bằng cấp :");
        this.certificatedName= scanner.nextLine();
        System.out.print("Nhập vào xếp loại bằng : ");
        this.certificatedRank = scanner.nextLine();
        System.out.print("Nhập vào ngày cấp bằng : ");
        this.certificatedDate = scanner.nextLine();
    }

}
