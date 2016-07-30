package algorithm;

import java.util.Arrays;

/**
 *  red:0;
 *  white:1;
 *  blue:2;
 * @author AndY
 *
 */
public class NetherlandsFlag {

	public int[] solution(int[]array)
	{
		int begin =0,current = 0;
		int end = array.length-1;
		while(current <= end)
		{
			if (array[current] == 0){
			array = swap(array,current,begin);
			current ++;
			begin ++;
			}
			else if(array[current]==1){
				current++;
			}
			else if(array[current]==2){
				array = swap(array,current,end);
				end--;
			}
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		NetherlandsFlag test = new NetherlandsFlag();
		int[] array = {1,0,1,0,2,2,2,0,1};
		System.out.println(Arrays.toString(test.solution(array)));

	}
	
	public int[] swap(int[]array,int position_a,int position_b){
		int temp = array[position_a];
		array[position_a] = array[position_b];
		array[position_b] = temp;
		return array;
	}

}
