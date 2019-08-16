package datastructs.maths;

import java.util.ArrayList;

/**
 * Implements a Vector class in the mathematical sense
 *
 *
 */

public class Vector {


    public Vector(){

        this.data = new ArrayList<Double>(10);
    }


    public Vector(int size, double val){

        create(size, val);
    }


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


    private final void create(int size, double val){

        this.data = new ArrayList<Double>(size);

        for(int i=0; i<size; ++i){

            data.add(val);
        }
    }

    private ArrayList<Double> data = null;
}
