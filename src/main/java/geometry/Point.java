package geometry;
/**
 * Basic class that holds index info
 */
public class Point {



    public Point(){
        this(-1, -1);
    }

    public Point(int i, int j){
        this.i = i;
        this.j = j;
    }

    /**
     * Return the i-th coordinate
     */
    public int getI(){
        return i;
    }

    /**
     * Return the j-th coordinate
     */
    public int getJ() {
        return j;
    }

    @Override
    public final boolean equals(Object other){

        if(other == this){
            return true;
        }

        if(!(other instanceof Point)){
            return false;
        }

        return this.i == ((Point) other).i && this.j == ((Point) other).j;
    }


    /**
     * Override the hashCode since equals() is also overriden
     * @return hash code
     */
    @Override
    public int hashCode(){
        return i+j;
    }


    /**
     * Return a String representation of the Point
     */
    @Override
    public String toString(){
        return Integer.toString(this.i) + Integer.toString(this.j);
    }

    /**
     * Returns true if the point has valid coordinates
     */
    public final boolean isValid(){
        return this.i >=0 && this.j >= 0;
    }

    int i = -1;
    int j = -1;
}
