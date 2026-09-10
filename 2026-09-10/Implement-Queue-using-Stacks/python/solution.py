from typing import Any, List, Optional


class MyQueue:
    def __init__(self):
        self.stack: List[int] = []
        self.swap: List[int] = []

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        n = len(self.stack)
        for _ in range(n - 1):
            self.swap.append(self.stack.pop())
        top = self.stack.pop()
        for _ in range(n - 1):
            self.stack.append(self.swap.pop())
        self.swap = []
        return top

    def peek(self) -> int:
        n = len(self.stack)
        for _ in range(n - 1):
            self.swap.append(self.stack.pop())
        top = self.stack.pop()
        self.swap.append(top)
        for _ in range(n):
            self.stack.append(self.swap.pop())
        self.swap = []
        return top

    def empty(self) -> bool:
        return len(self.stack) == 0


class Solution:
    @staticmethod
    def operations(ops: List[str], values: List[int]) -> List[Optional[Any]]:
        if ops[0] != "MyQueue":
            raise ValueError("MyQueue Operation Must be the first One")

        output: List[Optional[Any]] = []
        queue = MyQueue()
        output.append(None)

        for i in range(1, len(ops)):
            op = ops[i]
            if op == "push":
                queue.push(values[i])
                output.append(None)
            elif op == "pop":
                output.append(queue.pop())
            elif op == "peek":
                output.append(queue.peek())
            elif op == "empty":
                output.append(queue.empty())
            else:
                raise ValueError(
                    f"Unexpected Operation Name -- Allowed Operations : MyQueue - push - pop - peek - empty , index : {i}"
                )

        return output


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    # Test Case 1 -- Two Stacks Queue
    input_ops = ["MyQueue", "push", "push", "peek", "pop", "empty"]
    input_values = [0, 1, 2, 0, 0, 0]

    output = Solution.operations(input_ops, input_values)
    expected = [None, None, None, 1, 1, False]

    assert_test(expected, output, "Test Case -- Two Stacks Queue")


if __name__ == "__main__":
    main()