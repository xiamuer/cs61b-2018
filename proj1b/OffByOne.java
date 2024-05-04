public class OffByOne implements CharacterComparator{

    @Override
    public boolean equalChars(char x,char y){
        int ch1=(int)x;
        int ch2=(int)y;
        return ch1-ch2==1||ch2-ch1==1;
    }
}
