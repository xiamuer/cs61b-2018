import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN{
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.**/
    @Test
    public void TestIsOffByOneN(){
        CharacterComparator offByOne5 =new OffByN(5);
        CharacterComparator offByOne0 =new OffByN(0);
        assertTrue(offByOne5.equalChars('a','f'));
        assertTrue(offByOne5.equalChars('f','a'));
        assertFalse(offByOne5.equalChars('f','h'));
        assertTrue(offByOne0.equalChars('a','a'));

    }


    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class.
}

