package datastructs.maths;

import base.CommonConstants;
import tech.tablesaw.api.Row;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements a Vector class in the mathematical sense
 */

public class Vector {


    /**
     * Creates an empty vector
     */
    public Vector(){

        this.data = new ArrayList<Double>(10);
    }


    /**
     * Creates a vector of given size with entries initialized to val
     */
    public Vector(int size, double val){

        create(size, val);
    }


    /**
     * Creates a vector of given size with entries initialized to 0.0
     */
    public Vector(int size){
        this(size, 0.0);
    }


    /**
     * Create a vector from another vector i.e. copy constructor
     */
    public Vector(Vector data){
        this(data.size(), 0.0);
        this.set(data);
    }


    /**
      * Resize the vector
     */
    public final void resize(int size){

        if(data == null){
            create(size, 0.0);
        }
        else{

            // nothing to do here if sizes are the same
            if(size == data.size()){
                return;
            }

            ArrayList<Double> newVec = new ArrayList<Double>(size);

            for(int i=0; i<size; i++){
                newVec.add(0.0);
            }

            if(size > data.size()){

                for(int i=0; i<data.size(); ++i){

                    newVec.set(i, data.get(i));
                }
            }
            else{

                for(int i=0; i<size; ++i){

                    newVec.set(i, data.get(i));
                }
            }

            this.data = newVec;
        }
    }

    public final int size(){

        if(data == null){
            return 0;
        }

        return this.data.size();
    }


    public final void zero(){

        if(this.data == null){

            throw new NullPointerException("Vector has not been created");
        }

        if(this.data.size() == 0){

            throw new IllegalStateException("Vector has not been initialized properly");
        }

        for(int i=0; i<this.data.size(); ++i){

            this.data.set(i, 0.0);
        }
    }

    /**
     * Returns the i-th entry of the Vector
     */
    public final Double get(int i){
        return this.data.get(i);
    }

    /**
     * Set the i-th entry to val
     */
    public final void set(int i, double val){

        if(i <0 || i>= data.size()){
            throw  new IllegalArgumentException("Invalid index. index given not in [0, "+data.size()+")");
        }

        this.data.set(i, val);
    }

    /**
     * Set the  entries to val
     */
    public final void set(Vector values){

        if(values.size() != this.size()){
            throw  new IllegalArgumentException("Invalid Vector size: "+ values.size() + " != " + this.size());
        }

        for(int i=0; i<this.size(); ++i){
            this.data.set(i, values.get(i));
        }
    }

    /**
     * Set the values of the Vector using the Row provided
     */
    public final void set(Row row){

        if(row == null){
            throw  new IllegalArgumentException("Row input should not be null");
        }

        for (int i = 0; i < row.columnCount(); i++) {
            this.set(i, row.getDouble(i));
        }
    }

    /**
     * Scale the components of the vector with the given scalar
     */
    public final void scale(double factor){

        if(this.data.size() == 0){

            throw new IllegalStateException("Vector has not been initialized properly");
        }

        for(int i=0; i<this.data.size(); ++i){

            this.data.set(i, factor*this.data.get(i));
        }
    }

    /**
     * operation +=
     */
    public void add(int i, double value){
        double val = this.data.get(i);
        this.data.set(i , val + value);
    }

    /**
     * Normalze the Vector
     */
    public final void normalize(){

        double length = VectorOperations.l2Norm(this);

        if(length - CommonConstants.getTol() < 0.0){
            throw new IllegalStateException("Zero length vector cannot be normalized");
        }

        this.scale(1.0/length);
    }

    /**
     * Returns the raw data structure that holds the elements of the Vector
     * @return
     */
    public final ArrayList<Double> getRawData(){return this.data;}


    private final void create(int size, double val){

        if(size == 0){
            throw new IllegalArgumentException("Cannot create a vector with zero size");
        }

        this.data = new ArrayList<Double>(size);

        for(int i=0; i<size; ++i){

            data.add(val);
        }
    }

    private ArrayList<Double> data = null;
}
