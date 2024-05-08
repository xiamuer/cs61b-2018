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
        int len=word.length();
        if(len==1||len==0) return true;
        int i=0;
        int j=len-1;
        //CharacterComparator cc0=new OffByN(0);
        //CharacterComparator cc1=new OffByN(1);
        while(i<j){
            if(word.charAt(i)!=word.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    //return true if two character diff N or -N
    public boolean isPalindrome(String word, CharacterComparator cc){
        int len=word.length();
        if(len==0||len==1) return true;
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
