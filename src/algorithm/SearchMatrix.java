package algorithm;

public class SearchMatrix {
	
	public boolean Find(int [][] array,int target) {
		int row = array.length;
        int column = array[0].length;
        if(row==0 || column ==0) return false;
        for(int i = 0, j= column-1; i<row && j>=0 ;)
        {
        	if(array[i][j] < target)
            {
               i++;
            }
            else if(array[i][j] > target)
            {
                j--;
            }
            else return true;
        }
        
        return false;
    }
}