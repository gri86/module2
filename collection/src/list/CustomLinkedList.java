package list;

public class CustomLinkedList<T> {
    Node<T> head;
    Node<T> tail;

    public void add(T item){
        Node<T> node = new Node<>(item);
        if(head == null){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
    }

}
