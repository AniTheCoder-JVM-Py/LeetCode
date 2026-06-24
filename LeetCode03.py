'''Given a string s, find the length of the longest

without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 

Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.'''

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        seen = {}
        prev = 0
        maxLength = 0

        for curr,ch in enumerate(s):
            if ch in seen and seen[ch]>=prev:
                prev = seen[ch] + 1
            seen[ch] = curr
            maxLength = max(maxLength, curr-prev+1)
        return maxLength
        