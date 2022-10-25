package utill;

import bean.Student;
import main.Config;

public class StudentUtil {

    public static Student fillStudent(){
        String name = InputUtil.requiredText("Enter Name:");
//                sc = new Scanner(System.in);
//                System.out.println("Enter Name:");
//                String name = sc.nextLine();

        String surname = InputUtil.requiredText("Enter Surname:");
//                sc = new Scanner(System.in);
//                System.out.println("Enter Surname:");
//                String surname = sc.nextLine();

        int age = InputUtil.requiredNumber("Enter Age:");
//                sc = new Scanner(System.in);
//                System.out.println("Enter Age:");
//                int age = sc.nextInt();

        String className = InputUtil.requiredText("Enter ClassName:");
//                sc = new Scanner(System.in);
//                System.out.println("Enter ClassName:");
//                String className = sc.nextLine();

        Student student = new Student(name, surname, age, className);

        return student;
    }

    public static void printAllRegisteredStudents(){
        if(Config.students == null) return;

        for(int i = 0; i <Config.students.length;i++){ //NullPointerException
            Student oneStudent = Config.students[i];
            System.out.println((i + 1) + ": " + oneStudent.getFullInfo());
        }
    }

    public static void menuRegistered(){
        int count = InputUtil.requiredNumber("How many will be students registered? ");
        Config.students = new Student[count];

        for(int i =0; i < count; i ++) {

            System.out.println((i+1) + ": Register:");
            Student student = StudentUtil.fillStudent();

            Config.students[i] = student;
        }
        System.out.println("Students registered successfully!");
        StudentUtil.printAllRegisteredStudents();
    }



    public static Student[] menuFindStudent(String text){
        int count = 0;
        for(int i = 0; i < Config.students.length;i++){
            Student st = Config.students[i];
            if(st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)){
                count++;
            }
        }
        Student[] result = new Student[count];
        int found = 0;
        for(int i = 0; i < Config.students.length;i++){
            Student st = Config.students[i];
            if(st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)){
                result[found] = st;
                found++;
            }
        }
        return result;
    }

    public static void findStudentAndPrint(){

        String text = InputUtil.requiredText("Enter name or surname or className");

        Student[] students = StudentUtil.menuFindStudent(text);
        for(Student st: students){
            System.out.println(st.getFullInfo());
        }
    }
//    public static void menuFindStudent(){
//        String text = InputUtil.requiredText("Enter name or surname or className");
//        for(int i = 0; i < Config.students.length;i++){
//            Student st = Config.students[i];
//            if(st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)){
//                System.out.println((i + 1) + ": " + st.getFullInfo());
//            }
//        }
//    }
}
