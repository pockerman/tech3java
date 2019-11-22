package datastructs.interfaces;

import parallel.partitioners.IPartitionPolicy;

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

    /**
     * Returns the i-th row of the dataset
     */
    DataSetTyp getRow(int i);

    /**
     * Return the i-th partition of the dataset
     */
    default IPartitionPolicy getPartitionPolicy(){return null;}

}
