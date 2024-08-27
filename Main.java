package com.company;

import java.util.*;

class PlacementCell {
    private String startdateTime;
    private String endDateTime;

    public void setStartdateTime(String startdateTime) {
        this.startdateTime = startdateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    private ArrayList<Student> registeredStudents;
    private ArrayList<Company> registeredCompany;

    public PlacementCell() {
        registeredStudents = new ArrayList<Student>();
        registeredCompany = new ArrayList<Company>();
    }

    public void addStudent(Student s) {
        this.registeredStudents.add(s);
    }

    public void addCompany(Company c) {
        this.registeredCompany.add(c);
    }

    public Company[] getList() {
        Company arr[] = new Company[registeredCompany.size()];
        for (int i = 0; i < registeredCompany.size(); i++) {
            arr[i] = registeredCompany.get(i);

        }
        return arr;

    }


}

class Company {

    private String name;
    private String role;
    private String CTC;
    private int cgpa;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRole(String role) {
        this.role = role;

    }

    public String getRole() {
        return role;
    }

    public void setctc(String CTC) {
        this.CTC = CTC;
    }

    public String getCTC() {
        return CTC;
    }

    public void setCgpa(int cgpa) {
        this.cgpa = cgpa;
    }

    public int getCgpa() {
        return cgpa;
    }

    public void registerc(PlacementCell p, Company c) {


        p.addCompany(c);

    }

    public void UpdateRole(String s, String newRole, PlacementCell p) {
        Company arr[] = p.getList();
        for (int j = 0; j < arr.length; j++) {
            if (s == arr[j].getName()) {
                System.out.println(arr[j].getName());
                arr[j].setRole(newRole);
                System.out.println("Updated");
                break;
            }
            break;
        }


    }

    public void UpdatePackage(String s, String newpackage, PlacementCell p) {
        Company arr[] = p.getList();
        for (int j = 0; j < arr.length; j++) {
            if (s == arr[j].getName()) {
                arr[j].setRole(newpackage);
                System.out.println("Updated");
                break;
            }
        }


    }

    public void Updatecgpa(String select, int cgpa, PlacementCell p) {
        Company arr[] = p.getList();
        for (int j = 0; j < arr.length; j++) {
            if (select == arr[j].getName()) {
                arr[j].setCgpa(cgpa);
                System.out.println("Updated");
                break;
            }
        }


    }

    public void listOfCompanies(PlacementCell p) {
        Company arr[] = p.getList();
        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j].getName());
        }
    }

}


class Student {
    ArrayList<Student> registered;
    private String name;
    private int cgpa;
    private int rollNo;
    private String branch;

    public void setname(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setcgpa(int cgpa) {
        this.cgpa = cgpa;
    }

    public int getCgpa() {
        return cgpa;
    }

    public void setbranch(String branch) {
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public void register(Student s, PlacementCell p) {
        setname(name);
        setRollNo(rollNo);
        setcgpa(cgpa);
        setbranch(branch);
        p.addStudent(s);


    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String begin;
        begin = scanner.nextLine();
        PlacementCell p = new PlacementCell();
        System.out.println("Welcome to Future Builder");
        System.out.println("1. Enter the Application");
        System.out.println("2. Exit the Application ");
        int choose;
        int mode = 0;
        choose = scanner.nextInt();
        while (mode != 4 || mode == 0) {

            if (choose == 1) {
                System.out.println("1. Enter as Student Mode ");
                System.out.println("2. Enter as a Company Mode ");
                System.out.println("3. Enter as PlacementCell ");
                System.out.println("4. Return to the main Application ");
            }
            mode = scanner.nextInt();

            int functions = 0;
            if (mode == 3) {
                System.out.println("Welcome to IIITD Placement Cell");
                System.out.println("1. Open Student Registrations.");
                System.out.println("2. Open Copany Registrations ");
                System.out.println("3. Get Number of Students ");
                System.out.println("4. Get Number of Company Registrations ");
                System.out.println("5. Get Number of offered or unoffered or Blocked Students ");
                System.out.println("6. Get Student Details  ");
                System.out.println("7. Get Company Details ");
                System.out.println("8. Get Average Package");
                System.out.println("9. Get Company process Results ");
                System.out.println("10. Back ");
                while (functions != 10) {
                    functions = scanner.nextInt();

                    if (functions == 2) {

                        System.out.println("1. Set Opening time for registrations ");
                        System.out.println("2. Set Closing time for registrations ");


                        String startDatetime = scanner.nextLine();
                        String endDateTime = scanner.nextLine();
                        p.setStartdateTime(startDatetime);

                        String endDatetime = scanner.nextLine();
                        p.setEndDateTime(endDateTime);


                    }

                }
            } else if (mode == 2) {
                System.out.println("Choose the company query to perform");
                System.out.println("1. Add Company and Details.");
                System.out.println("2. Choose Company ");
                System.out.println("3. Get Company");
                System.out.println("4. Back");
                functions = 0;

                while (functions != 4) {
                    functions = scanner.nextInt();
                    if (functions == 4) {
                        break;
                    }

                    if (functions == 1) {
                        Company c = new Company();
                        String CompanyName = scanner.next();
                        String CompanyRole = scanner.next();
                        String ctc = scanner.next();
                        int cgpa = scanner.nextInt();
                        c.setName(CompanyName);
                        c.setRole(CompanyRole);
                        c.setctc(ctc);
                        c.setCgpa(cgpa);
                        c.registerc(p, c);


                    }
                    else if (functions == 2) {
                        System.out.println("Choose to enter into modes of available companies");
                        System.out.println("Enter the company");


                        Company c = new Company();
                        c.listOfCompanies(p);
                        String select = scanner.next();
                        int option=0;
                        while(option==0 || option!=5){
                            System.out.println("Welcome to " + select);
                            System.out.println("1.Update Role ");
                            System.out.println("2. Update Package ");
                            System.out.println("3. Update CGPA ");
                            System.out.println("4. Register to institute drive ");
                            System.out.println("5. Back");
                            option= scanner.nextInt();
                            if(option==1){

                            }
                            if(option==5){
                                break;
                            }
                        }


                    }
                }

            }

        }

    }

}









