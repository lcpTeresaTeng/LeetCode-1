https://leetcode.com/problems/find-the-difference/

// 解法一
// 1）把t中character出现的次数存进数组
// 2）把s中出现的character次数--
// 3）剩下的count[i] > 0对应的character即为所求
// 时间复杂度：O(n)
// 空间复杂度：O(128)

class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[128];
        for (char c: t.toCharArray()) {
            count[c]++;
        }
        for (char c: s.toCharArray()) {
            count[c]--;
        }
        for (int i = 0; i < 128; i++) {
            if (count[i] > 0) return (char) i;
        }
        return '0';
    }
}

// 解法二：XOR，转化成single number问题
// 时间复杂度：O(n)
// 空间复杂度：O(1)
// 犯错点：1.char c不能初始化为空字符''，而应该为0

class Solution {
    public char findTheDifference(String s, String t) {
        char[] sArray = s.toCharArray(), tArray = t.toCharArray();
        //char c = '';  // {Mistake 1}
        char c = 0;  // {Correction 1}
        for (int i = 0; i < sArray.length; i++) c ^= sArray[i];
        for (int i = 0; i < tArray.length; i++) c ^= tArray[i];
        return c;
    }
}