/**
 * @author huangyu
 * @version 1.0
 * @date 2019/10/31 14:27
 */
public class Sum {

    public static void main(String[] args) {

    }

    private static int sum(int[] arr, int l){
        if(l == arr.length){
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }
}
