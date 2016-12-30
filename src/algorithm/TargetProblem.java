#// 打靶问题   10发打90 环的所有可能

	    public class shootGame {
    
    	public static void main(String[] args){
    
    		int[] nums = new int[11];
    		for(int i=0;i<11;i++){
    			nums[i] = i;
    		}
    		List<List<Integer>> list = new ArrayList<>();
    		dfs(nums,list,new ArrayList<Integer>(),0,90);
    		
    			
    	}
    
    	private static void dfs(int[] nums, List<List<Integer>> list, ArrayList<Integer> temp, int start,int target) {
    		
    		//收敛条件
    		if(target == 0){
    		
    		//当提前完成指定环数后，剩下的补0
    			if(temp.size()<10){
    				for(int i=0;i<10-temp.size();i++){
    					temp.add(0);
    				}
    			}
    			Tool.print(temp);
    			list.add(new ArrayList(temp));
    			return;
    		}
    		
    		//剪枝
    		if(target>10*(10-start))   
    			return;
    		
    		//终止条件
    		if(start == 10) return;
    		
    		//从后向前遍历，减少复杂度
    		for(int i=10; i>=0;i--){
    			temp.add(nums[i]);
    			dfs(nums, list, temp, start+1, target-nums[i]);
    			temp.remove(temp.size()-1);
    		}
    	}
    }

