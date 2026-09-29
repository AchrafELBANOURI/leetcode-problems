from typing import List, Any


class Solution:
    def isPalindrome(self, s: str) -> bool:
        left, right = 0, len(s) - 1
        
        while left < right:
            while left < right and not s[left].isalnum():
                left += 1
        
            while left < right and not s[right].isalnum():
                right -= 1
        
            if s[left].lower() != s[right].lower():
                return False
        
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
    s = "A man, a plan, a canal: Panama"
    output = sol.isPalindrome(s)
    expected = True
    assert_test(expected, output, "Test Case 1")

    # Case 2
    s = "race a car"
    output = sol.isPalindrome(s)
    expected = False
    assert_test(expected, output, "Test Case 2")

    # Case 3
    s = " "
    output = sol.isPalindrome(s)
    expected = True
    assert_test(expected, output, "Test Case 3")



if __name__ == "__main__":
    main()
