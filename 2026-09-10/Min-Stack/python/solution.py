from typing import Any, List, Optional


class MinStack:
    def __init__(self):
        self.stack: List[int] = []
        self.min_stack: List[int] = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        min_val = min(val, self.min_stack[-1] if self.min_stack else val)
        self.min_stack.append(min_val)

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]


class Solution:
    @staticmethod
    def operations(ops: List[str], values: List[int]) -> List[Optional[Any]]:
        if ops[0] != "MinStack":
            raise ValueError("MinStack Operation Must be the first One")

        output: List[Optional[Any]] = []
        stack = MinStack()
        output.append(None)

        for i in range(1, len(ops)):
            op = ops[i]
            if op == "push":
                stack.push(values[i])
                output.append(None)
            elif op == "pop":
                stack.pop()
                output.append(None)
            elif op == "top":
                output.append(stack.top())
            elif op == "getMin":
                output.append(stack.getMin())
            else:
                raise ValueError(
                    f"Unexpected Operation Name -- Allowed Operations : MinStack - push - pop - top - getMin , index : {i}"
                )

        return output


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    # Test Case 1 -- Min Stack
    input_ops = ["MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"]
    input_values = [0, -2, 0, -3, 0, 0, 0, 0]

    output = Solution.operations(input_ops, input_values)
    expected = [None, None, None, None, -3, None, 0, -2]

    assert_test(expected, output, "Test Case -- Min Stack")


if __name__ == "__main__":
    main()