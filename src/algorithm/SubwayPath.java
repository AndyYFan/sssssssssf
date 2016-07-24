package algorithm;

import java.util.*;


public class SubwayPath {
	ArrayList<LinkedList<Integer>> line = new ArrayList<LinkedList<Integer>>();
	public static void main(String[] args)
	{
		SubwayPath test = new SubwayPath();
		int[] Station = {1,2,3,4};
		test.addline(1,4,Station);
		int[] Station2 = {5,3,7,8,9};
		test.addline(2,5,Station2);
		System.out.println(test.ShortestPath(5, 4));


	}

	public  void addline(int lineNo, int stationNum, int[] Station ) {


		for(int i = 0; i< stationNum-1;i++)
		{
			LinkedList<Integer> St2St = new LinkedList<Integer>();
			St2St.add(Station[i]);
			St2St.add(Station[i+1]);
			line.add(St2St);
			LinkedList<Integer>RevSt2St = new LinkedList<Integer>(St2St);
			Collections.reverse(RevSt2St);
			line.add(RevSt2St);

		}


	}



	public  LinkedList<LinkedList<Integer>> ShortestPath(int Start,int Dest)
	{
		LinkedList<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
		for(int i =0; i<line.size();i++)
		{
			if (line.get(i).get(0) == Start) {
				result.add(line.get(i));
			}
		}
		int L = line.size()/2;
		while(L-- >0)
		{
			int N = result.size();
			for(int i = 0 ; i< N ;i++)
			{

				for(int j = 0; j<line.size();j++ )
				{
					LinkedList<Integer>temp = new LinkedList<Integer>(result.get(i));
					int p = temp.getLast();
					if ( p == line.get(j).getFirst()) {
						if(!temp.contains(line.get(j).getLast())){
							temp.add(line.get(j).getLast());
							result.add(temp);
						}    
					}
					if (result.getLast().getLast()==Dest)   
						L = result.getLast().size();
					if (result.getLast().size()>L) {
						result.pollLast(); 
						return selectPath(result,Dest);
					}
				}

			}
			while(N-- >0)
			{
				result.pollFirst();
			}
		}
		return result;
	}
	public LinkedList<LinkedList<Integer>> selectPath(LinkedList<LinkedList<Integer>>Paths,int Dest)
	{
		LinkedList<LinkedList<Integer>> result = new  LinkedList<LinkedList<Integer>>();
		for(LinkedList<Integer>p:Paths){
			if (p.getLast()==Dest) result.add(p);
		}
		return  result;
	}
}