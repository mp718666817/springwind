package Algorithm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindMedianSortedArrays {
    public Set<Integer> findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int[] a = new int[nums1.length+nums2.length];
    	int n = 0;
    	for (int i = 0; i < a.length; i++) {
			if (nums1[n]>nums2[n]) {
				a[i] = nums1[];
			}
		}
    }
    public static void main(String[] args) {
		FindMedianSortedArrays f1 = new FindMedianSortedArrays();
		int[] nums1 = new int [] {1,3,5,6,7,9};
		int[] nums2 = new int [] {2,3,6,8,10,15};
		Set<Integer> set = f1.findMedianSortedArrays(nums1, nums2);
		for (Integer integer : set) {
			System.out.println(integer);
		}
	}
}
