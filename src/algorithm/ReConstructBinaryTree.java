import java.util.*;
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length ==0 && in.length ==0) return null;
        if(pre.length == 1 && in.length ==1) return new TreeNode(pre[0]);
        int root = pre[0];
        TreeNode r = new TreeNode(root);
        int rootindex = findIndex(in,root);
        if(rootindex != 0)
        {
           int[] inLeft = Arrays.copyOfRange(in,0,rootindex);
           System.out.println("inLeft:"+ Arrays.toString(inLeft));
           int[] preLeft = Arrays.copyOfRange(pre,1,inLeft.length+1);
           System.out.println("preLeft:"+ Arrays.toString(preLeft));

           r.left = reConstructBinaryTree(preLeft,inLeft);
        }
        else
        {
            r.left = null;
        } 
        if(rootindex != in.length-1)
        {
            int[] inRight = Arrays.copyOfRange(in,rootindex+1,in.length);
            System.out.println("inRight:"+ Arrays.toString(inRight));
            int[] preRight =Arrays.copyOfRange(pre,in.length-inRight.length,in.length);
            System.out.println("preRight:"+ Arrays.toString(preRight));
            r.right = reConstructBinaryTree(preRight,inRight);
        }
        else 
        {
            r.right = null;
        }
        
        return r;
        
    }
    
    private int findIndex(int[] arr,int target)
    {
        for(int i=0 ; i<arr.length;i++)
        {
            if(target == arr[i])
                return i;
        }
        return 0;
    }
}