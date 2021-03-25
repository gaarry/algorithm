import java.util.Iterator;
import java.util.LinkedList;
/*
 * @lc app=leetcode.cn id=705 lang=java
 *
 * [705] 设计哈希集合
 */

// @lc code=start
class MyHashSet {

    // 为了实现哈希集合这一数据结构，有以下几个关键问题需要解决：
    //哈希函数：
    //冲突处理: 这里使用链地址法
    private static final int BASE = 769;
    private LinkedList[] data;

    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList<Integer>(); 
        }
    }
    
    public void add(int key) {
        int h = key % BASE;
        Iterator<Integer> iterator = data[h].iterator();
        while(iterator.hasNext()){
            if(key == iterator.next()){
                return;
            }
        }
        data[h].offerLast(key);
    }
    
    public void remove(int key) {
        int h = key % BASE;
        Iterator<Integer> iterator = data[h].iterator();
        while(iterator.hasNext()){
            Integer element = iterator.next();
            if(key == element){
                data[h].remove(element);
                return;
            }
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = key % BASE;
        Iterator<Integer> iterator = data[h].iterator();
        while(iterator.hasNext()){
            if(key == iterator.next()){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end

