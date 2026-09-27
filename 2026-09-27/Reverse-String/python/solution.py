from typing import List, Any


class Solution:
    def reverseString(self, s: Any) -> Any:
        i, j = 0, len(s) - 1
        while i < j:
            s[i], s[j] = s[j], s[i]  # Swaps elements without a temporary variable
            i += 1
            j -= 1
    


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

    # Case 1
    s = ["h","e","l","l","o"]
    sol.reverseString(s)
    expected = ["o","l","l","e","h"]
    assert_test(expected, s, "Test Case 1")

    # Case 2
    s = ["H","a","n","n","a","h"]
    sol.reverseString(s)
    expected = ["h","a","n","n","a","H"]
    assert_test(expected, s, "Test Case 2")



if __name__ == "__main__":
    main()
