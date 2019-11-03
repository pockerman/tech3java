package utils;

import java.util.*;

public class ClassificationVoter implements IVoter<Integer, Double, List<Pair<Integer, Double>> > {


    public ClassificationVoter(int maxResults){

        this.maxResults = maxResults;

    }

    public void addItem(Integer item, Double criterionType){
        this.values.add(PairBuilder.makePair(item, criterionType));
    }

    @Override
    public List<Pair<Integer, Double>> getResult(){

        //get the values
        Arrays.sort((Object[]) values.toArray(), new Comparator<Object>() {
            @Override
            public int compare(Object t, Object t1) {

                if(((Pair<Integer, Double>)t).second < ((Pair<Integer, Double>)t1).second ){
                    return -1;
                }
                else if(((Pair<Integer, Double>)t).second > ((Pair<Integer, Double>)t1).second){
                    return 1;
                }

                return 0;
            }
        });

        return this.values.subList(0, this.maxResults);
    }

    private List<Pair<Integer, Double>> values;
    private int maxResults;
}
