from typing import List, Any


class Solution:
    def fourSum(self, nums: List[int], target: int) -> Any:
        n = len(nums)
        if n < 4:
            return []
    
        nums.sort()
        result = []
    
        for i in range(n - 3):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
    
            if nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target:
                break
    
            if nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target:
                continue
    
            for j in range(i + 1, n - 2):
                if j > i + 1 and nums[j] == nums[j - 1]:
                    continue
    
                if nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target:
                    break
                if nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target:
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
    


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

    # Case 1
    nums = [1,0,-1,0,-2,2]
    target = 0
    output = sol.fourSum(nums, target)
    expected = [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    assert_test(expected, output, "Test Case 1")

    # Case 2
    nums = [2,2,2,2,2]
    target = 8
    output = sol.fourSum(nums, target)
    expected = [[2,2,2,2]]
    assert_test(expected, output, "Test Case 2")



if __name__ == "__main__":
    main()
