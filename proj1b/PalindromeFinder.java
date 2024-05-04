// This class outputs all palindromes in the words file in the current directory
public class PalindromeFinder {
    //this confirm my experiment
    public static void main(String[] args) {
        int minLength = 3;
        In in = new In("words.txt");
        Palindrome palindrome = new Palindrome();
        CharacterComparator cc=new OffByN(0);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word,cc)) {
                System.out.println(word);
            }
        }
    }
    //Uncomment this class once you've written isPalindrome. *
}
