package datastructs.maths;

/**
 * Implements common matrix-vector operations
 */
public class MatrixVectorOperations {

    /**
     * Computes y = M*x
     */
    public static  final Vector dot(DenseMatrix mat, Vector x){

        if(mat.n() != x.size()){
            throw new IllegalStateException("Matrix columns "+mat.n()+" and vector " +
                    " size " +x.size() +" are not equal.");
        }

        Vector rslt = new Vector(mat.m());

        for(int r=0; r<mat.m(); ++r){
            Vector row = mat.row(r);
            rslt.set(r, VectorOperations.dotProduct(row, x));
        }

        return rslt;
    }


}
