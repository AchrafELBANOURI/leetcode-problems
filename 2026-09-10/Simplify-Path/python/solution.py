from typing import List, Any


class Solution:
	def simplifyPath(self, path: str) -> str:
		parts = path.split("/")
		stack = [""] * len(parts)
		top = 0

		for p in parts:
			if not p or p == ".":
				continue

			if p == "..":
				if top > 0:
					top -= 1
			else:
				stack[top] = p
				top += 1

		if top == 0:
			return "/"

		return "/" + "/".join(stack[:top])


def assert_test(expected: Any, actual: Any, test_name: str):
    if expected == actual:
        print(f"PASS: {test_name}")
    else:
        print(f"FAIL: {test_name} | Expected: '{expected}', Got: '{actual}'")


def main():
	sol = Solution()

	# Case 1
	path = "/home/"
	output = sol.simplifyPath(path)
	expected = "/home"
	assert_test(expected, output, "Test Case 1")

	# Case 2
	path = "/home//foo/"
	output = sol.simplifyPath(path)
	expected = "/home/foo"
	assert_test(expected, output, "Test Case 2")

	# Case 3
	path = "/home/user/Documents/../Pictures"
	output = sol.simplifyPath(path)
	expected = "/home/user/Pictures"
	assert_test(expected, output, "Test Case 3")

	# Case 4
	path = "/../"
	output = sol.simplifyPath(path)
	expected = "/"
	assert_test(expected, output, "Test Case 4")

	# Case 5
	path = "/.../a/../b/c/../d/./"
	output = sol.simplifyPath(path)
	expected = "/.../b/d"
	assert_test(expected, output, "Test Case 5")



if __name__ == "__main__":
    main()
