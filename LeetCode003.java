package test;

public class LeetCode003 {
	class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        int maxsum=0,sum=0;
	        StringBuilder sb = new StringBuilder("");
	        for(int i=0;i<s.length();i++){
	            int k=-1;
	            for(int j=0;j<sb.length();j++){
	                if(sb.charAt(j)==s.charAt(j)){
	                    k=j;break;
	                }
	            }
	            if(k==-1){
	                sum+=1;
	                sb.append(s.charAt(i));
	                if(sum>maxsum){
	                    maxsum=sum;
	                }
	            }
	            else{
	                sb.delete(0,k+1); 
	                sb.append(s.charAt(i));
	                sum=sb.length();
	            }
	        }
	        return maxsum;
	    }
	}
}
