public class OffByN implements CharacterComparator{

    int OffByN;
    //Init Operation
    public OffByN(int n){
        OffByN=n;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int diff=x-y;
        return diff==OffByN||diff==-1*OffByN;
    }
}
