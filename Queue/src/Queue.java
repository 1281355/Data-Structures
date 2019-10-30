/**
 * @author huangyu
 * @version 1.0
 * @date 2019/10/30 11:16
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
