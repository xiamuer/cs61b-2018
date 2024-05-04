public class OffByN implements CharacterComparator{

    private int OffByN;
    //Init Operation
    public OffByN(int n){
        OffByN=n;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int diff=(int)x-(int)y;
        return Math.abs(diff)==OffByN;
    }
}
