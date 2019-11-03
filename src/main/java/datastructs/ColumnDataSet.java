package datastructs;

import java.util.List;

public class ColumnDataSet<T> {

    /**
     * Returns the name of the columns
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the id of the column
     * @return
     */
    public int getId() {
        return this.id;
    }

    public int size(){
        return this.data.size();
    }

    private String name;
    private List<T> data;
    private int id;
}
