package main;

import bean.Student;
import utill.InputUtil;
import utill.StudentUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menu = 0;

        while (true){
            menu = InputUtil.requiredNumber("What do you want do?"
                    +"\n1: Register Student"
                    +"\n2: Show All students "
                    +"\n3: find Student"
                    +"\n4: Update Student"
                    +"\n5: Exit System");
            if(menu == 1){
                StudentUtil.menuRegistered();
            }else if(menu == 2){
                StudentUtil.printAllRegisteredStudents();
            }else if(menu == 3){
                StudentUtil.findStudentAndPrint();
            }else if(menu == 4){
              StudentUtil.printAllRegisteredStudents();

              int i = InputUtil.requiredNumber("Who is updated?");

              Student newStudent = StudentUtil.fillStudent();

              Config.students[i - 1] = newStudent;
            }
            else{
                System.exit(0);
            }
        }
    }
}
