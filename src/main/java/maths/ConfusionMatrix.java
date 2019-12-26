package maths;

import datastructs.maths.DenseMatrixSet;
import datastructs.maths.RowBuilder;
import datastructs.utils.RowType;
import utils.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ConfusionMatrix
 */
public class ConfusionMatrix {

    public ConfusionMatrix(List<Pair<Integer, Integer>> classes, List<String> names){

        if(classes == null){
            throw new IllegalArgumentException("Classes should not be null");
        }

        data_ = new DenseMatrixSet<>(RowType.Type.VECTOR, new RowBuilder(), names.size(), names.size(), -1);

        Map<Integer, List<Integer>> result = new HashMap<>();

        for(int i=0; i<classes.size(); ++i){

            Pair<Integer, Integer> pair = classes.get(i);
            Integer classIdx = pair.first;

            if(result.containsKey(classIdx)){
                    result.get(classIdx).add(classIdx, 1);

            }
            else{

                List<Integer> values = new ArrayList<>(names.size());

                for(int j=0; j<names.size(); ++j){
                    values.add(0);
                }

                result.put(classIdx, values);
            }
        }

    }

    @Override
    public String toString(){

        StringBuilder builder = new StringBuilder();

        for(int i=0; i<this.names.size(); ++i){
            builder.append(names.get(i)+ " ");
        }

        return builder.toString();
    }


    private List<String> names;
    private DenseMatrixSet<Integer> data_;
}
