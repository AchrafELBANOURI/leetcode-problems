from typing import List, Any

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        stack_indices = [0] * n
        answer = [0] * n
        top = 0

        for i in range(n - 1, -1, -1):
            day_temp = temperatures[i]

            while top > 0 and temperatures[stack_indices[top - 1]] <= day_temp:
                top -= 1

            if top > 0:
                answer[i] = stack_indices[top - 1] - i

            stack_indices[top] = i
            top += 1

        return answer


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

	# Case 1
    temperatures = [73,74,75,71,69,72,76,73]
    output = sol.dailyTemperatures(temperatures)
    expected = [1,1,4,2,1,1,0,0]
    assert_test(expected, output, "Test Case 1")

    # Case 2
    temperatures = [30,40,50,60]
    output = sol.dailyTemperatures(temperatures)
    expected = [1,1,1,0]
    assert_test(expected, output, "Test Case 2")

    # Case 3
    temperatures = [30,60,90]
    output = sol.dailyTemperatures(temperatures)
    expected = [1,1,0]
    assert_test(expected, output, "Test Case 3")



if __name__ == "__main__":
    main()
