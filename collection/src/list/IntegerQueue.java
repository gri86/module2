package list;

public class IntegerQueue {
    IntegerNode head;
    IntegerNode tail;

    public void push(Integer item){
        IntegerNode node = new IntegerNode(item);
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    public IntegerNode poll(){
        IntegerNode tmp = head;
        head = head.next;
        return tmp;
    }

    public IntegerNode peek(){
        return head;
    }
}
