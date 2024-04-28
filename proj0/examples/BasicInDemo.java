import java.io.File;

/** Simpler demo of the In class. */
public class BasicInDemo {
	public static void main(String[] args) {
//		In in = new In("BasicInDemo_input_file.txt");
//
//		/* Every time you call a read method from the In class,
//		 * it reads the next thing from the file, assuming it is
//		 * of the specified type. */
//
//		/* Compare the calls below to the contents of BasicInDemo_input_file.txt */
//
//		int firstItemInFile = in.readInt();
//		double secondItemInFile = in.readDouble();
//		String thirdItemInFile = in.readString();
//		String fourthItemInFile = in.readString();
//		double fifthItemInFile = in.readDouble();
//
//		System.out.println("The file contained "  + firstItemInFile + ", " +
//			               secondItemInFile + ", " + thirdItemInFile + ", " +
//			               fourthItemInFile + ", and " + fifthItemInFile);
		String Filename="D:/大学/CS自学指南/CS61B/2018/proj0/data/planets.txt";
		In in=new In(Filename);
		int N=in.readInt();
		//Planet[] planets=new Planet[N];
		double radius=in.readDouble();
		for(int i=0;i<N;i++){
			String str=in.readLine();
			System.out.println(str);
			//Planet p=new Planet(xxPos,yyPos,xxVel,yyVel,mass,str[5]);
			//planets[i]=p;
		}
	}
} 