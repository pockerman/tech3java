package datastructs;

import utils.IDataSetWrapper;

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

    public void addColumn(String colName){

        if(this.hasColumn(colName)){
            return;
        }

        this.colNames.add(colName);
    }


    public int nRows(){
        return this.data.size();
    }

    public boolean hasColumn(String colName){
        for(String name : this.colNames){
            if(name.equals(colName)){
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the i-th row
     */
    public RowDataSet<T> getRow(int i){
        return this.data.get(i);
    }

    @Override
    public Iterator<RowDataSet<T>> iterator() {
        return data.iterator();
    }

    private List<RowDataSet<T>> data;
    private List<String> colNames;
    private String name;
}
