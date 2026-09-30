from typing import List, Any


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        k = 0
        
        for i in range(1, len(nums)):
            if nums[k] != nums[i]:
                k += 1
                nums[k] = nums[i]
            
        return k + 1
    


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

    # Case 1
    nums = [1,1,2]
    output = sol.removeDuplicates(nums)
    expected_value = 2
    expected_nums = [1,2]
    assert_test(expected_value, output, "Test Case 1 -- value")
    assert_test(expected_nums, nums[:2] , "Test Case 1 -- array")


    # Case 2
    nums = [0,0,1,1,1,2,2,3,3,4]
    output = sol.removeDuplicates(nums)
    expected_value = 5
    expected_nums = [0,1,2,3,4]
    assert_test(expected_value, output, "Test Case 2 -- value")
    assert_test(expected_nums, nums[:5], "Test Case 2 -- array")



if __name__ == "__main__":
    main()
