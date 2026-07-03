'''Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"

 

Constraints:

    1 <= num1.length, num2.length <= 200
    num1 and num2 consist of digits only.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.'''

class Solution(object):
    def multiply(self, num1, num2):
        
        if num1 == "0" or num2 == "0":
            return "0"

        m = len(num1)
        n = len(num2)

        result = [0] * (m + n)

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):

                mul = int(num1[i]) * int(num2[j])

                p1 = i + j
                p2 = i + j + 1

                total = mul + result[p2]

                result[p2] = total % 10
                result[p1] += total // 10

        ans = []

        for digit in result:
            if not ans and digit == 0:
                continue
            ans.append(str(digit))

        return "".join(ans)