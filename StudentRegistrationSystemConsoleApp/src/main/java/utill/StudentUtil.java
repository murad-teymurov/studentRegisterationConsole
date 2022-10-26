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

    public static void registerStudent(){
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



    public static Student[] findStudent(String text){
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
    public static void updateStudentWithNewObject(){
        StudentUtil.printAllRegisteredStudents();

        int i = InputUtil.requiredNumber("Who is updated?");

        Student newStudent = StudentUtil.fillStudent();

        Config.students[i - 1] = newStudent;
    }
    public static void updateStudentWithSameObject(){
        StudentUtil.printAllRegisteredStudents();

        int i = InputUtil.requiredNumber("Who is updated?");

        Student foundSt = Config.students[i - 1];

        String text = InputUtil.requiredText("What is changed? enter as 'name','surname','age','classname'");

        if(text.contains("'name'")){
            foundSt.setName(InputUtil.requiredText("name"));
        }
        if(text.contains("'surname'")){
            foundSt.setSurname(InputUtil.requiredText("surname"));
        }
        if(text.contains("'age'")){
            foundSt.setAge(InputUtil.requiredNumber("age"));
        }
        if(text.contains("'classname'")){
            foundSt.setClassName(InputUtil.requiredText("className"));
        }
        System.out.println( "Updated Student: 1" + foundSt.getFullInfo());
    }
    public static void updateStudentWithSplit(){
        StudentUtil.printAllRegisteredStudents();

        int index = InputUtil.requiredNumber("enter the index");

        Student foundSt = Config.students[index -1];

        String changes = InputUtil.requiredText("What is updated? enter name, surname. age, classname");

        String[] params =  changes.split(",");

        for(int i = 0; i < params.length; i++){
            String text = params[i];
            if(text.equalsIgnoreCase("name")){
                foundSt.setName(InputUtil.requiredText("name"));
            }else if(text.equalsIgnoreCase("surname")){
                foundSt.setSurname(InputUtil.requiredText("surname"));
            }else if(text.equalsIgnoreCase("age")){
                foundSt.setAge(InputUtil.requiredNumber("age"));
            }else if(text.equalsIgnoreCase("classname")){
                foundSt.setClassName(InputUtil.requiredText("classname"));
            }

        }
    }

    public static void findStudentAndPrint(){

        String text = InputUtil.requiredText("Enter name or surname or className");

        Student[] students = StudentUtil.findStudent(text);
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
