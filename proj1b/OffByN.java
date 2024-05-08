public class OffByN implements CharacterComparator{

    private int N;
    //Init Operation
    public OffByN(int n){
        this.N=n;
    }
    @Override
    public boolean equalChars(char x, char y) {
        //int diff=(int)x-(int)y;
        return Math.abs(x-y)==N;
    }
}
