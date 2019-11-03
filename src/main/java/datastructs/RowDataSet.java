package datastructs;

import tech.tablesaw.api.Row;

import java.util.ArrayList;
import java.util.List;

public class RowDataSet<T> {

    /**
     * Constructor
     */
    public RowDataSet(){
        this.values = new ArrayList<>();
    }

    /**
     * Returns the id of the row set
     * @return
     */
    public int getId() {
        return this.id;
    }

    /**
     * Set the id of the row
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * How many elements the row has
     * @return
     */
    public int size(){
        return this.values.size();
    }

    /**
     * Returns the i-th element
     * @param i
     * @return
     */
    public T get(int i){
        return this.values.get(i);
    }

    /**
     * Add elements to the set
     * @param elements
     */
    public void add(T... elements){

        for (T ele:elements) {
            this.values.add(ele);
        }
    }

    @Override
    public String toString(){

        StringBuilder bd = new StringBuilder();

        for(int i=0; i<this.values.size(); ++i){
            bd.append(this.values.get(i));

            if( i != this.values.size() -1 ){
                bd.append(",");
            }
        }

        return bd.toString();
    }

    private int id;
    private String[] colNames;
    private List<T> values;
}
