import java.util.Arrays;

public class CustomArrayList<E>{

    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    private E[] elements;

    public CustomArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }


    public void add(E item) {
        if (size >= elements.length) {
            increaseCapacity();
        }
        elements[size++] = item;
    }

    public void add(int index, E item) {
        elements = Arrays.copyOf(elements,size + 1);
        System.arraycopy(elements, index, elements,index + 1, size - index);
        elements[index] = item;
        size++;
    }

    public void addAll(CustomArrayList<E> collection) {
        E[] newArr = Arrays.copyOf(elements, size + collection.size());
        for (int i = size; i < size + collection.size(); i++) {
            newArr[i] = collection.get(i - size);
        }
        elements = newArr;
        size += collection.size();
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public E get(int index) {
        if (index <= size)
            return elements[index];
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void remove(int index) {
        int moved = size - index - 1;
        System.arraycopy(elements, index + 1, elements, index, moved);
        elements[--size] = null;
    }

    public int size() {
        return size;
    }

    private void increaseCapacity() {
        elements = Arrays.copyOf(elements, size + 1);
    }
}