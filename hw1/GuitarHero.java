
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.introcs.StdAudio;
import synthesizer.GuitarString;

/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
public class GuitarHero {
    //private static final double CONCERT_A = 440.0;
    //private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static final double[] CONCERT=new double[37];



    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        //synthesizer.GuitarString stringA = new synthesizer.GuitarString(CONCERT_A);
        //synthesizer.GuitarString stringC = new synthesizer.GuitarString(CONCERT_C);
        for(int i=0;i<37;i++){
            CONCERT[i]=440*Math.pow(2,(i-24)/12);
        }
        synthesizer.GuitarString[] strings=new synthesizer.GuitarString[37];
        for(int i=0;i<37;i++){
            strings[i]=new GuitarString(CONCERT[i]);
        }
        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index=keyboard.indexOf(key);
                if(index!=-1){
                    strings[index].pluck();
                }

//                if (key == 'a') {
//                    stringA.pluck();
//                } else if (key == 'c') {
//                    stringC.pluck();
//                }
            }

            /* compute the superposition of samples */
//            double sample = stringA.sample() + stringC.sample();
//
//            /* play the sample on standard audio */
//            StdAudio.play(sample);
//
//            /* advance the simulation of each guitar string by one step */
//            stringA.tic();
//            stringC.tic();
            double sample=0.0;
            for(int i=0;i<37;i++){
                sample=sample+strings[i].sample();
            }
            StdAudio.play(sample);
            for(int i=0;i<37;i++){
                strings[i].tic();
            }


        }
    }
}

