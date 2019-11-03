package utils;

public interface IDataSetWrapper<DataSetTyp> {

    /**
     * Copy from the given IDataSetWrapper
     * @return
     */
    IDataSetWrapper copy();


    /**
     * How many rows the dataset has
     */
    int nRows();

    DataSetTyp getRow(int i);

}
