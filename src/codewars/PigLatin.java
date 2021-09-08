package codewars;

// https://www.codewars.com/kata/520b9d2ad5c005041100000f
public class PigLatin {
    public static String pigIt(String str) {
        String punctuations = ".,:;?!";

        StringBuilder stringBuilder = new StringBuilder();
        String[] split = str.split(" ");

        for (String word : split) {
            if (punctuations.contains(word)) stringBuilder.append(word).append(" ");
            else stringBuilder.append(word.substring(1)).append(word.charAt(0)).append("ay").append(" ");
        }

        return stringBuilder.toString().trim();
    }
}
