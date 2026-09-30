from typing import List, Any


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> Any:
        p1 = m - 1
        p2 = n - 1
        k = m + n - 1
        
        while p1 >= 0 and p2 >= 0:
            if nums1[p1] < nums2[p2]:
                nums1[k] = nums2[p2]
                p2 -= 1
            else:
                nums1[k] = nums1[p1]
                p1 -= 1
            k -= 1
        
        while p2 >= 0:
            nums1[k] = nums2[p2]
            p2 -= 1
            k -= 1
    


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

    # Case 1
    nums1 = [1,2,3,0,0,0]
    m = 3
    nums2 = [2,5,6]
    n = 3
    sol.merge(nums1, m, nums2, n)
    expected = [1,2,2,3,5,6]
    assert_test(expected, nums1, "Test Case 1")

    # Case 2
    nums1 = [1]
    m = 1
    nums2 = []
    n = 0
    sol.merge(nums1, m, nums2, n)
    expected = [1]
    assert_test(expected, nums1, "Test Case 2")

    # Case 3
    nums1 = [0]
    m = 0
    nums2 = [1]
    n = 1
    sol.merge(nums1, m, nums2, n)
    expected = [1]
    assert_test(expected, nums1, "Test Case 3")



if __name__ == "__main__":
    main()
