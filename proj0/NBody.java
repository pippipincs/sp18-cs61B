public class NBody {
   /**
    * simulates a universe specified in one of the data files
     */
    public static double readRadius(String file_path){
        In in = new In(file_path);
        int t= in.readInt();
        return in.readDouble();


    } 
}
