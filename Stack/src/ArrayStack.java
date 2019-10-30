/**
 * @author huangyu
 * @version 1.0
 * @date 2019/10/30 9:41
 */
public class ArrayStack<E> implements Stack<E>{

    Array<E> array;

    public ArrayStack(int cpacity) {
        this.array = new Array<>(cpacity);
    }

    public ArrayStack(){
        this.array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i != array.getSize() -1){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
