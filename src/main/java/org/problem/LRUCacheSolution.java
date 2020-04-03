package org.problem;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * 实现LRU
 * HashMap + LinkedList 方法构造一个LRU
 * 还有其他解法
 *
 */
public class LRUCacheSolution {

    private int capacity;  //容量
    private HashMap<Integer, Integer> map; //存储
    private LinkedList<Integer> list;
    
    public LRUCacheSolution(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove((Integer) key);
            list.addLast(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            list.remove((Integer) key);
            list.addLast(key);
            map.put(key, value);
            return;
        }

        if (list.size() == capacity) {
            map.remove(list.removeFirst());
        }

        map.put(key, value);
        list.addLast(key);

    }

}
