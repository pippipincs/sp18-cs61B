public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G =1.334e-9;
    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        this.xxPos=xP;
        this.yyPos=yP;
        this.xxVel=xV;
        this.yyVel=yV;
        this.mass=m;
        this.imgFileName=img;

    } 
    public Planet(Planet p){
        this.xxPos=p.xxPos;
        this.yyPos=p.yyPos;
        this.xxVel=p.xxVel;
        this.yyVel=p.yyVel;
        this.mass=p.mass;
        this.imgFileName=p.imgFileName;
    }

    public double calcDistance(Planet p){
        
        double dx=p.xxPos-this.xxPos;
        double dy=p.yyPos-this.yyPos;
        double d=Math.sqrt(dx*dx+dy*dy);
        return d;

    }
    public double calcForceExertedBy(Planet p){
        double d =this.calcDistance(p);
        return Planet.G*this.mass*p.mass/(d*d);
    }
}
