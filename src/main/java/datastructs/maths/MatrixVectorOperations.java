package datastructs.maths;

import datastructs.interfaces.IVector;
import jdk.jshell.spi.ExecutionControl;

/**
 * Implements common matrix-vector operations
 */
public class MatrixVectorOperations {

    /**
     * Computes y = M*x
     */
    public static  final  IVector<Double> dot(DenseMatrixSet<Double> mat, Vector x){


        if(mat.n() != x.size()){
            throw new IllegalStateException("Matrix columns "+mat.n()+" and vector " +
                    " size " +x.size() +" are not equal.");
        }

        IVector<Double> rslt = new Vector(mat.m());

        for(int r=0; r<mat.m(); ++r){
            IVector<Double> row = mat.getRow(r);
            rslt.set(r, VectorOperations.dotProduct(row, x));
        }

        return rslt;
    }


}
