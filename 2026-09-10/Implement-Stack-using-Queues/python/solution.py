from collections import deque
from typing import Any, List, Optional


class MyStack:
    def __init__(self):
        self.queue = deque()

    def push(self, x: int) -> None:
        self.queue.append(x)

    def pop(self) -> int:
        n = len(self.queue)
        for _ in range(n - 1):
            self.queue.append(self.queue.popleft())
        return self.queue.popleft()

    def top(self) -> int:
        n = len(self.queue)
        for _ in range(n - 1):
            self.queue.append(self.queue.popleft())
        top_val = self.queue.popleft()
        self.queue.append(top_val)
        return top_val

    def empty(self) -> bool:
        return not self.queue


class Solution:
    @staticmethod
    def operations(ops: List[str], values: List[int]) -> List[Optional[Any]]:
        if ops[0] != "MyStack":
            raise ValueError("MyStack Operation Must be the first One")

        output: List[Optional[Any]] = []
        stack = MyStack()
        output.append(None)

        for i in range(1, len(ops)):
            op = ops[i]
            if op == "push":
                stack.push(values[i])
                output.append(None)
            elif op == "pop":
                output.append(stack.pop())
            elif op == "top":
                output.append(stack.top())
            elif op == "empty":
                output.append(stack.empty())
            else:
                raise ValueError(
                    f"Unexpected Operation Name -- Allowed Operations : MyStack - push - pop - top - empty , index : {i}"
                )

        return output


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    # Test Case 1 -- One Queue Stack
    input_ops = ["MyStack", "push", "push", "top", "pop", "empty"]
    input_values = [0, 1, 2, 0, 0, 0]

    output = Solution.operations(input_ops, input_values)
    expected = [None, None, None, 2, 2, False]

    assert_test(expected, output, "Test Case -- One Queue Stack")


if __name__ == "__main__":
    main()