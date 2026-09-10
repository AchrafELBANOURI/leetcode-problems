from typing import List, Any


class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        n = len(position)
        if n == 0:
            return 0

        # Position array has unique values between 0 and target
        time = [0.0] * (target + 1)

        for i in range(n):
            time[position[i]] = (target - position[i]) / speed[i]

        fleets = 0
        current_time_fleet = 0.0

        for i in range(target, -1, -1):
            current_time = time[i]

            if current_time > current_time_fleet:
                fleets += 1
                current_time_fleet = current_time

        return fleets


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

	# Case 1
    target = 12
    position = [10,8,0,5,3]
    speed = [2,4,1,1,3]
    output = sol.carFleet(target, position, speed)
    expected = 3
    assert_test(expected, output, "Test Case 1")

	# Case 2
    target = 10
    position = [3]
    speed = [3]
    output = sol.carFleet(target, position, speed)
    expected = 1
    assert_test(expected, output, "Test Case 2")

    # Case 3
    target = 100
    position = [0,2,4]
    speed = [4,2,1]
    output = sol.carFleet(target, position, speed)
    expected = 1
    assert_test(expected, output, "Test Case 3")



if __name__ == "__main__":
    main()
