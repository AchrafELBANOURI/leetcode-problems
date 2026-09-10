from typing import List, Any


class Solution:
    def moveZeroes(self, nums: List[int]) -> Any:
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0 :
                nums[i] , nums[j] = nums[j] , nums[i]
                j+=1
    


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

    # Case 1
    nums = [0,1,0,3,12]
    sol.moveZeroes(nums)
    expected = [1,3,12,0,0]
    assert_test(expected, nums, "Test Case 1")

    # Case 2
    nums = [0]
    sol.moveZeroes(nums)
    expected = [0]
    assert_test(expected, nums, "Test Case 2")



if __name__ == "__main__":
    main()
