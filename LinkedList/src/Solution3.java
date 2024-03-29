/**
 * @author huangyu
 * @version 1.0
 * @date 2019/10/31 15:45
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val){
        if(head == null){
            return null;
        }

        ListNode res = removeElements(head.next, val);
        if(head.val == val){
            return res;
        }else {
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution3()).removeElements(head,1);
        System.out.println(res);
    }
}
