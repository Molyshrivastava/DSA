class Solution {

 public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    private int[] mergeSort(int[] nums, int l, int r) {
        if(l>=r) {
            return new int[]{nums[l]};
        }

        int m = (l+r)/2;

        int[] left = mergeSort(nums, l, m);
        int[] right = mergeSort(nums, m+1, r);

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int i=0, j=0, k=0, m=left.length, n=right.length;

        int[] ans = new int[m+n];

        while(i<m && j<n) {
            ans[k++] = left[i] < right[j] ? left[i++] : right[j++];
        }
        while(i<m) {
            ans[k++] = left[i++];
        }
        while(j<n) {
            ans[k++] = right[j++];
        }

        return ans;
    } 
}