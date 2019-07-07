package singleton;

/**
 * Добавить в банкомат чтение свойств: емкость(количество купюр) в файл свойств и
 * использовать для чтения синглтон
 */
public class SingletonApp {

    public static void main(String[] args) {

        Configuration config = Configuration.getInstance();

        System.out.println(config.getProperty("name"));
        System.out.println(config.getProperty("age"));


    }

}
