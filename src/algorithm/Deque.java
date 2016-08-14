import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {

            stack1.push(node);
        
        
    }
    
    public int pop() {
        if(stack1.isEmpty() && stack2.isEmpty())
        {
            return -1;
        }
    	if(!stack2.isEmpty())
        {
           int result = stack2.peek();
			stack2.pop();
            return result;
        }
        else
        {
           while(!stack1.isEmpty())
           {
               stack2.push(stack1.peek());
               stack1.pop();
           }
           int result = stack2.peek();
            stack2.pop();
            return result;
        }
    }
}