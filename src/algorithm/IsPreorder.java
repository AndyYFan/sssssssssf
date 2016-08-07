package algorithm;

import java.util.Stack;
import java.util.StringTokenizer;

public class IsPreorder {
    public boolean isValidSerialization(String preorder) {
    	String[] input=preorder.split(",");
          Stack<String>s = new Stack<String>();
          int n = input.length;
          for(int i=0; i< n; i++){
              String c = input[i];
              s.push(c);
              while(s.size()>2 && s.peek().equals("#") && s.get(s.size()-2).equals("#") && !s.get(s.size()-3).equals("#"))
              {
                  s.pop();
                  s.pop();
                  s.pop();
                  s.push("#");
              }
          }
          if(s.size()==1&&s.peek()=="#") return true;
          else return false;
    }
    
    public static void main(String[] args){
    	String a ="9,#,92,#,#";
    	IsPreorder test = new IsPreorder();
    	test.isValidSerialization(a);
    }
}