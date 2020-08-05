package leetcode;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int end = nums1.length - 1;
        while (end >= 0) {
            if (n == -1) return;
            if (m >= 0 && nums1[m] > nums2[n]) {
                nums1[end] = nums1[m];
                m--;
            } else {
                nums1[end] = nums2[n];
                n--;
            }
            end--;
        }
    }
}
