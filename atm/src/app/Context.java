package app;

import models.ATM;
import services.fg.loader.FileLoader;

import java.util.*;

public class Context {

    public static boolean isAuth;
    public static int authUserId;
    public static ATM atm;


    public static void loadContext(){
        Map<Integer, Double> list = new HashMap<>();

        atm = new ATM.Builder()
                .withName("Fitst ATM")
                .addAtmValue(FileLoader.loadStartATM())
                .build();
        System.out.println("Контекст загружен");
        System.out.println("Вас приветствует банкомат "+atm.getName());
    }
}
