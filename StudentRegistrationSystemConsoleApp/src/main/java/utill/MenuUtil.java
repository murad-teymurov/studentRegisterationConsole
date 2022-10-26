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
}
