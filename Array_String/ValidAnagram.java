import java.util.Arrays;

//242. Valid Anagram

public class ValidAnagram {

    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();

        Arrays.sort(s_chars);
        Arrays.sort(t_chars);

        return Arrays.equals(s_chars, t_chars);
    }
    public static void main(String[] args){
        ValidAnagram solution = new ValidAnagram();

        String s = "anagram";
        String t = "nagaram";

        System.out.println("String s: " + s);
        System.out.println("String t: " + t);

        System.out.println("Is Anagram? " + solution.isAnagram(s, t));

        String s1 = "rat";
        String t1 = "car";

        System.out.println("\nString s: " + s1);
        System.out.println("String t: " + t1);

        System.out.println("Is Anagram? " + solution.isAnagram(s1, t1));
    }
}
