/**
 * @author huangyu
 * @version 1.0
 * @date 2019/11/4 19:20
 */
public interface Map<K, V> {

    /**
     * 增加
     * @param key
     * @param value
     */
    void add(K key, V value);

    /**
     * 删除
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * 包含
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * k查询
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 赋值
     * @param key
     * @param value
     */
    void set(K key, V value);

    /**
     * 长度
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();
}
