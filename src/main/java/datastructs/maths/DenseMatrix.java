package datastructs.maths;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;

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

    /**
     * Rerturns the number of rows
     */
    public final int m(){return this.data.size();}

    /**
     * Returns the number of columns
     */
    public final int n(){return this.data.get(0).size();}

    /**
     * Initialize the matrix from the given Table dataset
     */
    public void initializeFrom(final Table table){

        if(table == null){
            throw new IllegalArgumentException("Input Table should not be null");
        }

        // how many rows and columns
        int m = table.rowCount();
        int n = table.columnCount();

        this.create(m, n, 0.0);

        int rowCounter = 0;
        for (Row row: table ) {

            Vector vecRow = new Vector(row.columnCount());
            vecRow.set(row);
            this.set(rowCounter++, vecRow);
        }
    }

    /**
     * Returns the diagonal of the matrix
     * @return
     */
    public final Vector diagonal(){

        /*if(m() != n()){
            throw new IllegalCallerException("Diagonal can only be computed for square matrices");
        }*/

        Vector diag = new Vector(m(), 0.0);

        for(int i=0; i < m(); ++i){

            diag.set(i, this.data.get(i).get(i));
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

        this.data.get(i).set(j, value);
    }

    public final void set(int i, Vector value){

        if( i >= m() || i < 0 ){
            throw new IllegalArgumentException("Invalid row index");
        }
        this.data.get(i).set(value);
    }

    public final void setColumn(int c, DoubleColumn col){

        if(col.size() != this.m()){
            throw new IllegalArgumentException("Column size not equal to the number of rows");
        }

        for(int i=0; i<this.m(); ++i){

            Vector row =  this.data.get(i);
            for(int j=0; j<this.n(); ++j){
                if(j==c){
                    row.set(j, col.getDouble(i));
                }
            }
        }
    }

    public final Vector row(int r){

        if( r >= m() || r < 0 ){
            throw new IllegalArgumentException("Invalid row index");
        }

        return this.data.get(r);
    }

    private final void create(int m, int n, double val){

        if(m <= 0 || n<= 0){
            throw new IllegalArgumentException("Cannot create a matrix with zero rows or columns");
        }

        this.data = new ArrayList<Vector>(m);

        for(int i=0; i<m; ++i){

            Vector row = new Vector(n, val);
            this.data.add(row);
        }
    }

    private ArrayList<Vector> data = null;
}
