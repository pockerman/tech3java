package applications.numerics;
import geometry.primitives.Point2D;
import geometry.shapes.Circle;

import java.util.concurrent.ThreadLocalRandom;

public class Example1 {

    public static void main(String[] args){

        // number of iterations
        final int N_ITERATIONS = 100000;

        Circle circle = new Circle(2.0);

        double x0 = - circle.getRadius();
        double x1 = circle.getRadius();
        double y0 = - circle.getRadius();
        double y1 = circle.getRadius();

        int total_area = 0;
        int area_under_curve = 0;

        // the area of the rectangle
        final double RECT_AREA = (x1-x0)*(y1-y0);

        // the coordinates of the generated point
        Double[] coords = new Double[2];

        for(int itr=0; itr < N_ITERATIONS; ++itr){

            // generate random x and y points
            coords[0] = ThreadLocalRandom.current().nextDouble(x0 , x1);;
            coords[1] = ThreadLocalRandom.current().nextDouble(y0 , y1);;

            Point2D<Double> point = new Point2D<Double>(coords);

            System.out.println("Generated point: "+coords[0]+","+coords[1]);

            // add 1 to count of points within the whole area
            total_area += 1.0;

            if( circle.is_inside(point, 1.0e-8)){
                area_under_curve += 1;
            }
        }

        System.out.println("Rectangle area: "+RECT_AREA);
        System.out.println("Total area points: "+total_area);

        if(area_under_curve != 0.){

            System.out.println("Area under curve points: "+area_under_curve);
            System.out.println("Calculated area: "+RECT_AREA*((double)area_under_curve/(double)total_area));
            System.out.println("Circle area: "+circle.area());
        }

    }
}
