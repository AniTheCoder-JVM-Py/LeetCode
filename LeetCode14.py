'''Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 

Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters if it is non-empty.'''

class Solution(object):
    def longestCommonPrefix(self, strs):
        if not strs:
            return ""
        ref = strs[0]
        pref = ""

        for i in range(0,len(ref)):
            ch = ref[i]

            if any(i >= len(s) or ch != s[i] for s in strs[1:]):
                break
            pref+=ch
        return pref