package dz;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> arrayMethod(int[] arr){
        ArrayList<Integer> arrayList = new ArrayList<>();

        int pos = -1;
        for (int i =arr.length-1; i>=0; i--){
            if (arr[i] == 4){
                pos = i+1;
            }
        }
        if(pos == -1){
            throw new RuntimeException("Нет четверки");
        }
        if(pos >= arr.length){
            return arrayList;
        }
        for (int i=pos;i<arr.length;i++){
            arrayList.add(arr[i]);
        }

        return arrayList;

    }

}
