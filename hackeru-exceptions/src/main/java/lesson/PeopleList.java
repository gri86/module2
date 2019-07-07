package lesson;

import java.util.Arrays;
import java.util.List;

public class PeopleList {

    private People[] list;
    private int size;

    PeopleList(){
        list = new People[5];
        size = 0;
    }

    public boolean add(People p) throws PeopleListException{
        if (p == null){
            throw new PeopleListException("Получен NULL");
        }
        if(size > list.length){
            throw new PeopleListException("Списое переполнен");
        }
        list[size++] = p;
        return true;
    }

    public People get(int index) throws PeopleListException{
        if (size == 0){
            throw new PeopleListException("Не удалось получить человека, т.к. список пуст");
        }
        if (size < 0){
            throw new PeopleListException("Отрицательный индекс");
        }
        if(index>=size){
            throw new PeopleListException("Выход за пределы списка");
        }

        return list[index];
    }

    public People remove(int index) throws PeopleListException{
        People tmp = get(index);
        list[index] = null;
        size--;
        return tmp;
    }

    public List<People> getList() throws PeopleListException{
        if(size == 0){
            throw new PeopleListException("Список пуст");
        }
        return Arrays.asList(list);
    }



}
