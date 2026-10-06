# Daily LeetCode Problem - October 06, 2026

## Problem

[4Sum](https://leetcode.com/problems/4sum/)

## Problem Statement

Given an array `nums` of `n` integers, return all unique quadruplets `[nums[a], nums[b], nums[c], nums[d]]` such that:

- `0 <= a < b < c < d < n`
- `nums[a] + nums[b] + nums[c] + nums[d] == target`

The solution set must not contain duplicate quadruplets.

### Example 1

```text
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
```

### Example 2

```text
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
```

## Solutions

### Java Solution

Located in [`java/fourSum/Solution.java`](java/fourSum/Solution.java)

#### Approach

We sort the array first, then use a **nested loop + two-pointer** strategy.

- Fix the first two numbers with two outer loops.
- Use two pointers (`left` and `right`) for the remaining pair.
- Skip duplicates to prevent repeated quadruplets.
- Use pruning checks with the smallest and largest possible sums for the remaining indices to reduce unnecessary work.

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        if (n < 4) return result;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return result;
    }
}
```

#### Complexity Analysis

- **Time Complexity:** $O(N^3)$ — the outer loops are $O(N^2)$ and the two-pointer scan adds another linear factor.
- **Space Complexity:** $O(1)$ auxiliary space, excluding the output list.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

The Python implementation follows the same strategy as the Java version:

- sort the array
- fix `i` and `j`
- use a `left` and `right` pointer to find the remaining pair
- skip duplicate indices and duplicate quadruplets

```python
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        n = len(nums)
        if n < 4:
            return []

        nums.sort()
        result = []

        for i in range(n - 3):
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            for j in range(i + 1, n - 2):
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue

                left = j + 1
                right = n - 1

                while left < right:
                    current_sum = nums[i] + nums[j] + nums[left] + nums[right]

                    if current_sum == target:
                        result.append([nums[i], nums[j], nums[left], nums[right]])
                        left += 1
                        right -= 1

                        while left < right and nums[left] == nums[left - 1]:
                            left += 1

                        while left < right and nums[right] == nums[right + 1]:
                            right -= 1

                    elif current_sum < target:
                        left += 1
                    else:
                        right -= 1

        return result
```

#### Complexity Analysis

- **Time Complexity:** $O(N^3)$ — the total number of combinations is cubic in the size of the input.
- **Space Complexity:** $O(1)$ auxiliary space, excluding the final output list.

## Notes/Explanation

- Sorting is essential because it allows duplicate skipping and the two-pointer approach.
- The algorithm avoids duplicate quadruplets by checking neighboring equal values before moving pointers.
- The sum is computed using `long` in Java to avoid overflow when adding up four numbers, especially with large values.
- The result remains in sorted order because the array was sorted before processing.
