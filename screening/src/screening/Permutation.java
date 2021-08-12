package screening;

public class Permutation {
	
	static void printPermutn(String str, String ans)
    {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String perm = str.substring(0, i) + 
                         str.substring(i + 1);
            printPermutn(perm, ans + ch);
        }
    }
    public static void main(String[] args)
    {
        String s = "aab";
        printPermutn(s, "");
    }
}


