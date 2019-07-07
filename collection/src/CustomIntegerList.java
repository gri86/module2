public class CustomIntegerList {
    IntegerNode head;
    IntegerNode tail;


    public void add(Integer item){
        IntegerNode node = new IntegerNode(item);

        if (head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    public void addFirst(Integer item){
        IntegerNode node = new IntegerNode(item);
        if (head == null){
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public boolean delete(Integer item){

        IntegerNode current = head;
        IntegerNode prev = null;

        while (current != null){
            if(current.item.equals(item)){
                if(prev != null){
                    prev.next = current.next;
                    if(current.next == null){
                        tail = prev;
                    }
                }else{
                    head = head.next;
                    if (head == null){
                        tail = null;
                    }
                }

                return true;
            }

            prev = current;
            current = current.next;
        }
        return false;

    }

    public boolean contains(Integer item){
        IntegerNode current = head;
        while (current != null){
            if (current.item.equals(item)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear(){
        head = null;
        tail = null;
    }



}


