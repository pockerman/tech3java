package datastructs.maths;

import java.util.ArrayList;

/**
 * Represents a dense matrix
 */
public class DenseMatrix {

    public DenseMatrix(){

    }

    public DenseMatrix(int m, int n, double val){
        this.create(m ,n, val);
    }

    public final int m(){return this.data_.size();}

    public final int n(){return this.data_.get(0).size();}

    public final Vector diagonal(){

        if(m() != n()){
            throw new IllegalCallerException("Diagonal can only be computed for square matrices");
        }

        Vector diag = new Vector(m(), 0.0);

        for(int i=0; i < m(); ++i){

            diag.set(i, this.data_.get(i).get(i));
        }

        return diag;
    }

    public final void set(int i, int j, double value){

        if( i >= m() || i < 0 ){
            throw new IllegalArgumentException("Invalid row index");
        }

        if( j >= n() || j < 0 ){
            throw new IllegalArgumentException("Invalid column index");
        }

        this.data_.get(i).set(j, value);

    }

    public final void set(int i, Vector value){

        if( i >= m() || i < 0 ){
            throw new IllegalArgumentException("Invalid row index");
        }
        this.data_.get(i).set(value);
    }

    private final void create(int m, int n, double val){

        if(m <= 0 || n<= 0){
            throw new IllegalArgumentException("Cannot create a matrix with zero rows or columns");
        }

        this.data_ = new ArrayList<Vector>(m);

        for(int i=0; i<m; ++i){

            Vector row = new Vector(n, val);
            this.data_.add(row);
        }
    }

    private ArrayList<Vector> data_ = null;
}
