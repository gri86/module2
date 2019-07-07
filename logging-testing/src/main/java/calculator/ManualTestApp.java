package calculator;

import annotation.MyTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ManualTestApp {

    public static void main(String[] args) {
        Class<?> clazz = ManualTest.class;

        Method[] methods = clazz.getDeclaredMethods();

        for (Method m : methods){
            if (m.isAnnotationPresent(MyTest.class)){
                try {
                    Constructor constructor = clazz.getDeclaredConstructor();
                    ManualTest mt = (ManualTest) constructor.newInstance();
                    m.invoke(mt);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
