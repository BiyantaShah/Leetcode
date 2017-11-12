package fullTime;

import java.util.Map;

/**
 * Created by Biyanta on 14/09/17.
 */
public class MyHashMap {
    int size;
    Entry[] entryArr = new Entry[256];

    static class Entry{
        String key;
        int value;
        Entry next;

        Entry(String k, int val) {
            key = k;
            value = val;
            next = null;
        }
    }

    public static void main (String[] args) {

        MyHashMap hm = new MyHashMap();
        hm.put("One", 1);
        hm.put("Two", 2);
        System.out.println(hm.get("Two"));
        hm.put("Three", 3);
        System.out.println(hm.size);
        hm.remove("One");
        System.out.println(hm.size);
        System.out.println(hm.get("One"));
    }

    private void remove(String key) {

        int hash = Math.abs(key.hashCode() % 256);
        Entry prev = null;

        if (entryArr[hash] ==  null) {
            System.out.println("Key does not exist");
            return;
        }
        else {
            Entry current = entryArr[hash];
            while (current != null) {
                if (current.key.equals(key)) {
                    break;
                }
                prev = current;
                current = current.next;
            }
            size --;
            if (prev != null)
                prev.next = current.next;
            else
                entryArr[hash] = current.next;
        }
    }

    private Integer get(String key) {
        int hash = Math.abs(key.hashCode() % 256);


        if (entryArr[hash] ==  null) {
            System.out.println("Key does not exist");
            return null;
        }
        else {
            Entry current = entryArr[hash];
            while (current != null) {
                if (current.key.equals(key)) {
                    return current.value;
                }
            }
        }
        return null;
    }

    private void put(String key, int value) {

        int hash = Math.abs(key.hashCode() % 256);
        Entry entry = new Entry(key, value);

        if (entryArr[hash] ==  null) {
            entryArr[hash] = entry;
            size++;
        }
        else {
            Entry current = entryArr[hash];
            while (current != null) {

                if (current.key.equals(key)) {
                    current.value = value;
                    size ++;
                    break;
                }
                current = current.next;
            }
        }
    }

}
