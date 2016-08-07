package algorithm;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return ArrayToBST(nums,0,nums.length-1);
        
    }
    private TreeNode ArrayToBST(int[] nums,int start,int end){
            if (start>end) return null;
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = ArrayToBST(nums, start , mid-1);
        root.right = ArrayToBST(nums,mid+1,end);
        return root;
    }
	

}
