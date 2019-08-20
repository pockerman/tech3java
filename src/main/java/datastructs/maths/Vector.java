package datastructs.maths;

import java.util.ArrayList;

/**
 * Implements a Vector class in the mathematical sense
 *
 *
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
    public final double get(int i){
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
