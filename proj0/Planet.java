import java.security.PublicKey;

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    String imgFileName;
    public Planet(double xP,double yP,double xV,double yV,double m,String img){
            this.xxPos=xP;
            this.yyPos=yP;
            this.xxVel=xV;
            this.yyVel=yV;
            this.mass=m;
            this.imgFileName=img;
    }
    public Planet(){
        this(0,0,0,0,0,null);
    }
    public Planet(Planet p){
        this(p.xxPos,p.yyPos,p.xxVel,p.yyVel,p.mass,p.imgFileName);
    }
    /*计算两个物体之间的距离的平方*/
    public double calcDistance(Planet other){
        return Math.sqrt((this.xxPos-other.xxPos)*(this.xxPos- other.xxPos)+(this.yyPos-other.yyPos)*(this.yyPos-other.yyPos));
    }
    /*计算两个物体之间的受力，牛顿万有引力*/
    public double calcForceExertedBy(Planet other){
        double G=6.67e-11;
        return (G*(this.mass*other.mass))/(this.calcDistance(other)*this.calcDistance(other));
    }
    //this代表受力的物体，other代表施力的物体
    //X分力
    public double calcForceExertedByX(Planet other){
        double F=this.calcForceExertedBy(other);
        double r=this.calcDistance(other);
        return F*(other.xxPos-this.xxPos)/r;
    }
    //Y方向上的分力
    public double calcForceExertedByY(Planet other){
        double F=this.calcForceExertedBy(other);
        double r=this.calcDistance(other);
        return F*(other.yyPos-this.yyPos)/r;
    }
    //计算受力物体受其他物体X方向上的力
    public double calcNetForceExertedByX(Planet[] planets){
        double xNetForce=0.0;
        for(Planet p:planets){
            if(!this.equals(p))
                xNetForce+=this.calcForceExertedByX(p);
        }
        return xNetForce;
    }
    //计算受力物体受其它物体Y方向的力
    public double calcNetForceExertedByY(Planet[] planets){
        double yNetForce=0;
        for(Planet p:planets){
            if(!this.equals(p))
                yNetForce+=this.calcForceExertedByY(p);
        }
        return yNetForce;
    }
    //更新速度，牛顿第二定理
    //已知x,y方向的分力以及作用的时间，求出变化后的速度

    public void update(double time,double xForce,double yForce){
        //由F=ma先求出a，然后v=v0+a*t;
        double ax=xForce/this.mass;
        double ay=yForce/this.mass;
        this.xxVel=this.xxVel+ax*time;
        this.yyVel=this.yyVel+ay*time;
        //讲义给的公式：p_new=p_old+v_new*dt
        //我高中学的：p_new=p_old+0.5*a*t*t;算了按讲义来吧
        this.xxPos=this.xxPos+this.xxVel*time;
        this.yyPos=this.yyPos+this.yyVel*time;
    }
    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
    }
}
