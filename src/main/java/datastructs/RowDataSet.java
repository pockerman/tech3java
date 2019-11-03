package datastructs;

import java.util.List;

public class RowDataSet<T> {

    public int getId() {
        return this.id;
    }

    public int size(){
        return this.values.size();
    }

    public T get(int i){
        return this.values.get(i);
    }

    private int id;
    private String[] colNames;
    private List<T> values;
}
