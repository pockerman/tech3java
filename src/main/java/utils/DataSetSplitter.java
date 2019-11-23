package utils;

import datastructs.interfaces.I2DDataSet;
import datastructs.interfaces.IVector;

import java.util.*;

public class DataSetSplitter {

    /**
     * Split the given dataset and the associated labels into two datasets.
     * The first data set receives approximately 1-alpha entries and the second
     * receives the remaining alpha. Alpha should be between [0, 1.0]
     */
    public static  <RowType, ValueType> List<Pair<I2DDataSet<RowType>, IVector<ValueType>>> split(I2DDataSet<RowType> dataSet,
                                                                                                  IVector<ValueType> labels, double alpha){

        List<Pair<I2DDataSet<RowType>, IVector<ValueType>>> reslt = new ArrayList<>();

        if(dataSet.m() != labels.size()){
            throw new IllegalArgumentException("Cannot split sets of different size");
        }

        int alphaRows = (int) (labels.size()*alpha);

        int min = 0;
        int max = labels.size();
        Random random = new Random();

        I2DDataSet train = dataSet.create(dataSet.m()-alphaRows, dataSet.n());
        I2DDataSet test = dataSet.create(alphaRows, dataSet.n());

        IVector labelsTrain = labels.create(labels.size()-alphaRows);
        IVector labelsTest = labels.create(alphaRows);

        Set<Integer> touched = new HashSet<>();

        for (int i = 0; i < alphaRows; i++) {

            int candidate = random.nextInt((max - min) + 1) + min;

            while(touched.contains(candidate)){
                candidate = random.nextInt((max - min) + 1) + min;
            }

            RowType row = dataSet.getRow(candidate);
            ValueType value = labels.get(candidate);

            test.set(i, row);
            labelsTest.set(i, value);

            touched.add(candidate);
        }

        int counter =0;
        for (int i = 0; i < max; i++ ) {

            if(touched.contains(i)){
                continue;
            }

            RowType row = dataSet.getRow(i);
            ValueType value = labels.get(i);

            train.set(counter, row);
            labelsTrain.set(counter, value);
            counter++;
        }

        reslt.add(PairBuilder.makePair(train,labelsTrain));
        reslt.add(PairBuilder.makePair(test,labelsTest));

        return reslt;
    }
}
