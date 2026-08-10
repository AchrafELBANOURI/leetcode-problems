# Daily LeetCode Problem - August 10, 2026

## Problem

[Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)

## Problem Statement

Given an array of integers `nums` and an integer `k`, return the total number of subarrays whose sum equals to `k`.

A subarray is a contiguous non-empty sequence of elements within an array.

### Example 1

```text
Input: nums = [1,1,1], k = 2
Output: 2
```

### Example 2

```text
Input: nums = [1,2,3], k = 3
Output: 2
```

## Solutions

### Java Solution

Located in [`java/subarraySumEqualsK/Solution.java`](java/subarraySumEqualsK/Solution.java)

#### Approach

We use a **Prefix Sum + HashMap** approach. As we iterate through `nums`, we track the running total (`prefixSum`).

For any index $i$, if there exists a previous prefix sum equal to $\text{prefixSum} - k$, then the subarray between that previous index and $i$ sums to $k$. We maintain a frequency map of all seen prefix sums to achieve $O(1)$ lookup time per element.

```java
package subarraySumEqualsK;

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixFrequencies = new HashMap<>();
        prefixFrequencies.put(0, 1);

        int prefixSum = 0;
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            total += prefixFrequencies.getOrDefault(prefixSum - k, 0);
            prefixFrequencies.put(prefixSum, prefixFrequencies.getOrDefault(prefixSum, 0) + 1);
        }

        return total;
    }
}
```

#### Complexity Analysis

- **Time Complexity:** $O(N)$ — Single pass through the array of length $N$. HashMap lookups and updates run in $O(1)$ average time.
- **Space Complexity:** $O(N)$ — In the worst case, the HashMap stores up to $N + 1$ distinct prefix sums.

---

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The algorithm follows the exact same **Prefix Sum + Hash Table** strategy as the Java implementation. We use a Python `dict` with `.get(key, default)` to count prefix sum frequencies dynamically.

```python
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefix_frequencies = {0: 1}
        prefix_sum = 0
        total = 0

        for num in nums:
            prefix_sum += num
            total += prefix_frequencies.get(prefix_sum - k, 0)
            prefix_frequencies[prefix_sum] = prefix_frequencies.get(prefix_sum, 0) + 1

        return total
```

#### Complexity Analysis

- **Time Complexity:** $O(N)$ — Linear scan through `nums` with $O(1)$ dictionary operations.
- **Space Complexity:** $O(N)$ — The `prefix_frequencies` dictionary holds at most $N + 1$ keys.

## Notes/Explanation

- **Why initialize `{0: 1}`?**  
  A prefix sum of `0` occurring once handles cases where a subarray starting from index `0` itself sums to `k` (i.e., $\text{prefixSum} - k = 0$).
- **Handling Negative Numbers:**  
  Because `nums` can contain negative integers, the prefix sum is non-monotonic. A standard sliding window / two-pointer approach fails here, making the Hash Table approach necessary.
