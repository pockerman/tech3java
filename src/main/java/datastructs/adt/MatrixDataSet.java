package datastructs.adt;

import java.util.*;

/**
 * A MatrixDataSet represents a table of entries of the same type.
 * The type of the entries is parametrized by the type T.
 * Internally, the class uses a HashMap implementation to represent
 * the columns for the dataset
 */
public class MatrixDataSet<T> implements Iterable<RowDataSet<T>>,
                                         IDataSetWrapper<RowDataSet<T>>
{

    public MatrixDataSet(String name){

        this.data = new ArrayList<>();
        this.colNames = new ArrayList<>();
        this.name = name;
    }

    /**
     * Copy from the given IDataSetWrapper
     * @return
     */
    public IDataSetWrapper<RowDataSet<T>> copy(){
        return this;
    }

    /**
     * Add a new column to the data set
     * @param colName
     */
    public void addColumn(String colName){

        if(this.hasColumn(colName)){
            return;
        }

        this.colNames.add(colName);
    }

    /**
     * Add multiply columns to the data set
     * @param colNames
     */
    public void addColumns(String... colNames){

        for(String  name : colNames){
            this.addColumn(name);
        }
    }

    /**
     * Returns true if the given column exists
     * @param colName
     * @return
     */
    public boolean hasColumn(String colName){
        for(String name : this.colNames){
            if(name.equals(colName)){
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the number of columns the dataset has
     *
     */
    public final int nColumns(){
        return this.colNames.size();
    }

    /**
     * Returns the coumns of the dataset
     */
    public final List<String> getColNames(){
        return this.colNames;
    }

    /**
     * Add a row to the data set
     * @return
     */
    public void addRow(RowDataSet<T> r){

        if(this.colNames.size() == 0){
            throw new IllegalStateException("Columns have not been initialized");
        }

        if(r.size() != this.colNames.size()){
            throw new IllegalArgumentException(" Row size does not match number of columns");
        }

        r.setId(this.data.size());
        this.data.add(r);
    }

    /**
     * How many rows the data set has
     * @return
     */
    public int nRows(){
        return this.data.size();
    }


    /**
     * Returns the i-th row
     */
    public RowDataSet<T> getRow(int i){

        if(this.data.size() == 0){
            throw new IllegalStateException("Rows are empty");
        }

        if(i<0 || i > this.data.size()){
            throw new IllegalArgumentException("Index "+i+" is out of bounds. Should be in [0,"+this.data.size()+")");
        }

        return this.data.get(i);
    }


    /**
     * Iterate over the rows of the dataset
     */
    @Override
    public Iterator<RowDataSet<T>> iterator() {
        return data.iterator();
    }

    private List<RowDataSet<T>> data;
    private List<String> colNames;
    private String name;
}
