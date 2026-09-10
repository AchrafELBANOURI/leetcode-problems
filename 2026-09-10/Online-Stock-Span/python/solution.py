from typing import Any, List, Optional


class StockSpanner:

    def __init__(self):
        self.stack: List[List[int]] = []

    def next(self, price: int) -> int:
        span = 1
        while self.stack and self.stack[-1][0] <= price:
            span += self.stack.pop()[1]
        self.stack.append([price, span])
        return span


class Solution:

    @staticmethod
    def operations(ops: List[str], values: List[int]) -> List[Optional[Any]]:
        if ops[0] != "StockSpanner":
            raise ValueError("StockSpanner Operation Must be the first One")

        output: List[Optional[Any]] = []
        spanner = StockSpanner()
        output.append(None)

        for i in range(1, len(ops)):
            op = ops[i]
            if op == "next":
                output.append(spanner.next(values[i]))
            else:
                raise ValueError(
                    f"Unexpected Operation Name -- Allowed Operations : StockSpanner - next , index : {i}"
                )

        return output


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    # Test Case 1 -- StockSpanner
    input_ops = [
        "StockSpanner",
        "next",
        "next",
        "next",
        "next",
        "next",
        "next",
        "next",
    ]
    input_values = [0, 100, 80, 60, 70, 60, 75, 85]

    output = Solution.operations(input_ops, input_values)
    expected = [None, 1, 1, 1, 2, 1, 4, 6]

    assert_test(expected, output, "Test Case -- StockSpanner")


if __name__ == "__main__":
    main()