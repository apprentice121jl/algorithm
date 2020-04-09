package com.jl.tree;



/**
 * JL
 * 2020/4/8  21:54
 **/
public class TreeSerial {

    static StringBuffer sb=new StringBuffer();
    //使用前序遍历序列化二叉树
    // 1. 同一个树的结点在一个括号中
    // 2. 左右子树之间通过逗号隔开
    static String serialize(BinaryTreeNode root) {
        if(root != null){
            // 遍历根节点
            sb.append(root.getData());
            if(root.getLeft() != null || root.getRight() != null){
                sb.append("(");
                serialize(root.getLeft());
                if(root.getRight() != null)sb.append(",");
                serialize(root.getRight());
                sb.append(")");
            }
        }
        return sb.toString();
    }


        //反序列化：根据某种遍历方式得到的序列化字符串结果，重构二叉树
        static BinaryTreeNode deserialize(String str) {
            char[] chs=str.toCharArray();
           /* for (char c:chs) {
                System.out.print(c);
            }*/
            BinaryTreeNode[] st = new BinaryTreeNode[str.length()];
            BinaryTreeNode p = null;
            BinaryTreeNode b = null;
            int top = -1,k=1,j=0;
            while(j< chs.length){
                switch(chs[j]){
                    case '(':top++;k=1;st[top]= p;break;              //st[top]用于记录父节点；k为1，代表左孩子结点
                    case ')':top--;break;
                    case ',':k=2;break;// k为2，代表右孩子结点
                    default:p= new BinaryTreeNode();
                            p.setData(Integer.valueOf(Character.toString(chs[j])));
                            if(b == null){
                                b = p;
                            }else{
                                switch(k){
                                    case 1:st[top].setLeft(p);break;
                                    case 2:st[top].setRight(p);break;
                                }
                            }
                }
                j++;
            }
            return b;
        }

    public static void main(String[] args) {
        BinaryTreeNode node10=new BinaryTreeNode(10,null,null);

        BinaryTreeNode node8=new BinaryTreeNode(8,null,null);
        BinaryTreeNode node9=new BinaryTreeNode(9,null,null);

        BinaryTreeNode node5=new BinaryTreeNode(5,null,null);
        BinaryTreeNode node4=new BinaryTreeNode(4,node8,node9);

        BinaryTreeNode node6=new BinaryTreeNode(6,null,null);
        BinaryTreeNode node7=new BinaryTreeNode(7,null,null);

        BinaryTreeNode node2=new BinaryTreeNode(2,node4,node5);
        BinaryTreeNode node3=new BinaryTreeNode(3,node6,node7);

        BinaryTreeNode node1=new BinaryTreeNode(1,node2,node3);

        String serialize = serialize(node1);
        System.out.println("序列化后的值："+serialize);
        BinaryTreeNode root = deserialize(serialize);
        sb.delete(0, sb.length());
        serialize = serialize(root);
        System.out.println("序列化后的值："+serialize);

    }

}
