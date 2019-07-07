package reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class RefclectionApp {

    public static void main(String[] args) {





        Class<?> clazz = Human.class;

        try {



            Constructor constructor =
                    clazz.getDeclaredConstructor(String.class, int.class);

            Human h2 = (Human) constructor.newInstance("Artem", 30);
            System.out.println(h2.getName()+ " "+ h2.getAge());

            Method m1 = clazz.getDeclaredMethod("go");
            m1.setAccessible(true);
            m1.invoke(h2);


            //            Constructor constructor = clazz.getDeclaredConstructor();
//
//            Human h1 = (Human) constructor.newInstance();
//
//            h1.go();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


//        Class<?> clazz = Human.class;
//
//        //Имя класса
//        System.out.println(clazz.getName());
//
//        //Тип поля имя поля + модификаторы
//
//        Field[] fields = clazz.getDeclaredFields();
//
//        for(Field f: fields){
//            String name = f.getName();
//            String type = f.getType().getSimpleName();
//            String modifiers =
//                    Modifier.toString(f.getModifiers());
//            System.out.printf("%s %s %s \n", modifiers, type, name);
//        }
//
//        //Конструкторы
//
//        Constructor[] constructors = clazz.getDeclaredConstructors();
//        for (Constructor c: constructors){
//            String mod = Modifier.toString(c.getModifiers());
//            String name = c.getName();
//            Parameter[] params = c.getParameters();
//            System.out.printf("%s %s(%s) \n",mod, name, Arrays.toString(params));
//        }
//
//        //Методы
//        Method[] methods = clazz.getDeclaredMethods();
//        Arrays.asList(methods).stream().forEach(method -> {
//            String name = method.getName();
//            String type = method.getReturnType().getName();
//            String mod = Modifier.toString(method.getModifiers());
//            String params = Arrays.toString(method.getParameters());
//
//            System.out.printf("%s %s %s(%s) \n", mod, type, name, params);
//        });
    }
}



class Human{
    private String name;
    private int age;
    private static final String CONST = "Hello";

    private void go(){
        System.out.println("Gooooo");
    }

    public int sum(){
        return 1+1;
    }

    public String say(String word){
        return "Hello, "+word;
    }

    public Human(){}

    public Human(String name){
        this.name = name;
    }

    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static String getCONST() {
        return CONST;
    }
}