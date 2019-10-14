package geometry.shapes;

import maths.Constants;
import geometry.primitives.Point2D;

/**
 * Models a circle shape
 */
public class Circle {


    // \brief Construct a circle centerd at the origin
    public Circle(double r){
        this.r = r;
        this.center = new Point2D<>(new Double(0.0), new Double(0.0));
    }


    /// \brief Construct a circle given its radius and center
    public Circle(double r, Point2D<Double> center){
        this.r = r;
        this.center = center;
    }


    /// \brief Returns the radius of the circle
    public final double getRadius(){return this.r;}


    /// \brief Returns the center of the circle
    public final Point2D<Double> getCenter(){
        return this.center;
    }


    /// \brief Returns the area
    public final double area(){
        return Constants.PI*this.r*this.r;
    }


    /// \brief Returns true if the given point lies inside the circle
    public final boolean is_inside(Point2D<Double> point, double tol ){

        if(Math.pow((this.center.getI() - point.getI()), 2) + Math.pow((this.center.getJ() - point.getJ()), 2) - this.r*this.r < tol){
            return true;
        }

        return false;
    }

    /// \brief The radius of the circle
    private double r;

    /// \brief The center of the circle
    private Point2D<Double> center;

}
