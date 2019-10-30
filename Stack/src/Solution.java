import java.util.Stack;

/**
 * @author huangyu
 * @version 1.0
 * @date 2019/10/30 10:26
 */
public class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else {
                if(stack.isEmpty()){
                    return false;
                }

                char topChar = stack.pop();
                if(topChar == '(' && s.charAt(i) != ')'){
                    return false;
                }
                if(topChar == '[' && s.charAt(i) != ']'){
                    return false;
                }
                if(topChar == '{' && s.charAt(i) != '}'){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).isValid("((({[{}]})))") );
        System.out.println((new Solution()).isValid("((({[{}]}}))") );
    }
}
