public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> dp= new LinkedListDeque<>();

        int len=word.length();
        for(int i=0;i<len;i++){
            dp.addLast(word.charAt(i));
            //System.out.print();
        }
        return dp;
    }
    //return true if the word is a palindrome(hui wen)
    public boolean isPalindrome(String word){
        if(word==null) return false;
        int len=word.length();
        int i=0;
        int j=len-1;
        while(i<j){
            if(word.charAt(i)!=word.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word==null) return false;
        int len=word.length();
        int i=0;
        int j=len-1;
        while(i<j){
            if(!cc.equalChars(word.charAt(i),word.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
