package list;

/*
Добавить в обобщенный CustomLinkedList
Методы:
    remove - удаление
    addFirst - добавить в начало
    clear - очистить
    contains - проверить на присутствие элемента в листе
 */

public class IntegerListApp {
    public static void main(String[] args) {
//        IntegerList list = new IntegerList();
//        list.add(10);
//        list.add(20);
//        list.add(1);
//        list.add(40);

//        list.addFirst(100);

        CustomLinkedList<String> list = new CustomLinkedList<>();
        list.add("Artem");
        list.add("Vova");
        list.add("Sasha");

        Node<String> current = list.head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }

    }
}
