package algorithm;

public class InversePairs {

	    public int Solution(int [] array) {
	 		if (array.length == 0) return 0;
	        int[] copy = array.clone();
	        
	        return MergeSort(array, copy, 0, array.length-1);
	    }
	    
	   public int MergeSort(int[]array, int[]copy, int start,int end){
	       int result = 0;
	       if (start == end){
	           copy[start] = array[start];
	           return 0;
	       }
	       int length = (end - start)/2;
	       int left = MergeSort(copy,array,start,start+length);
	       int right = MergeSort(copy,array,start+length+1,end);
	       int i = start + length;
	       int j = end;
	       int IndexCopy = end;
	       int count = 0;
	       while(i >= start && j>= start + length + 1)
	   		{
	           if(array[i] > array[j]) {
	               copy[IndexCopy--] = array[i--];
	               count += j - start -length;
	           }
	           else{
	               copy[IndexCopy--] = array[j--];
	           }
	       }
	       for(; i>=start; --i){
	           copy[IndexCopy--] = array[i];
	       }
	       
	       for(; j>= start+length+1;--j ){
	           copy[IndexCopy--] = array[j];
	       }
	       return left + right + count;
	   } 
	   
	   public static void main(String[] args){
		   InversePairs test = new InversePairs();
		   int[] array = {7,5,6,4};
		   int result = test.Solution(array);
		   System.out.println(result);
	   }
	}
