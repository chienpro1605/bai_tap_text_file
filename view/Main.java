package view;

import Models.Student;
import commons.FuncTionFileCSV;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   private static ArrayList<Student> listStudent = new ArrayList<Student>();
    public static void main(String[] args) {
        displayMenu();

    }
    public static void displayMenu(){
        System.out.println("1. Add new student.\n" +
                            "2. show information student.\n"+
                             "3. exit.");

        Scanner scanner = new Scanner(System.in);
        String choose = scanner.nextLine();
        switch (choose){
            case "1":
                addNewstudent();
                break;
            case "2":
                showImformationStudent();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("please choose again");
                scanner.nextLine();
                displayMenu();
                break;
        }
    }

    private static void showImformationStudent() {
        listStudent = FuncTionFileCSV.getFileCSVToListStudent();
        for (Student student: listStudent){
            System.out.println("---------------------");
            System.out.println(student.toString());
            System.out.println("------------------------");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("add new student complete");
        scanner.nextLine();
        displayMenu();
    }

    private static void addNewstudent() {
        Scanner scanner = new Scanner(System.in);

        Student student = new Student();
        System.out.println("nhập name");
        student.setName(scanner.nextLine());
        System.out.println("nhập điểm");
        student.setGrade(scanner.nextLine());
        System.out.println("nhập address");
        student.setAddress(scanner.nextLine());
        listStudent.add(student);
        FuncTionFileCSV.writeStudenttoFileCSV(listStudent);
        System.out.println("enter to contunue");
        scanner.nextLine();
        displayMenu();
    }
}
