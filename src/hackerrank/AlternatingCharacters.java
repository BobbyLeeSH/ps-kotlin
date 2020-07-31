package hackerrank;

public class AlternatingCharacters {
    static int alternatingCharacters(String s) {
        if (s.length() < 2) return 0;

        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) count++;
        }

        return count;
    }
}

