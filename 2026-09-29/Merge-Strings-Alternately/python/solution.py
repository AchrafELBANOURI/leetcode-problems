from typing import List, Any


class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        n1 = len(word1)
        n2 = len(word2)
        
        res = []
        p1 = 0
        p2 = 0
        
        while p1 < n1 and p2 < n2:
            if p1 > p2:
                res.append(word2[p2])
                p2 += 1
            elif p1 == p2:
                res.append(word1[p1])
                p1 += 1
        
        while p1 < n1:
            res.append(word1[p1])
            p1 += 1
        
        while p2 < n2:
            res.append(word2[p2])
            p2 += 1
        
        return "".join(res)
    


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

    # Case 1
    word1 = "abc"
    word2 = "pqr"
    output = sol.mergeAlternately(word1, word2)
    expected = "apbqcr"
    assert_test(expected, output, "Test Case 1")

    # Case 2
    word1 = "ab"
    word2 = "pqrs"
    output = sol.mergeAlternately(word1, word2)
    expected = "apbqrs"
    assert_test(expected, output, "Test Case 2")

    # Case 3
    word1 = "abcd"
    word2 = "pq"
    output = sol.mergeAlternately(word1, word2)
    expected = "apbqcd"
    assert_test(expected, output, "Test Case 3")



if __name__ == "__main__":
    main()
