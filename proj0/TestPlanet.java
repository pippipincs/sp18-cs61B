/**
 * tests class Planet
 */
public class TestPlanet {
   /**
    *tests class Planet 
     */ 
    public static void main(String[] args ){
        checkPlanet();

    }
    /**
     * checks whether or not two doubles are the same and prints the result.
     * @param actual
     * @param expected
     * @param label
     * @param eps
     */
    private static void checkequals(double actual, double expected, String label, double eps ){
        if(Math.abs(actual-expected)<=eps*Math.max(actual,expected)){
            System.out.println("Pass:"+label+"expected:"+expected+"and you gave:"+actual);
        }else{
            System.out.println("Fail:"+label+"expected:"+expected+"and you gave:"+actual);
        }
    }
    public static void checkPlanet(){
        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");


        checkequals(p1.calcForceExertedBy(p2), 133.4, "calcForceExertedBy()", 0.01);
    }
}
