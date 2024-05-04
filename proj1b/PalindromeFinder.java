// This class outputs all palindromes in the words file in the current directory
public class PalindromeFinder {
    //this confirm my experiment
    public static void main(String[] args) {
        int minLength = 3;
        In in = new In("words.txt");
        Palindrome palindrome = new Palindrome();
        CharacterComparator cc=new OffByN(1);
        int c1=0;
        int c2=0;
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength) {
                if(palindrome.isPalindrome(word)){
                    c1++;
                }
                if(palindrome.isPalindrome(word,cc)){
                    c2++;
                }
                //System.out.println(word);
            }
        }
        System.out.print("c1="+c1+"\n");
        System.out.print("c2="+c2);
    }
    //Uncomment this class once you've written isPalindrome. *
}
