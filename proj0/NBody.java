public class NBody {
    //返回宇宙的半径
    public static double readRadius(String Filename){
        In in=new In(Filename);
        int N=in.readInt();
        return in.readDouble();
    }

    //返回行星数组
    public static Planet[] readPlanets(String Filename){
        In in=new In(Filename);
        int N=in.readInt();
        Planet[] planets=new Planet[N];
        double radius=in.readDouble();
        for(int i=0;i<N;i++){
            double xxPos =in.readDouble() ,
                    yyPos = in.readDouble(),
                    xxVel = in.readDouble(),
                    yyVel = in.readDouble(),
                    mass =in.readDouble();
            String imageFile=in.readString();
            Planet p=new Planet(xxPos,yyPos,xxVel,yyVel,mass,imageFile);
            planets[i]=p;
        }
        return planets;
    }

    public static void main(String[] args){
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename="./"+args[2];
        Double Radius=readRadius(filename);
        Planet[] planets=readPlanets(filename);
        int N=planets.length;
        StdDraw.setXscale(-Radius,Radius);
        StdDraw.setYscale(-Radius,Radius);
        StdDraw.enableDoubleBuffering();
        //StdDraw.picture(0,0,"images/starfield.jpg");
        //for(int i=0;i<N;i++)
        //    planets[i].draw();

        double t=0;
        while(t<=T){
            double[] xForces=new double[N];
            double[] yForces=new double[N];
            for(int i=0;i<N;i++){
                xForces[i]=planets[i].calcNetForceExertedByX(planets);
                yForces[i]=planets[i].calcNetForceExertedByY(planets);
            }
            for (int i=0;i<N;i++){
                planets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0,0,"images/starfield.jpg");
            for(int i=0;i<N;i++){
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t+=dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", Radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
