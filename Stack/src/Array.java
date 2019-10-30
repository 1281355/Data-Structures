/**
 * @author huangyu
 * @version 1.0
 * @date 2019/10/29 14:19
 */
public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 有参构造函数
     * @param capacity 容量
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 午餐构造函数
     */
    public Array(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向数组最后增加一个新元素
     */
    public void addLast(E e) {
        add(size,e);
    }

    /**
     * 在数组前增加一个新元素
     * @param e
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 在第index个位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if(size == data.length){
//            throw new IllegalArgumentException("Add failed. Array is full.");
           //扩容
            resize(2 * data.length);
        }

        for(int i = size -1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }



    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    E get(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed. Index is illega.");
        }
       return data[index];
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 获取第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }


    /**
     * 修改index索引位置的元素为e
     * @param index
     * @param e
     */
    void set(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Set failed. Index is illega.");
        }
        data[index] = e;
    }

    /**
     * 查询数组是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i] == e){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i] == e){
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Remove failed. Index is illega.");
        }
        E ret = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        //防止震荡
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length/ 2);
        }

        return ret;
    }

    /**
     * 从数组中删除第一个元素，返回删除的元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }
    /**
     * 从数组中删除最后一个元素，返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public boolean removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",size,data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1){
                res.append(", ");
            }

        }
        res.append(']');
        return res.toString();
    }

    /**
     * 扩容
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
