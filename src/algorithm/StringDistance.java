package algorithm;

public class StringDistance {
	
	public int solution(String s1, String s2)
	{
		if(s1.equals(null) || s2.equals(null)) return 0;
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i=1; i<s1.length()+1;i++)
		{
			for(int j = 1; j<s2.length()+1;j++)
			{
				if (s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return Math.max(s1.length(),s2.length())-dp[s1.length()][s2.length()];
	}
	
	public static void main(String[] args){
		StringDistance test = new StringDistance();
		System.out.println(test.solution("cat","caaat" ));
	}
}
