package studentsystem;

import java.util.Scanner;
/**
 *
 * @author Ranim
 */
class StudentSystem {

    static String[] studentName = new String[100];
    static String[] studentID = new String[100];
    static String[] studentAddress = new String[100];
    static double[] studentGrade = new double[100];

    static int counter = 0;

    static String adminusername = "Admin";
    static String adminpassword = "1234";

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Student Grade Statistics System.");
        System.out.println("_________________________________________");
        System.out.println("Login as : ");
        System.out.println("1) Administrator.");
        System.out.println("2) User.");

        int login = input.nextInt();
        input.nextLine();

        switch (login) {
            case 1:
                adminLogin();
                break;
            case 2:
                System.out.println("Maintenance, try later.");
                break;
            default:
                System.out.println("Invalid input ...");
                break;
        }
    }

    public static void adminLogin() {
        System.out.println("Enter admin username: ");
        String username = input.nextLine();
        System.out.println("Enter admin password: ");
        String password = input.nextLine();

        if (adminusername.equalsIgnoreCase(username) && adminpassword.equals(password)) {
            System.out.println("Login is successful.");
            //the admin list here 
            adminList();
        } else {
            System.out.println("Error in password or username.");
        }
    }

    public static void adminList() {
        System.out.println("Admin List:");
        System.out.println("1) Add new student grade.");
        System.out.println("2) Display all student grades.");
        System.out.println("3) Find and display the highest and the lowest grades.");
        System.out.println("4) Classify grades into Categories (A, B, C, D, F).");
        System.out.println("5) Modify student's grade.");
        System.out.println("6) Delete a student's grade.");
        int adminChoice = input.nextInt();
        input.nextLine();
        switch (adminChoice) {
            case 1:
                addStudent();
                break;
            case 2:
                displayGrades();
                break;
            case 3:
                maxANDmin();
                break;
            case 4:
                categories();
                break;
            case 5:
                modifyGrade();
                break;
            case 6:
                deleteStudent();
                break;
        }
    }

    public static void addStudent() {
        System.out.println("Firstly enter student's ID: ");
        studentID[counter] = input.nextLine();
        System.out.println("Secondly enter student's name: ");
        studentName[counter] = input.nextLine();
        System.out.println("Thirdly enter student's grade: ");
        studentGrade[counter] = input.nextDouble();
        input.nextLine();
        System.out.println("Fourthly enter student's address: ");
        studentAddress[counter] = input.nextLine();
        counter++;
        System.out.println("Student is added successfully.");

        System.out.println("Do you want to go back to admin list?");
        System.out.println("1) Yes.\n2) No.");
        int num = input.nextInt();
        if (num == 1) {
            adminList();
        } else if (num == 2) {
            System.exit(0);
        } else {
            System.out.println("Invalid input.");
        }

    }

    public static void displayGrades() {
        for (int i = 0; i < counter; i++) {
            if (studentID[i].equals("null")) {
                continue;
            }
            System.out.println("Name: " + studentName[i] + " ID: " + studentID[i] + " Average: " + studentGrade[i] + " Address: " + studentAddress[i]);
        }
        System.out.println("Do you want to go back to admin list?");
        System.out.println("1) Yes.\n2) No.");
        int num = input.nextInt();
        if (num == 1) {
            adminList();
        } else if (num == 2) {
            System.exit(0);
        } else {
            System.out.println("Invalid input.");
        }
    }

    public static void maxANDmin() {
        String maxName = studentName[0], maxID = studentID[0];
        double highest = studentGrade[0];
        for (int i = 1; i < counter; i++) {
            if (studentGrade[i] > highest) {
                highest = studentGrade[i];
                maxName = studentName[i];
                maxID = studentID[i];
            }
        }
        System.out.println("The highest grade is: " + highest);
        System.out.println("Name: " + maxName + " ID: " + maxID);

        String minName = studentName[0], minID = studentID[0];
        double lowest = studentGrade[0];
        for (int i = 1; i < counter; i++) {
            if (studentGrade[i] < lowest) {
                lowest = studentGrade[i];
                minName = studentName[i];
                minID = studentID[i];
            }
        }
        System.out.println("The lowest grade is: " + lowest);
        System.out.println("Name: " + minName + " ID: " + minID);

        System.out.println("Do you want to go back to admin list?");
        System.out.println("1) Yes.\n2) No.");
        int num = input.nextInt();
        if (num == 1) {
            adminList();
        } else if (num == 2) {
            System.exit(0);
        } else {
            System.out.println("Invalid input.");
        }
    }

    public static void categories() {
        char cate;
        for (int i = 0; i < counter; i++) {
            if (studentGrade[i] >= 90) {
                cate = 'A';
            } else if (studentGrade[i] >= 80) {
                cate = 'B';
            } else if (studentGrade[i] >= 70) {
                cate = 'C';
            } else if (studentGrade[i] > 50) {
                cate = 'D';
            } else {
                cate = 'F';
            }
            System.out.println("Name: " + studentName[i] + " ID: " + studentID[i]);
            System.out.println("Grade: " + studentGrade[i] + " Rate: " + cate);
        }
        System.out.println("Do you want to go back to admin list?");
        System.out.println("1) Yes.\n2) No.");
        int num = input.nextInt();
        if (num == 1) {
            adminList();
        } else if (num == 2) {
            System.exit(0);
        } else {
            System.out.println("Invalid input.");
        }
    }

    public static void modifyGrade() {
        System.out.println("Enter student's ID: ");
        String IDModify = input.nextLine();
        for (int i = 0; i < counter; i++) {
            if (studentID[i].equals(IDModify)) {
                System.out.println("Enter student's new grade: ");
                double gradeModify = input.nextDouble();
                input.nextLine();
                studentGrade[i] = gradeModify;
                System.out.println("Grade is successfully modified.");
                break;
            }
        }
        System.out.println("Do you want to go back to admin list?");
        System.out.println("1) Yes.\n2) No.");
        int num = input.nextInt();
        if (num == 1) {
            adminList();
        } else if (num == 2) {
            System.exit(0);
        } else {
            System.out.println("Invalid input.");
        }
    }

    public static void deleteStudent() {
        System.out.println("Enter student's ID: ");
        String deleteID = input.nextLine();
        for (int i = 0; i < counter; i++) {
            if (studentID[i].equals(deleteID)) {
                studentName[i] = "null";
                studentID[i] = "null";
                studentAddress[i] = "null";
                studentGrade[i] = 0.0;
                System.out.println("Student deleted successfully.");
                break;
            }
        }

        System.out.println("Do you want to go back to admin list?");
        System.out.println("1) Yes.\n2) No.");
        int num = input.nextInt();
        if (num == 1) {
            adminList();
        } else if (num == 2) {
            System.exit(0);
        } else {
            System.out.println("Invalid input.");
        }
    }
}
