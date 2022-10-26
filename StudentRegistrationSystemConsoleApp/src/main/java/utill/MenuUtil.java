package utill;

public class MenuUtil {

    public static void processMenu(int selectMenu){
        if(selectMenu == 1){
            StudentUtil.registerStudent();
        }else if(selectMenu == 2){
            StudentUtil.printAllRegisteredStudents();
        }else if(selectMenu == 3){
            StudentUtil.findStudentAndPrint();
        }else if(selectMenu == 4){
            StudentUtil.updateStudentWithSplit();
//                StudentUtil.updateStudentWithSameObject();
//              StudentUtil.updateStudentWithNewObject();
        }else{
            System.exit(0);
        }
    }
    public static void requireName(){
        InputUtil.requiredText("Enter name: ");
    }
    public static void requireSurname(){
        InputUtil.requiredText("Enter surname: ");
    }
    public static void requireClassname(){
        InputUtil.requiredText("Enter class name: ");
    }
    public static void require1Age(){
        InputUtil.requiredNumber("Enter age: ");
    }
}
