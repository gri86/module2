package list;

public class IntegerStack {
    IntegerNode head;
    IntegerNode tail;

    public void push(Integer item){
        IntegerNode node = new IntegerNode(item);
        if (head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head = node;
        }
    }

    public IntegerNode peek(){
        return head;
    }

    public IntegerNode pop(){
        IntegerNode tmp = head;
        head = head.next;
        return tmp;
    }

}
