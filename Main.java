    package com.company;

    import java.util.*;

    class PlacementCell {
        private String startdateTime;
        private String endDateTime;
        private String startdatetimestudents;
        private String enddatetimestudents;


        public void setStartdateTime(String startdateTime) {
            this.startdateTime = startdateTime;
        }
        public String getStartDateTime(){
            return startdateTime;
        }
        public String getEndDateTime(){
            return endDateTime;
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
        public void setdatetimestudents(String startdatetimestudents){
            this.startdatetimestudents=startdatetimestudents;
        }
        public void setEnddatetimestudents(String enddatetimestudents){
            this.enddatetimestudents=enddatetimestudents;
        }
        public String getStartdatetimestudents(){
            return startdatetimestudents;
        }
        public String getEnddatetimestudents(){
            return  enddatetimestudents;
        }


    }

    class Company {

        private String name;
        private String role;
        private String CTC;
        private int cgpa;
        private String companytime;
        public void setCompanytime(String companytime){
            this.companytime=companytime;
        }
        public String getCompanytime(){
            return companytime;
        }

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

        public void UpdateRole(Company c, String Role) {
            c.setRole(Role);
            System.out.println("updated");
        }

        public void UpdatePackage(Company c, String pack) {
            c.setctc(pack);
            System.out.println("updated");

        }


        public void Updatecgpa(Company c, int gpa) {
            c.setCgpa(gpa);
            System.out.println("updated");
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
            p.addStudent(s);
            System.out.println("Student registered");


        }
    }

    public class Main {

        public static void main(String[] args) {
            ArrayList<Student> onWebsite=new ArrayList<Student>();
            Scanner scanner = new Scanner(System.in);
            String begin;
            begin = scanner.nextLine();
            PlacementCell p = new PlacementCell();
            System.out.println("Welcome to Future Builder");
            System.out.println("1. Enter the Application");
            System.out.println("2. Exit the Application ");
            int choose = 0;
            choose = scanner.nextInt();//for entering and exitting
            int mode = 0;//for 4 options
            int query = 0;//for selecting qeries
            if (choose == 1) {
                while (mode == 0 || mode != 4) {
                    System.out.println("1. Enter as Student Mode ");
                    System.out.println("2. Enter as a Company Mode ");
                    System.out.println("3. Enter as PlacementCell ");
                    System.out.println("4. Return to the main Application ");
                    mode = scanner.nextInt();
                    if (mode == 4) {
                        System.out.println("Returned to the application ");
                        break;
                    } else if (mode == 2) {

                        while (query == 0 || query != 4) {
                            System.out.println("Choose the company query to perform");
                            System.out.println("1. Add Company and Details.");
                            System.out.println("2. Choose Company ");
                            System.out.println("3. Get Company");
                            System.out.println("4. Back");
                            query = scanner.nextInt();
                            if (query == 1) {
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

                            } else if (query == 2) {
                                System.out.println("Choose to enter into modes of available companies");
                                System.out.println("Enter the company");
                                Company list[] = p.getList();
                                for (int i = 0; i < list.length; i++) {
                                    System.out.println(list[i].getName());
                                }
                                String select = scanner.next();
                                int update = 0;
                                while (update == 0 || update != 5) {
                                    System.out.println("Welcome " + select);
                                    System.out.println("1.Update Role ");
                                    System.out.println("2.Update Package ");
                                    System.out.println("3.Update CGPA ");
                                    System.out.println("4.Register to institute drive ");
                                    System.out.println("5.Back");
                                    update = scanner.nextInt();
                                    if (update == 1) {
                                        String newR = scanner.next();
                                        Company[] arr = p.getList();
                                        for (int i = 0; i < arr.length; i++) {
                                            if (select.equals(arr[i].getName())) {
                                                arr[i].UpdateRole(arr[i], newR);
                                            }
                                        }


                                    }
                                    if (update == 2) {
                                        String newP = scanner.next();
                                        Company[] arr = p.getList();
                                        for (int i = 0; i < arr.length; i++) {
                                            if (select.equals(arr[i].getName())) {
                                                arr[i].UpdatePackage(arr[i], newP);
                                            }
                                        }

                                    }
                                    if (update == 3) {
                                        int newcg = scanner.nextInt();
                                        Company[] arr = p.getList();
                                        for (int i = 0; i < arr.length; i++) {
                                            if (select.equals(arr[i].getName())) {
                                                arr[i].Updatecgpa(arr[i], newcg);
                                            }
                                        }
                                    }
                                    if (update == 5) {
                                        System.out.println("Choose query again");
                                        break;
                                    }

                                }
                            } else if (query == 3) {
                                Company lists[] = p.getList();
                                for (int i = 0; i < lists.length; i++) {
                                    System.out.println(lists[i].getName() + " " + lists[i].getRole() + " " + lists[i].getCTC() + " " + lists[i].getCgpa());
                                }


                            }

                        }

                    }
                    else if (mode == 3) {
                        while (query == 0 || query != 10) {
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
                            query=scanner.nextInt();

                            if (query == 2) {

                                System.out.println("1. Set Opening time for registrations ");
                                System.out.println("2. Set Closing time for registrations ");


                                String startDatetime = scanner.nextLine();
                                String endDateTime = scanner.nextLine();
                                p.setStartdateTime(startDatetime);

                                String endDatetime = scanner.nextLine();
                                p.setEndDateTime(endDateTime);


                            }
                            if(query==1){
                                System.out.println("Set the opening time for Student Registrations ");
                                System.out.println("Set the opening time for Student Registrations");
                                String startDatetime = scanner.nextLine();
                                String endDateTime = scanner.nextLine();
                                p.setdatetimestudents(startDatetime);
                                p.setEnddatetimestudents(endDateTime);

                            }


                        }
                    }
                    else if(mode==1){
                        while(query==0 || query!=3){
                            System.out.println("Choose the Student query to perform");
                            System.out.println("1. Enter as a Student");
                            System.out.println("2. Add Student");
                            System.out.println("3. Back");
                            query=scanner.nextInt();
                            if(query==2){
                                int numStudents=scanner.nextInt();
                                for(int i=0;i<numStudents;i++){
                                    Student s=new Student();
                                    String StudentName=scanner.next();
                                    int StudentRollNumber=scanner.nextInt();
                                    int StudentCgpa=scanner.nextInt();
                                    String Studentbranch=scanner.next();
                                    s.setname(StudentName);
                                    s.setRollNo(StudentRollNumber);
                                    s.setcgpa(StudentCgpa);
                                    s.setbranch(Studentbranch);
                                    onWebsite.add(s);




                                }
                                for(int j=0;j<onWebsite.size();j++){
                                    System.out.println(onWebsite.get(j).getName());
                                }
                            }
                        }
                    }

                }


            } else {
                System.out.println("exited");
            }

        }
    }












