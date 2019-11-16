package datastructs.maths;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Row;
import tech.tablesaw.api.Table;

import java.util.ArrayList;
import java.util.List;

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
     * Given the number of columns to include and the column indices
     * create a submatrix that has all the rows and columns specified
     */
    public final double[][] getSubMatrix(int numColsToInclude, int... includeCols){

        double[][] subMatix = new double[this.m()][numColsToInclude];

        for(int i=0; i<this.m(); ++i){

            int colCounter=0;
            for( int col:includeCols){
                subMatix[i][colCounter++] = this.data.get(i).get(col);
            }

        }

        return subMatix;
    }

    /**
     * Given the number of columns to include and the column indices
     * create a submatrix that has all the rows and columns specified
     */
    public final void duplicateColumn(int column){

        Vector col = getColumn(column);

        for(int i=0; i<this.m(); ++i){

            Vector vec = this.data.get(i);
            vec.resize(vec.size() + 1);

            vec.set(vec.size()-1, col.get(i));
        }
    }

    /**
     * Set the (i,j) entry of the matrix
     * @param i
     * @param j
     * @param value
     */
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

    public final void setColumn(int c, List<Double> col){

        if(col.size() != this.m()){
            throw new IllegalArgumentException("Column size not equal to the number of rows");
        }

        for(int i=0; i<this.m(); ++i){

            Vector row =  this.data.get(i);
            for(int j=0; j<this.n(); ++j){
                if(j==c){
                    row.set(j, col.get(i));
                }
            }
        }
    }

    /**
     * Returns a copy of the values of the column-th column
     */
    public final Vector getColumn(int column){

        if(column <0 || column >= this.n()){
            throw new IllegalArgumentException("Invalid column index: "+column+" should be in [0,"+this.n()+")");
        }

        Vector columnVals = new Vector(this.m(), 0.0);

        for(int i=0; i<this.m(); ++i){
            columnVals.set(i, this.data.get(i).get(column));
        }

        return columnVals;
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
