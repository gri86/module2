package app;


import prepare.FileLoader;
import prepare.Initializer;
import services.fg.auth.AuthService;
import services.fg.auth.SimpleAuth;

import java.util.Scanner;

public class App {

    private static boolean flag = true;
    
    static {
        Initializer initializer = new FileLoader();
        if (initializer.isLoad())
            System.out.println("Данные успешно загружены");
            Context.loadContext();
    }

    public static void main(String[] args) {


        loadInterface();


    }

    private static void loadInterface() {

        boolean authFlag = true;
        while (authFlag){
            if(!Context.isAuth){
                System.out.println("Для работы с банкоматом введите логин и пароль");
                checkAuth();
                if (Context.isAuth){
                    System.out.println("Вы успешно авторизовались в системе");
                }else {
                    System.out.println("Ошибка авторизации");
                }

            }else {
                Scanner sc = new Scanner(System.in);
                System.out.println("Для выхода из системы введите logout, для справки по командам введите help");
                String command = sc.nextLine();
                if(command.equals("logout"))
                    break;
                commandInterface(command);

            }
            
        }
        System.out.println("Выход из программы");

    }

    private static void commandInterface(String command) {
    }

    private static void checkAuth(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Авторизация");
        System.out.print("Введите логин: ");
        String login  = sc.nextLine();
        System.out.print("\n Введите пароль: ");
        String password = sc.nextLine();
        System.out.println();

        new SimpleAuth(login, password).authenticate();

    }


}
