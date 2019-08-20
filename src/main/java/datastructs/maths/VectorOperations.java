package datastructs.maths;

import static java.lang.StrictMath.sqrt;

/**
 * Common operations on Vector
 */
public class VectorOperations {

    /**
     * Adds the two vectors and returns a vector that contains the result
     */
    public static Vector add(final Vector v1, final Vector v2){

        if(v1.size() != v2.size()){
            throw new IllegalStateException("v1 size not equal to v2 size");
        }

        var rslt = new Vector(v1.size(),0.0);

        for(int i=0; i<v1.size(); ++i){
            rslt.set(i, v1.get(i) + v2.get(i));
        }

        return rslt;
    }

    /**
     * Subtracts the two vectors and returns a vector that contains the result
     */
    public static Vector subtract(final Vector v1, final Vector v2){

        if(v1.size() != v2.size()){
            throw new IllegalStateException("v1 size not equal to v2 size");
        }

        var rslt = new Vector(v1.size(),0.0);

        for(int i=0; i<v1.size(); ++i){
            rslt.set(i, v1.get(i) - v2.get(i));
        }

        return rslt;
    }


    /**
      * Computes the dot product of the two vectors
     */
    public static double dotProduct(final Vector v1, final Vector v2){

        if(v1.size() != v2.size()){
            throw new IllegalStateException("v1 size not equal to v2 size");
        }

        double rslt = 0.0;

        for(int i=0; i<v1.size(); ++i){
            rslt += v1.get(i)*v2.get(i);
        }

        return rslt;
    }

    /**
      * Computes the L2 norm of the vector
     */
    public static double l2Norm(final Vector v1){
        var dotProduct = VectorOperations.dotProduct(v1 ,v1);
        return StrictMath.sqrt(dotProduct);
    }
}
