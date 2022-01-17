package main.java.datastructures;
import java.util.LinkedList;

public class HashTable {
    LinkedList<Integer>[] data = new LinkedList[5];

    boolean put(String key, int value){
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        if (data[index] == null){
            data[index] = new LinkedList<Integer>();
        }
        data[index].add(value);
        return true;
    }

    private int getHashCode(String key){
        return 0;
    }

    private int convertToIndex(int hashcode){
        return 0;
    }

    public boolean containsKey(String key){
        return false;
    }

    public boolean remove(String key){
        return false;
    }


}
