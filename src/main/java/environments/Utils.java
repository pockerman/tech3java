package environments;
import utils.Pair;

public class Utils {

    public static int directionToInt(Direction dir){
        int dirInt = -1;

        if(dir  == Direction.SOUTH){
            dirInt = 0;
        }
        else if(dir  == Direction.EAST){
            dirInt = 1;
        }
        else if(dir  == Direction.NORTH){
            dirInt = 2;
        }
        else if(dir  == Direction.WEST){
            dirInt = 3;
        }

        return dirInt;
    }


    public static Direction intToDirection(int dirInt){


        if(dirInt  == 0 ){
            return  Direction.SOUTH;
        }
        else if(dirInt  == 1){
            return  Direction.EAST;
        }
        else if(dirInt == 2){
            return Direction.NORTH;
        }
        else if(dirInt  == 3){
            return Direction.WEST;
        }

        return Direction.INVALID;
    }

    /*public static final <T, U> Pair<T, U> makePair(T t, U u){
        Pair<T, U> p = new Pair();
        p.first = t;
        p.second =u;
        return p;
    }*/
}
