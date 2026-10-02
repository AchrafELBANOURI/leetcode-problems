from typing import List, Any


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        n = len(numbers)
        left, right = 0, n - 1
        
        while left < right:
            total = numbers[left] + numbers[right]
            
            if total == target:
                return [left + 1, right + 1]
            elif total > target:
                right -= 1
            else:
                left += 1
        
        return [0, 0]
    


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

    # Case 1
    numbers = [2,7,11,15]
    target = 9
    output = sol.twoSum(numbers, target)
    expected = [1,2]
    assert_test(expected, output, "Test Case 1")

    # Case 2
    numbers = [2,3,4]
    target = 6
    output = sol.twoSum(numbers, target)
    expected = [1,3]
    assert_test(expected, output, "Test Case 2")

    # Case 3
    numbers = [-1,0]
    target = -1
    output = sol.twoSum(numbers, target)
    expected = [1,2]
    assert_test(expected, output, "Test Case 3")



if __name__ == "__main__":
    main()
