class Solution {
    public static boolean splitPossible(int[] arr,int mid,int k){
        int subarray=1,cntElement=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>mid)
            return false;
            else if(cntElement+arr[i]>mid){
                subarray++;
                cntElement=arr[i];
            }
            else
            cntElement+=arr[i];
        }
             
        if(subarray>k)
        return false;
        else
        return true;

    }
    public int splitArray(int[] nums, int k) {
        int low=Integer.MAX_VALUE,high=0,ans=-1;
        for(int i=0;i<nums.length;i++){
            high+=nums[i];
            if(low>nums[i])
            low=nums[i];
        }
    while(low<=high){
        int mid =(low+high)/2;
        if(splitPossible(nums,mid,k)){
            ans=mid;
            high=mid-1;
        }
        else
        low=mid+1;
    }
return ans;
    }
}