package utill;

import java.util.Scanner;

public class InputUtil {

    public static String requiredText(String text){
        Scanner sc = new Scanner(System.in);
        System.out.println(text + ":");
        return sc.nextLine();
//        String answer = sc.nextLine();
//        return answer;
    }
    public static int requiredNumber(String text){
        Scanner sc = new Scanner(System.in);
        System.out.println(text + ":");
        return sc.nextInt();
//        int answer = sc.nextInt();
//        return answer;
    }
}
