class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res=new int[m+n];
        int i=0;
        for(int x=m;x<nums1.length;x++){
            
                nums1[x]=nums2[i];
                i++;
            
        }
        Arrays.sort(nums1);
        for(int x=0;x<nums1.length;x++){
            System.out.print(nums1[x]+" ");
        }
        return;
    }
}