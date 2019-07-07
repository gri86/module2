public class QueueList {
    IntegerNode head;
    IntegerNode tail;

    public void push(Integer item){
        IntegerNode node = new IntegerNode(item);
        if(head == null){
            head = node;
            tail = node;
        } else {
           tail.next = node;
           tail = node;

        }

    }

    public Integer pull(){
        if (head != null){
            IntegerNode tmp = head;
            if (head == tail){
                head = null;
                tail = null;
                return tmp.item;
            }else{
                head = head.next;
                return tmp.item;
            }
        }
        return 0;
    }

    public Integer peek(){
        return head.item;
    }

}
