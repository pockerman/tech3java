package applications.numerics;


import java.util.concurrent.ThreadLocalRandom;

public class Example1 {

    public static final int N_ITRS = 1000;

    public static double f(double x){
        return x*x;
    }



    public static void main(String[] args){

        double a = 1.0;
        double b = 3.0;


        double yLower = 0.0;
        double yUpper = Example1.f(b);
        double RECT_AREA = (b - a)*(yUpper - yLower);

        long total_area_points = 0;
        long under_curve_points = 0;

        for(int i = 0; i< Example1.N_ITRS; ++i){

            // generate the random x and y
            double x = ThreadLocalRandom.current().nextDouble(a , b);
            double y = ThreadLocalRandom.current().nextDouble(yLower , yUpper);

            System.out.println("Generated the point: "+x+", "+y);

            total_area_points += 1;

            double yCalc = Example1.f(x);

            if( y <= yCalc ){
                under_curve_points += 1;
            }
        }

        System.out.println("Total area points: "+total_area_points);
        System.out.println("Rectangle area: "+RECT_AREA);

        if(under_curve_points != 0){

            double calcArea = RECT_AREA*((double)under_curve_points/(double)total_area_points);
            System.out.println("Area under curve points: "+under_curve_points);
            System.out.println("Calculated area: " + calcArea);
        }

    }
}
