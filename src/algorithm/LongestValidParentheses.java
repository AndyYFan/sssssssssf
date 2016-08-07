package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestValidParentheses {

	public static int longestValidParentheses(String s) {
		 Stack<Integer> stack = new Stack();
			int length = s.length();
			boolean []end = new boolean[length];
			for(int i = 0 ; i < length ; i ++)
			{
			        if(s.charAt(i) == '(')
				    stack.push(i);
			        else if(!stack.isEmpty())
				    end[stack.pop()] = end[i] = true; 
			}
			int nowsum = 0,maxsum = 0;
			for(int i = 0 ; i < length ; i ++)
			{
			    if(end[i] == false)
				    nowsum = 0;
			    else{
				    nowsum ++;
				    if(nowsum > maxsum)
					    maxsum = nowsum;
			    }
			}
			return maxsum;
	}

			public static void main(String[] args) {
				System.out.print(longestValidParentheses("()(()"));
			}

		}
