import java.util.Iterator;

public class CustomIntegerIterator implements Iterator<IntegerNode> {

    IntegerNode node;
    IntegerNode next = null;

    public CustomIntegerIterator(IntegerNode node){
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        if (node != null) return true;
        return false;
    }

    @Override
    public IntegerNode next() {
        if (hasNext()){
            next = node.next;
            return node;
        }
        node = node.next;
        return node;
    }
}
