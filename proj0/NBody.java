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
}
