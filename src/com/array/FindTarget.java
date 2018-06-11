package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTarget {

	/**
	 * 从正整数组中找出任意俩个数的和为target的数字位置
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int[] findTarget(int[] arr, int target) {
		/*final int len = arr == null ? 0 : arr.length;
		for(int i = 0; i < len - 1; i++) {
			for(int j = i+1; j < len; j++) {
				int x = arr[i];
				int y = arr[j];
				if(x + y == target) {
					return new int[]{i, j};
				}
			}
		}
		return null;*/

		/**
		 * 空间换时间
		 */
		Map<Integer, Integer> map = new HashMap<>();
		final int len = arr == null ? 0 : arr.length;
		for(int i = 0; i < len - 1; i++) {
			int diff = target - arr[i];
			if(map.containsKey(arr[i])) {
				return new int[]{map.get(arr[i]), i};
			}
			map.put(diff, i);
		}
		return null;


	}

	public static int[] twoSum(int[] nums, int target) {
		final int len = nums == null ? 0 : nums.length;
		Map<Integer, Integer> map = new HashMap<>();

		int[] result = new int[2];
		for(int i = 0; i < len; i++) {
			int diff = target - nums[i];
			if(map.containsKey(diff)) {
				result[0] = map.get(diff);
				result[1] = i;
				break;
			}
			map.put(nums[i], i);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = {16,7,11,2, 6, 3};
		int[] a = twoSum(arr, 9);
		if(a == null || a.length <= 0) return;
		for (int i : a) {
			System.out.println(i);
		}

		
	}
	
}
