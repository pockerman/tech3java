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
    @Override
    public Vector create(int n){
        return new Vector(n, 0.0);
    }

    /**
     * Create a row of type RowType
     */
    @Override
    public <T> Vector create(T... vals){
        return new Vector((Double[])(vals));
    }


}
