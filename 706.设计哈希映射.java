import java.util.Iterator;
import java.util.LinkedList;
/*
 * @lc app=leetcode.cn id=706 lang=java
 *
 * [706] 设计哈希映射
 */

// @lc code=start
class MyHashMap {
    private class Node{
        private int key;
        private int value;

        public Node (int key, int value){
            this.key = key;
            this.value = value;
        }

        private void setKey(int key) {
            this.key = key;
        }

        private void setValue(int value) {
            this.value = value;
        }

        private int getKey(){
            return key;
        }

        private int getValue(){
            return value;
        }
    }

    // 为了实现哈希集合这一数据结构，有以下几个关键问题需要解决：
    //哈希函数：
    //冲突处理: 这里使用链地址法
    private static final int BASE = 769;
    private LinkedList[] data;
    /** Initialize your data structure here. */
    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList<Integer>(); 
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = key % BASE;
        Iterator<Node> iterator = data[h].iterator();
        while(iterator.hasNext()){
            Node node = iterator.next();
            if(key == node.getKey()){
                node.setValue(value);
                return;
            }
        }
        data[h].offerLast(new Node(key, value));
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = key % BASE;
        Iterator<Node> iterator = data[h].iterator();
        while(iterator.hasNext()){
            Node element = iterator.next();
            if(key == element.getKey()){
                return element.getValue();
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = key % BASE;
        Iterator<Node> iterator = data[h].iterator();
        while(iterator.hasNext()){
            Node element = iterator.next();
            if(key == element.getKey()){
                data[h].remove(element);
                return;
            }
        }
        return;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end

