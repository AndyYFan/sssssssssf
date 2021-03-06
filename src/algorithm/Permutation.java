import java.util.*;

public class Permutation{
	List<ArrayList<Integer>>list = new ArrayList<>(); 

	public  List<ArrayList<Integer>> permutation(int n){
		if(n == 0) return list;
		//create 1 2 ... n
		int[]nums = new int[n];
		for(int i=0; i<n;i++){
			nums[i] = i+1;
		}
		boolean[]flag = new boolean[n];

		dfs(new ArrayList<Integer>(),nums,flag,0,n);

		return list;


	}

	public void dfs(ArrayList<Integer>temp,int[]nums,boolean[]flag,int start,int n) {
		//convergence case
		if(start == n){
			list.add(new ArrayList(temp));
			return;
		}
		//layer
		for(int i=0;i<n;i++){
			if(flag[i] == false){
				flag[i] = true;
				temp.add(nums[i]);
				dfs(temp,nums,flag,start+1,n);
				flag[i] = false;
				temp.remove(temp.size()-1);
			}
		}
	}

	public static void main(String[] args) {
		int n = 3;
		Permutation perm = new Permutation();
		List<ArrayList<Integer>> sequence = perm.permutation(n);
		for(ArrayList<Integer>seq:sequence){
			for(int i:seq){
				System.out.print(i + " ");				
			}
			System.out.println("");
		}

	}
}