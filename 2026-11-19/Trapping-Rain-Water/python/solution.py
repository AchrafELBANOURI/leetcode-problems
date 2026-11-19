from typing import List, Any


class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        left, right = 0, n - 1
        left_max = right_max = 0
        total_water = 0
        
        while left < right:
            if height[left] < height[right]:
                if left_max > height[left]:
                    total_water += left_max - height[left]
                else:
                    left_max = height[left]
                left += 1
            else:
                if right_max > height[right]:
                    total_water += right_max - height[right]
                else:
                    right_max = height[right]
                right -= 1
        
        return total_water
    


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

    # Case 1
    height = [0,1,0,2,1,0,1,3,2,1,2,1]
    output = sol.trap(height)
    expected = 6
    assert_test(expected, output, "Test Case 1")

    # Case 2
    height = [4,2,0,3,2,5]
    output = sol.trap(height)
    expected = 9
    assert_test(expected, output, "Test Case 2")



if __name__ == "__main__":
    main()
