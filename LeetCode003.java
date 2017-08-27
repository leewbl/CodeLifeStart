package test;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxsum=0,sum=0;
        char[] cy = s.toCharArray();
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<cy.length;i++){//time complexcity is O(N)
            int k = inornot(sb,cy[i]);// since this step's time complexcity is O(N),so the total is O(N^2)?
            if(k==-1){
                sum+=1;
                sb.append(cy[i]);
                if(sum>maxsum){
                    maxsum=sum;
                }
            }
            else{
                sb.delete(0,k+1); 
                sb.append(cy[i]);
                sum=sb.length();
            }
        }
        return maxsum;
    }
//if StringBuilder has char c,return index
//else return -1 
//time complexcity is O(N)
    public static int inornot(StringBuilder sbr,char c){
        int j=-1;
        for(int i=0;i<sbr.length();i++){
            if(sbr.charAt(i)==c){
                j=i;break;
            }
        }
        return j;
    }
}
