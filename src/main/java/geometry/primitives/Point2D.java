package geometry.primitives;

public class Point2D<T extends  Number> {




    public Point2D(T i, T j){
        this.i = i;
        this.j = j;
    }

    public Point2D(T[] coords){
        this(coords[0], coords[1]);
    }

    public final  T getI(){
        return i;
    }

    public final T getJ(){
        return j;
    }

    private T i;
    private T j;

}
