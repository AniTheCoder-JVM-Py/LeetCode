'''Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321

Example 2:

Input: x = -123
Output: -321

Example 3:

Input: x = 120
Output: 21

 

Constraints:

    -231 <= x <= 231 - 1'''

class Solution(object):
    def reverse(self, x):
        rev = ""
        int_max = 2**31 -1
        int_min = -2**31
        sign = -1 if x<0 else 1
        x = str(abs(x))
        i = len(x) - 1
        while i>=0:
            rev = rev + x[i]
            i-=1
        rev = int(rev)
        rev *= sign
        if rev > int_max or rev < int_min:
            return 0
        return rev