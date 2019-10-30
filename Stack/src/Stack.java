/**
 * @author huangyu
 * @version 1.0
 * @date 2019/10/30 9:40
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
