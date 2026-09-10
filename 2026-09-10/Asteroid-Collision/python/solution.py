from typing import List, Any


class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = [0] * len(asteroids)
        top = 0

        for ast in asteroids:
            destroyed = False

            while top > 0 and stack[top - 1] > 0 and ast < 0:
                top_size = stack[top - 1]
                ast_size = abs(ast)
                if top_size == ast_size:
                    destroyed = True
                    top -= 1
                    break
                elif top_size < ast_size:
                    top -= 1
                else:
                    destroyed = True
                    break

            if not destroyed:
                stack[top] = ast
                top += 1

        return stack[:top]


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

    # Case 1
    asteroids = [5,10,-5]
    output = sol.asteroidCollision(asteroids)
    expected = [5,10]
    assert_test(expected, output, "Test Case 1")

    # Case 2
    asteroids = [8,-8]
    output = sol.asteroidCollision(asteroids)
    expected = []
    assert_test(expected, output, "Test Case 2")

    # Case 3
    asteroids = [10,2,-5]
    output = sol.asteroidCollision(asteroids)
    expected = [10]
    assert_test(expected, output, "Test Case 3")

    # Case 4
    asteroids = [3,5,-6,2,-1,4]
    output = sol.asteroidCollision(asteroids)
    expected = [-6,2,4]
    assert_test(expected, output, "Test Case 4")



if __name__ == "__main__":
    main()
