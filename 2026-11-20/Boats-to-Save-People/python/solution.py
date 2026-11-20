from typing import List, Any


class Solution:
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        freqWeight = [0] * (limit + 1)
        boats = 0
        
        for p in people:
            freqWeight[p] += 1
            
        l, r = 0, limit
        while l <= r:
            if freqWeight[l] == 0:
                l += 1
                continue
            if freqWeight[r] == 0:
                r -= 1
                continue
                
            if l + r > limit:
                boats += freqWeight[r]
                freqWeight[r] = 0
            else:
                mini = freqWeight[r] if freqWeight[l] > freqWeight[r] else freqWeight[l]
                if l == r:
                    boats += mini // 2 + mini % 2
                    break
                    
                boats += mini
                freqWeight[l] -= mini
                freqWeight[r] -= mini
                
        return boats
    


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
    sol = Solution()

    # Case 1
    people = [1,2]
    limit = 3
    output = sol.numRescueBoats(people, limit)
    expected = 1
    assert_test(expected, output, "Test Case 1")

    # Case 2
    people = [3,2,2,1]
    limit = 3
    output = sol.numRescueBoats(people, limit)
    expected = 3
    assert_test(expected, output, "Test Case 2")

    # Case 3
    people = [3,5,3,4]
    limit = 5
    output = sol.numRescueBoats(people, limit)
    expected = 4
    assert_test(expected, output, "Test Case 3")



if __name__ == "__main__":
    main()
