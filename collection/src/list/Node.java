package list;

public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data){
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> node = (Node<?>) o;

        if (data != null ? !data.equals(node.data) : node.data != null) return false;
        return next != null ? next.equals(node.next) : node.next == null;

    }
}
