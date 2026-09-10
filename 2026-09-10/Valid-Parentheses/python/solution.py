from typing import List, Any

class Solution:
    def isValid(self, s: str) -> bool :
      stack = []
      for c in s:
        if c in ['(','{','['] :
            stack.append(c)
        else :
          if len(stack) == 0 : return False
          else :
            if c == ')' :
              openBracket = stack.pop()
              if openBracket != '(' : return False

            if c == ']' :
              openBracket = stack.pop()
              if openBracket != '[' : return False
            
            if c == '}' :
              openBracket = stack.pop()
              if openBracket != '{' : return False
      
      if len(stack) != 0 :
        return False
      
      return True
		

def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")

def main() :
  sol = Solution()
  s = "()"
  output = sol.isValid(s)
  expected = True
  assert_test(expected, output, "Test Case 1")

  sol = Solution()
  s = "()[][]"
  output = sol.isValid(s)
  expected = True
  assert_test(expected, output, "Test Case 2")

  sol = Solution()
  s = "(]"
  output = sol.isValid(s)
  expected = False
  assert_test(expected, output, "Test Case 3")

  sol = Solution()
  s = "([])"
  output = sol.isValid(s)
  expected = True
  assert_test(expected, output, "Test Case 4")

  sol = Solution()
  s = "([)]"
  output = sol.isValid(s)
  expected = False
  assert_test(expected, output, "Test Case 5")

if __name__ == "__main__":
    main()