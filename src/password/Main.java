/*
*    Необходимо из консоли считать пароль и проверить валидность,
*    результат будет true или false
*
*    Требования:
*    1. Пароль должен быть не менее 8ми символов.
*    2. В пароле должно быть число
*    3. В пароле должна быть хотя бы 1 строчная буква
*    4. В пароле должна быть хотя бы 1 заглавная буква
*    5. Не должно быть пробелов
*    6. Должен быть спец. символ
 */
package password;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws PasswordIsNotException {
        String pass1;
//        final String pass1 = "Ab2!G#1k#";
//        final String pass2 = "Abc!fG#lk";
//        final String pass3 = "AAAAAAAA";
//        final String pass4 = "aaaaaaaa";
//        final String pass5 = "        ";
//        final String pass6 = "AaaaaaaA";
//        final String pass7 = "kZ@~1QqP+";
//        final String pass8 = "$sApDr0W!";
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Введите координаты ячейки через пробел.");
            pass1 = scanner.next();

        } while (!pass1.isEmpty());

//        System.out.println("Пароль " + pass1 + isValidPass(checkPass(pass1)));
        try{
            System.out.println("Пароль " + pass1 + isValidPass(checkPass(pass1)));
        }
        catch (PasswordIsNotException e){
            System.out.println("Упс! Ваш пароль не достаточно стоек!");
        }

//        System.out.println("Пароль " + pass3 + isValidPass(checkPass(pass3)));
//        System.out.println("Пароль " + pass4 + isValidPass(checkPass(pass4)));
//        System.out.println("Пароль " + pass5 + isValidPass(checkPass(pass5)));
//        System.out.println("Пароль " + pass6 + isValidPass(checkPass(pass6)));
//        System.out.println("Пароль " + pass7 + isValidPass(checkPass(pass7)));
//        System.out.println("Пароль " + pass8 + isValidPass(checkPass(pass8)));
    }

    public static String isValidPass(boolean b){
        if (b) return " валидный.";
        else return " не валиден.";
    }

    public static boolean checkPass(String pass) throws PasswordIsNotException{
        Pattern p = Pattern.compile("^(?=.+[A-Z])(?=.+[a-z])(?=.+[0-9])(?=.+[+/#?!@$~%^&*-])([\\S]){8,}$");
        Matcher m = p.matcher(pass);
        if (m.matches())
            return m.matches();
        else
            throw new PasswordIsNotException("Пароль не удовлетворяет условиям.");
    }
}
