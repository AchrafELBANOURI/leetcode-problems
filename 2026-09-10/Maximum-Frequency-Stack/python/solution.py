from collections import defaultdict
from typing import Any, Dict, List, Optional


class FreqStack:

    def __init__(self):
        self.frequency_levels: Dict[int, List[int]] = defaultdict(list)
        self.value_freq: Dict[int, int] = defaultdict(int)
        self.max_freq: int = 0

    def push(self, val: int) -> None:
        curr_val_freq = self.value_freq[val] + 1
        self.value_freq[val] = curr_val_freq

        self.frequency_levels[curr_val_freq].append(val)

        if self.max_freq < curr_val_freq:
            self.max_freq = curr_val_freq

    def pop(self) -> int:
        level_freq_stack = self.frequency_levels[self.max_freq]
        most_freq_element = level_freq_stack.pop()
        self.value_freq[most_freq_element] -= 1

        if not level_freq_stack:
            self.max_freq -= 1

        return most_freq_element


class Solution:

    @staticmethod
    def operations(ops: List[str], values: List[int]) -> List[Optional[Any]]:
        if ops[0] != "FreqStack":
            raise ValueError("FreqStack Operation Must be the first One")

        output: List[Optional[Any]] = []
        stack = FreqStack()
        output.append(None)

        for i in range(1, len(ops)):
            op = ops[i]
            if op == "push":
                stack.push(values[i])
                output.append(None)
            elif op == "pop":
                output.append(stack.pop())
            else:
                raise ValueError(
                    f"Unexpected Operation Name -- Allowed Operations : FreqStack - push - pop , index : {i}"
                )

        return output


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    # Test Case 1 -- Freq Stack
    input_ops = [
        "FreqStack",
        "push",
        "push",
        "push",
        "push",
        "push",
        "push",
        "pop",
        "pop",
        "pop",
        "pop",
    ]
    input_values = [0, 5, 7, 5, 7, 4, 5, 0, 0, 0, 0]

    output = Solution.operations(input_ops, input_values)
    expected = [None, None, None, None, None, None, None, 5, 7, 5, 4]

    assert_test(expected, output, "Test Case -- Freq Stack")


if __name__ == "__main__":
    main()