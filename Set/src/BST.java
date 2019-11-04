import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author huangyu
 * @version 1.0
 * @date 2019/11/1 13:26
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        root = add(root, e);
    }
    public Node add(Node node,E e){
        if(node == null){
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }

    /**
     * 看二分搜索树中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root, e);
    }

    public boolean contains(Node node, E e){
        if(node == null){
            return false;
        }
        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

   public void preOrder(Node node){
        if(node == null){
            return;
        }
       System.out.println(node.e);
       preOrder(node.left);
       preOrder(node.right);
   }

    /**
     * 二分搜索非递归排序
     */
   public void preOrderNR(){
       Stack<Node> stack = new Stack<>();
       stack.push(root);
       while (!stack.isEmpty()){
           Node cur = stack.pop();
           System.out.println(cur.e);

           if(cur.right != null){
               stack.push(cur.right);
           }
           if(cur.left != null){
               stack.push(cur.left);
           }
       }
   }


    /**
     * 中序遍历
     */
   public void inOrder(){
        inOrder(root);
   }

   private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
   }

    /**
     * 后序遍历
     */
   public void postOrder(){
        postOrder(root);
   }

    private void postOrder(Node node){
       if(node != null){
           postOrder(node.left);
           postOrder(node.right);
           System.out.println(node.e);
       }
    }

    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
           Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小元素
     * @return
     */
    public E minimum(){
       if(size == 0){
           throw new IllegalArgumentException("BST is empty!");
       }
       return minimum(root).e;
    }
    public Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }


    /**
     * 寻找二分搜索树的最大元素
     * @return
     */
    public E maxmum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }
        return maxmum(root).e;
    }
    public Node maxmum(Node node){
        if(node.right == null){
            return node;
        }
        return maxmum(node.right);
    }

    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax(){
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node rightNode = node.left;
            node.left = null;
            size --;
            return rightNode;
        }
        node.right = removeMax(node.right);
        return node;
    }


    public Node remove(E e){
       root = remove(root, e);
       return root;
    }

    public Node remove(Node node, E e){
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }else {
            //待删除左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            //待删除右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            //待删除结点左右子树均不为空的情况
            //找到比待删除结点大的最小结点，即待删除结点右子树的最小结点
            //用这个结点顶替待删除结点的位置
            Node successor = maxmum(node.right);
            successor.right = removeMax(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private  void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth +1,res);
        generateBSTString(node.right,depth + 1,res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
