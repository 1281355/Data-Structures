/**
 * @author huangyu
 * @version 1.0
 * @date 2019/11/1 17:21
 */
public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for (int num: nums){
            bst.add(num);
        }
        bst.preOrder();
        System.out.println();
        bst.preOrderNR();
        System.out.println();
//
//        bst.postOrder();
//        System.out.println();

//        System.out.println(bst);
    }
}
