from typing import List, Any


class Solution:
    def decodeString(self, s: str) -> str:
        count_stack: List[int] = []
        string_stack: List[List[str]] = []
    
        current_string: List[str] = []
        current_num: int = 0
    
        for c in s:
            if c.isdigit():
                current_num = current_num * 10 + int(c)
            elif c == "[":
                count_stack.append(current_num)
                string_stack.append(current_string)
    
                current_string = []
                current_num = 0
            elif c == "]":
                repeat_count = count_stack.pop()
                prev_string = string_stack.pop()
    
                prev_string.append("".join(current_string) * repeat_count)
                current_string = prev_string
            else:
                current_string.append(c)
    
        return "".join(current_string)
    


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

    # Case 1
    s = "3[a]2[bc]"
    output = sol.decodeString(s)
    expected = "aaabcbc"
    assert_test(expected, output, "Test Case 1")

    # Case 2
    s = "3[a2[c]]"
    output = sol.decodeString(s)
    expected = "accaccacc"
    assert_test(expected, output, "Test Case 2")

    # Case 3
    s = "2[abc]3[cd]ef"
    output = sol.decodeString(s)
    expected = "abcabccdcdcdef"
    assert_test(expected, output, "Test Case 3")



if __name__ == "__main__":
    main()
