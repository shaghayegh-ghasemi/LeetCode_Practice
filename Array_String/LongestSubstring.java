import java.util.HashSet;
import java.util.Set;

// 3. Longest Substring Without Repeating Characters

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0, right = 0;

        while (right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args){
        LongestSubstring solution = new LongestSubstring();

        String s = "abcabcbb";
        System.out.println("String: " + s);

        int l = solution.lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring without repetition: " + l);

        String s1 = "bbbbb";
        System.out.println("String: " + s1);

        int l1 = solution.lengthOfLongestSubstring(s1);
        System.out.println("Length of longest substring without repetition: " + l1);

        String s2 = "pwwkew";
        System.out.println("String: " + s2);

        int l2 = solution.lengthOfLongestSubstring(s2);
        System.out.println("Length of longest substring without repetition: " + l2);
    }
}
