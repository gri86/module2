package list;

public class IntegerList {

    IntegerNode head;
    IntegerNode tail;

    public void addFirst(Integer item){
        IntegerNode node = new IntegerNode(item);
        if (head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head = node;
        }
    }

    public void add(Integer item){
        IntegerNode node = new IntegerNode(item);
        if(head == null){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
    }

    public void clear(){
        head = null;
        tail = null;
    }

    public boolean delete(Integer item){
        IntegerNode node = new IntegerNode(item);
        IntegerNode current = head;
        IntegerNode prev = null;
        while (current != null){
            if(current.equals(node)){
                if (prev == null){
                    head = head.next;
                    return true;
                } else {
                    prev.next = current.next;
                    if(current.next == null){
                        tail = prev;
                    }
                    return true;
                }
            }else{
                prev = current;
                current = current.next;
            }
        }
        return false;
    }

}
