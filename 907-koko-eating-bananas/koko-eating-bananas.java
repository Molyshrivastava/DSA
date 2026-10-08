class Solution {
    public static long hours(int[] arr,int n){
      long hr=0;
        for(int i=0;i<arr.length;i++){
          hr+= (arr[i] + n - 1) / n;
        }
        return hr;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
          int high = 0;
        for(int i =0;i<piles.length;i++){ // find max of array
         high = Math.max(high,piles[i]);
        }
         int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            long total_hrs=hours(piles,mid);
            if(total_hrs<=h){
                ans=mid;
                high=mid-1;
            }
            else
            low=mid+1;
        }
        return ans;
    }
}