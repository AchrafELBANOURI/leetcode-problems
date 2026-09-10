# Daily LeetCode Problem - September 10, 2026

## Problem

[853. Car Fleet](https://leetcode.com/problems/car-fleet/)

## Problem Statement

There are `n` cars at given miles away from the starting mile 0, traveling to a destination mile `target`.

You are given two integer arrays `position` and `speed`, both of length `n`, where `position[i]` is the starting position of the $i^{\text{th}}$ car and `speed[i]` is the speed of the $i^{\text{th}}$ car in miles per hour.

A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed. The faster car will **slow down** to match the slower car's speed. The distance between these two cars is ignored (i.e., they are assumed to have the same position).

A **car fleet** is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.

If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.

Return _the number of car fleets that will arrive at the destination_.

## Solutions

### Java Solution

Located in [`java/carFleet/Solution.java`](java/carFleet/Solution.java)

#### Approach

Direct array bucket sorting by target distance: leveraged the constraint that positions are unique integer coordinates within `[0, target]` to eliminate sorting step comparisons.

1. **Bucket Array Initialization:**
   - Created a float array `time` of size `target + 1`.
   - Iterated through all $N$ cars and computed time to target: `(target - position[i]) / speed[i]`, placing the time value directly into index `position[i]`.
2. **Reverse Target Iteration:**
   - Iterated backwards from `target` down to `0` (processing cars closest to the destination first).
   - Maintained `currentTimeFleet` tracking the bottleneck time of the lead fleet ahead.
   - If a trailing car's time (`currentTime`) is strictly greater than `currentTimeFleet`, it can never catch up before reaching `target`. Formed a new fleet (`fleets++`) and updated `currentTimeFleet = currentTime`.
   - If `currentTime <= currentTimeFleet`, the car catches up and merges into the existing lead fleet.

#### Complexity Analysis

- **Time Complexity:** $O(\text{target} + N)$ linear time. Avoids $O(N \log N)$ sorting by using direct index position mapping.
- **Space Complexity:** $O(\text{target})$ space for the `time` bucket array.

---

### Python Solution

Located in [`python/solution.py`](python/solution.py)

#### Approach

Mirrored the position-indexed array bucket approach using a pre-allocated floating-point list and reverse traversal.

1. **Bucket Time Allocation:**
   - Allocated `time = [0.0] * (target + 1)`.
   - Mapped calculated arrival times `(target - position[i]) / speed[i]` directly to `time[position[i]]`.
2. **Fleet Counting Loop:**
   - Traversed from `target` down to `0` using `range(target, -1, -1)`.
   - Counted fleets by comparing arrival times against `current_time_fleet`.
3. **Execution Driver:** Ran automated verification across test scenarios using `sol.carFleet` and validated outputs via `assert_test`.

#### Complexity Analysis

- **Time Complexity:** $O(\text{target} + N)$ execution time.
- **Space Complexity:** $O(\text{target})$ space to hold arrival time buckets.

---

## Notes/Explanation

- **Bottleneck Principle:** A car closer to the target setting a higher arrival time acts as a bottleneck. Any car behind it that arrives in equal or less time will eventually catch up and slow down to merge into its fleet.
- **Eliminating $O(N \log N)$ Sort:** Standard solutions sort `(position, speed)` tuples in descending order of position taking $O(N \log N)$ time. Using the position value itself as an array index maps elements into sorted order in $O(N)$ time, achieving an $O(\text{target} + N)$ bound.
