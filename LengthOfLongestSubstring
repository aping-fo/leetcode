
/**
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> latestIndex = new HashMap<>();  // 存放字符最近一次出现的位置
        int curStart = 0, curLen = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);  // 添加字符c到一个已有的无重复字符子串结尾
            if (latestIndex.containsKey(c) && latestIndex.get(c) >= curStart) { // 字符c已经在这个无重复字符子串中
                curStart = latestIndex.get(c) + 1;  // 更新当前无重复字符子串的起点
            }
            curLen = i - curStart + 1;  // 当前无重复字符子串的长度
            if (curLen > maxLen) {
                maxLen = curLen;
            }
            latestIndex.put(c, i);
        }
        return maxLen;
    }
}
