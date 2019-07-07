package list;

public class IntegerNode {
    Integer data;
    IntegerNode next;

    public IntegerNode(Integer item){
        this.data = item;
    }

    @Override
    public boolean equals(Object node){
        return this.data.equals(((IntegerNode) node).data);
    }

}

