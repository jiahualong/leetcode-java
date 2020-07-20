package cc.stan;

import org.junit.Test;

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution003 {
    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int[] alpha = new int[128];

        for (int i = 0; i < alpha.length; i++)
            alpha[i] = -1;

        char[] sArray = s.toCharArray();

        int maxSubStrLen = 0;
        int minIndex = 0;
        for (int i = 0; i < sArray.length; i++) {
            minIndex = Math.max(minIndex, alpha[(int) sArray[i]]);
            maxSubStrLen = Math.max(maxSubStrLen, i - minIndex + 1);
            alpha[(int) sArray[i]] = i + 1;
        }
        return maxSubStrLen;
    }

    @Test
    public void t() {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
