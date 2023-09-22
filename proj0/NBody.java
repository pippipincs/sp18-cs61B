public class NBody {
   /**
    * simulates a universe specified in one of the data files
     */
    public static double readRadius(String file_path){
        In in = new In(file_path);
        int t= in.readInt();
        return in.readDouble();
    } 
    public static Planet[] readPlanets(String file_path){
        In in= new In(file_path);
        int n=in.readInt();
        in.readDouble();
        Planet[] array=new Planet[n];
        for(int i=0;i<n;i++){
            array[i]=new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        
        }
        return array;
    }
    public static void main(String[] args){
        double T =Double.parseDouble(args[0]);
        double dt =Double.parseDouble(args[1]);
        String filename=args[2];
        double radius=NBody.readRadius(filename);
        Planet[] Planets=NBody.readPlanets(filename);
        In in=new In(filename);
        int n=in.readInt();
        /**
         * create an animation.
         *
         */
        StdDraw.enableDoubleBuffering();
        double time=0;
        for(;time<=T;time+=dt){
            double[] xforce=new double[n];
            double[] yforce=new double[n];
            for(int i =0;i<n;i++){
                xforce[i]=Planets[i].calcNetForceExertedByX(Planets);
                yforce[i]=Planets[i].calcNetForceExertedByY(Planets);

            }
            for(int i=0;i<n;i++){
                Planets[i].update(dt,xforce[i],yforce[i]);   
            } 


            String path_to_pic="./images/starfield.jpg";
            StdDraw.setScale(-radius,radius);
            StdDraw.clear();
            StdDraw.picture(0,0,path_to_pic,radius*2,radius*2);

            for(Planet p:Planets){
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);

        }
        /**
         * prints the final universe.
         */
        StdOut.printf("%d\n",Planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < Planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                  Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);   
        }
    }
}
