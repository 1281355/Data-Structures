/**
 * @author huangyu
 * @version 1.0
 * @date 2019/11/4 16:02
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
