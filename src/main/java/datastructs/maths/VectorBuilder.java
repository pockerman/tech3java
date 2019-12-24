package datastructs.maths;

import datastructs.interfaces.IRowBuilder;
import datastructs.interfaces.IVector;

public class VectorBuilder implements IRowBuilder<Vector> {


    @Override
    public Vector create(){
            return new Vector();
    }

    /**
     * Create a row of type RowType
     */
    RowType create(int n);

    /**
     * Create a row of type RowType
     */
    <T> RowType create(T... vals);


}
