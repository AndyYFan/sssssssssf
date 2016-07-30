package algorithm;

public class TwoSumII {
	public int[] twoSum(int[] numbers,int target){
		for(int i=0; i<numbers.length;i++){
			int j = bsearch(numbers,target-numbers[i],i+1);
			if(j!=-1){
				return new int[]{i+1,j+1};
			}
		}
		throw  new IllegalArgumentException("NO solution");
	}
	
	private int bsearch(int[]A,int key,int start){
		int L = start, R = A.length-1;
		while(L < R){
			int M = (L + R)/2;
			if( A[M] < key){
				L = M + 1;
			}else{
				R = M;
			}
		}
		return (L==R && A[L] == key)? L:-1;
	}
	
	public int[] twoSum2(int[]numbers,int target){
		int i = 0;
		int j = numbers.length-1;
		while(i<j)
		{
			if( (numbers[i]+numbers[j])<target) i++;
			else if((numbers[i] + numbers[j]) > target) j--;
			else return new int[]{i+1,j+1};
		}
		throw new IllegalArgumentException("NO solution");
	}
}
