class Solution {
    public int longestConsecutive(int[] nums) {
         HashMap<Integer,Boolean> map=new HashMap<>();
         int longestLength=0;
         for(int num:nums){
            map.put(num,false);
         }
         for(int num: nums){
            int currentLength=1;
      
      //check forward direction
            int nextNum=num+1;
            while(map.containsKey(nextNum) && map.get(nextNum)==false){
           currentLength++;
           map.put(nextNum,true);
           nextNum++; //increment next num
            }


//check reverse direction
int prevNum=num-1;
            while(map.containsKey(prevNum) && map.get(prevNum)==false){
           currentLength++;
           map.put(prevNum,true);
           prevNum--; //decrement prev num
            }
longestLength=Math.max(longestLength,currentLength);
         }
         return longestLength;
    }
}