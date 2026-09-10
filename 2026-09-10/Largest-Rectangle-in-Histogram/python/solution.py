from typing import List, Any


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)
        stack = [0] * (n + 1)
        top = 0
        max_area = 0
    
        for i in range(n + 1):
            current_height = 0 if i == n else heights[i]
    
            while top > 0 and current_height < heights[stack[top - 1]]:
                top -= 1
                height = heights[stack[top]]
                width = i if top == 0 else i - stack[top - 1] - 1
                max_area = max(max_area, height * width)
    
            stack[top] = i
            top += 1
    
        return max_area
    


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

    # Case 1
    heights = [2,1,5,6,2,3]
    output = sol.largestRectangleArea(heights)
    expected = 10
    assert_test(expected, output, "Test Case 1")

    # Case 2
    heights = [2,4]
    output = sol.largestRectangleArea(heights)
    expected = 4
    assert_test(expected, output, "Test Case 2")



if __name__ == "__main__":
    main()
