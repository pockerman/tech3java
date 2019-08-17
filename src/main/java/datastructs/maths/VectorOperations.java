package datastructs.maths;

/**
 * Common operations on Vector
 */
public class VectorOperations {



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
}
