# Daily LeetCode Problem - August 09, 2026

## Problem

[LeetCode 169. Majority Element](https://leetcode.com/problems/majority-element/)

## Problem Statement

Given an array `nums` of size `n`, return _the majority element_.

The majority element is the element that appears more than $\lfloor n / 2 \rfloor$ times.

# Daily LeetCode Problem - August 09, 2026

## Problem

[LeetCode 169. Majority Element](https://leetcode.com/problems/majority-element/)

## Problem Statement

Given an array `nums` of size `n`, return the majority element.

The majority element is defined as the element that appears more than $\lfloor n / 2 \rfloor$ times. You may assume that the majority element always exists in the array.

## Solutions

### Java Solution

Located in [`java/Solution.java`](java/Solution.java)

#### Approach

The Java solution utilizes **Boyer-Moore Voting Algorithm**:

1. Maintain a `candidate` variable and a `count` initialized to `0`.
2. Iterate through each element in `nums`.
3. If `count` reaches `0`, update `candidate` to the current number.
4. Increment `count` if the current number equals `candidate`; otherwise, decrement `count`.
5. Since the majority element appears more than $\lfloor n / 2 \rfloor$ times, it will always be the remaining candidate at the end of the iteration.

```java
public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
```

#### Complexity Analysis

- **Time Complexity:** $\mathcal{O}(N)$ — Performs a single pass over the array of $N$ elements.
- **Space Complexity:** $\mathcal{O}(1)$ — Operates strictly in constant auxiliary memory.

### Python Solution

Located in [`python/solution.ipynb`](python/solution.ipynb)

#### Approach

The Python implementation leverages a **Frequency Counter Mapping** approach:

1. Count element frequencies across `nums` using `collections.Counter`.
2. Retrieve the element key associated with the maximum frequency count via `max(freq, key=freq.get)`.

```python
from collections import Counter
from typing import List

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        freq = Counter(nums)
        return max(freq, key=freq.get)
```

#### Complexity Analysis

- **Time Complexity:** $\mathcal{O}(N)$ — Building the frequency map takes $\mathcal{O}(N)$ time, followed by finding the maximum key in $\mathcal{O}(U)$ time, where $U \le N$ is the number of unique elements.
- **Space Complexity:** $\mathcal{O}(N)$ — Stores counts for up to $N$ elements in the dictionary/hash map.

## Notes/Explanation

### Key Insights

- **Boyer-Moore Voting Logic:** The voting algorithm relies on pairing opposing elements to cancel each other out. Because the majority element occupies strictly more than half of the array positions, its count can never be entirely wiped out by all non-majority elements combined.
- **Trade-off Between Approaches:**
  - **Boyer-Moore (Java):** Achieves optimal $\mathcal{O}(1)$ space complexity while running in linear time.
  - **Hash Map Counter (Python):** Offers high readability and rapid development, though at the cost of $\mathcal{O}(N)$ additional memory.
