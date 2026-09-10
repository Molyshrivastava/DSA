class Solution {
    public void mergeSort(int[] arr,int low,int high){
        if(low>=high)
        return ;
        int mid=(low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    public void merge(int[] arr,int low,int mid,int high){
        List<Integer> tmp=new ArrayList<Integer>();
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high){
if(arr[left]<arr[right]){
    tmp.add(arr[left]);
    left++;
}
else{
    tmp.add(arr[right]);
right++;
}
        }
        while(left<=mid){
            tmp.add(arr[left]);
left++;
        }
        while(right<=high){
            tmp.add(arr[right]);
       right++;
        }
        for(int i=low;i<=high;i++){
            arr[i]=tmp.get(i-low);
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}