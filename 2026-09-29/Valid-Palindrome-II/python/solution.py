from typing import List, Any


class Solution:
    def validPalindrome(self, s: str) -> bool:
        def is_palindrome_range(l: int, r: int) -> bool:
            while l < r:
                if s[l] != s[r]:
                    return False
                l += 1
                r -= 1
            return True
        
        left, right = 0, len(s) - 1
        
        while left < right:
            if s[left] != s[right]:
                return is_palindrome_range(
                    left + 1, right
                ) or is_palindrome_range(left, right - 1)
            left += 1
            right -= 1
    
        return True
    


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

    # Case 1
    s = "aba"
    output = sol.validPalindrome(s)
    expected = True
    assert_test(expected, output, "Test Case 1")

    # Case 2
    s = "abca"
    output = sol.validPalindrome(s)
    expected = True
    assert_test(expected, output, "Test Case 2")

    # Case 3
    s = "abc"
    output = sol.validPalindrome(s)
    expected = False
    assert_test(expected, output, "Test Case 3")



if __name__ == "__main__":
    main()
