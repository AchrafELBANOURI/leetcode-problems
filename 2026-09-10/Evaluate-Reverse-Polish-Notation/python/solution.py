from typing import Any, List

class Solution:

    def evalRPN(self, tokens: List[str]) -> int:
        stack = [0] * len(tokens)
        top = 0

        for token in tokens:
            match token:
                case "+":
                    stack[top - 2] = stack[top - 2] + stack[top - 1]
                    top -= 1
                case "-":
                    stack[top - 2] = stack[top - 2] - stack[top - 1]
                    top -= 1
                case "*":
                    stack[top - 2] = stack[top - 2] * stack[top - 1]
                    top -= 1
                case "/":
                    # int(...) truncates toward zero, matching Java integer division behavior
                    stack[top - 2] = int(stack[top - 2] / stack[top - 1])
                    top -= 1
                case _:
                    stack[top] = int(token)
                    top += 1

        return stack[top - 1]


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")

def main():
    sol = Solution()

    # Case 1
    tokens = ["2","1","+","3","*"]
    output = sol.evalRPN(tokens)
    expected = 9
    assert_test(expected, output, "Test Case 1")

    # Case 2
    tokens = ["4","13","5","/","+"]
    output = sol.evalRPN(tokens)
    expected = 6
    assert_test(expected, output, "Test Case 2")

    # Case 3
    tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
    output = sol.evalRPN(tokens)
    expected = 22
    assert_test(expected, output, "Test Case 3")



if __name__ == "__main__":
    main()
