from typing import List, Any


class Solution:
    def findMinDifference(self, timePoints: Any) -> int:
        if len(timePoints) > 1440:
            return 0
    
        stocked_minutes = [False] * 1440
    
        for tp in timePoints:
            minute = (
                (ord(tp[0]) - ord("0")) * 600
                + (ord(tp[1]) - ord("0")) * 60
                + (ord(tp[3]) - ord("0")) * 10
                + (ord(tp[4]) - ord("0"))
            )
    
            if stocked_minutes[minute]:
                return 0
            stocked_minutes[minute] = True
    
        min_diff = 1440
        first_minute = -1
        prev_minute = -1
    
        for i in range(1440):
            if stocked_minutes[i]:
                if first_minute == -1:
                    first_minute = i
                else:
                    min_diff = min(min_diff, i - prev_minute)
                prev_minute = i
    
        corner_diff = (first_minute + 1440) - prev_minute
        min_diff = min(min_diff, corner_diff)
    
        return min_diff
    


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

    # Case 1
    timePoints = ["23:59","00:00"]
    output = sol.findMinDifference(timePoints)
    expected = 1
    assert_test(expected, output, "Test Case 1")

    # Case 2
    timePoints = ["00:00","23:59","00:00"]
    output = sol.findMinDifference(timePoints)
    expected = 0
    assert_test(expected, output, "Test Case 2")



if __name__ == "__main__":
    main()
