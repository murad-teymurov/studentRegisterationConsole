package main;

import bean.Student;
import utill.InputUtil;
import utill.MenuUtil;
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
            MenuUtil.processMenu(menu);
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
}
