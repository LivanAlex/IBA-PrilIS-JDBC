package com.company.start;

import com.company.action.DisciplineAction;
import com.company.action.StudentAction;
import com.company.model.Discipline;
import com.company.model.Student;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Scanner;


public class MainClass {

    StudentAction studentAction = new StudentAction();
    DisciplineAction disciplineAction = new DisciplineAction();

    public static void main(String[] args) {
        String DbOperation = "0 - EXIT\n" +
                "1 - add student\n" +
                "2 - update student\n" +
                "3 - delete student\n" +
                "4 - fetch by student id\n" +
                "5 - fetch by student email\n" +
                "6 - fetch by student phone\n" +
                "7 - fetch by student first or last name\n" +
                "8 - fetch by student city\n" +
                "9 - fetch by student salary range\n" +
                "10 - fetch by student date of birthday range\n" +
                "11 - fetch by student date of joining range\n" +
                "12 - fetch all students\n" +
                "13 - add discipline\n" +
                "14 - fetch discipline by name\n" +
                "15 - fetch discipline by lecture range\n" +
                "16 - fetch all disciplines\n";

        MainClass mainclass = new MainClass();
        int value = 0;
        do {
            System.out.println("valid operations are");

            System.out.println(DbOperation);
            System.out.println("Enter valid operation number 0-16");
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();

            switch (value) {
                case 1:
                    mainclass.addStudent();
                    break;
                case 2:
                    mainclass.updateStudent();
                    mainclass.fetchAllStudent();
                    break;
                case 3:
                    mainclass.deleteStudent();
                    break;
                case 4:
                    mainclass.fetchStudentById();
                    break;
                case 5:
                    mainclass.fetchStudentByEmail();
                    break;
                case 6:
                    mainclass.fetchStudentByMobileNo();
                    break;
                case 7:
                    mainclass.fetchStudentByName();
                    break;
                case 8:
                    mainclass.fetchStudentByCity();
                    break;
                case 9:
                    mainclass.fetchStudentBySalaryRange();
                    break;
                case 10:
                    mainclass.fetchStudentByDob();
                    break;
                case 11:
                    mainclass.fetchStudentByDOjRange();
                    break;
                case 12:
                    mainclass.fetchAllStudent();
                    break;
                case 13:
                    mainclass.addDiscipline();
                    break;
                case 14:
                    mainclass.fetchDisciplineByName();
                    break;
                case 15:
                    mainclass.fetchDisciplineByLectureRange();
                    break;
                case 16:
                    mainclass.fetchAllDisciplines();
                    break;
                case 0:
                    System.out.println("Exiting code");
                    break;
                default:
                    System.out.println("Not a valid entry");
            }
        } while (value != 0);

    }

    private void fetchDisciplineByLectureRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Lecture Range Start:");
        int startRange = scanner.nextInt();
        System.out.println("Enter Lecture Range End:");
        int endRange = scanner.nextInt();
        disciplineAction.fetchDisciplineByLectureRange(startRange, endRange);

    }

    private void fetchDisciplineByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Discipline Name:");
        String userInput = scanner.nextLine();
        disciplineAction.fetchDisciplineByName(userInput);
    }

    private void addDiscipline() {
        Discipline discipline = new Discipline();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Discipline Name");
        discipline.setDisciplineName(insert.next());
        System.out.println("Enter Lecture");
        discipline.setLecture(insert.nextInt());
        System.out.println("Enter Practical");
        discipline.setPractical(insert.nextInt());
        System.out.println("Enter Lab");
        discipline.setLab(insert.nextInt());
        disciplineAction.insert(discipline);
    }


    public void addStudent() {
        Student student = new Student();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter First Name");
        student.setFname(insert.next());
        System.out.println("Enter Last Name");
        student.setLname(insert.next());
        System.out.println("Enter Address");
        student.setAddress(insert.next());
        System.out.println("Enter Mobile Number");
        student.setMobileNo(insert.next());
        System.out.println("Enter Mail Id");
        student.setMail(insert.next());
        System.out.println("Enter City");
        student.setCity(insert.next());
        System.out.println("Enter Designation");
        student.setDesignation(insert.next());
        System.out.println("Enter Dob (yyyy-mm-dd)");
        student.setDob(Date.valueOf(insert.next()));
        System.out.println("Enter Doj  (yyyy-mm-dd)");
        student.setDoj(Date.valueOf(insert.next()));
        System.out.println("Enter Salary");
        student.setSalary(insert.nextBigDecimal());
        studentAction.insert(student);
    }

    public void updateStudent() {
        Student student = new Student();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Id");
        student.setId(insert.nextLong());
        System.out.println("Enter First Name");
        student.setFname(insert.next());
        System.out.println("Enter Last Name");
        student.setLname(insert.next());
        System.out.println("Enter Address");
        student.setAddress(insert.next());
        System.out.println("Enter Mobile Number");
        student.setMobileNo(insert.next());
        System.out.println("Enter Mail");
        student.setMail(insert.next());
        System.out.println("Enter City");
        student.setCity(insert.next());
        System.out.println("Enter Designation");
        student.setDesignation(insert.next());
        System.out.println("Enter Dob (yyyy-mm-dd)");
        student.setDob(Date.valueOf(insert.next()));
        System.out.println("Enter Doj  (yyyy-mm-dd)");
        student.setDoj(Date.valueOf(insert.next()));
        System.out.println("Enter Salary");
        student.setSalary(insert.nextBigDecimal());
        studentAction.update(student);
    }

    public void deleteStudent() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Id");
        long id = insert.nextLong();
        studentAction.delete(id);
    }

    public void fetchStudentById() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Id");
        long id = insert.nextLong();
        studentAction.fetchById(id);
    }

    public void fetchStudentByEmail() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Mail");
        String mailId = insert.next();
        studentAction.fetchByEmail(mailId);
    }

    public void fetchStudentByMobileNo() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Mobile Number");
        String mobileNo = insert.next();
        studentAction.fetchByMobileNo(mobileNo);
    }

    public void fetchStudentByName() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Name");
        String name = insert.next();
        studentAction.fetchByName(name);
    }

    public void fetchStudentByCity() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student City");
        String city = insert.next();
        studentAction.fetchByCity(city);
    }

    public void fetchStudentBySalaryRange() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Salary Start Range");
        BigDecimal salaryRange1 = insert.nextBigDecimal();
        System.out.println("Enter Salary End Range");
        BigDecimal salaryRange2 = insert.nextBigDecimal();

        studentAction.fetchBySalaryRange(salaryRange1, salaryRange2);
    }

    public void fetchStudentByDob() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Date of Birth (yyyy-mm-dd)");
        String dob = insert.next();
        studentAction.fetchByDob(Date.valueOf(dob));
    }

    public void fetchStudentByDOjRange() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Start Date of Joining (yyyy-mm-dd)");
        String dob1 = insert.next();
        System.out.println("Enter End Date of Joining (yyyy-mm-dd)");
        String dob2 = insert.next();
        studentAction.fetchByRangeDoj(Date.valueOf(dob1), Date.valueOf(dob2));
    }

    public void fetchAllStudent() {
        studentAction.fetchAll();
    }

    private void fetchAllDisciplines() {
        disciplineAction.fetchAll();
    }

}
