package maths.functions.generators;

import datastructs.interfaces.I2DDataSet;

import java.util.*;

public class UniformRandomGenerator implements IRandomGenerator {

    @Override
    public <DataSetTp extends I2DDataSet> List<Object> generate(DataSetTp dataSet, int n){

        int min = 0;
        int max = dataSet.m();
        Random random = new Random();
        List<Object> result = new ArrayList<>();
        Set<Integer> touched = new HashSet<>();

        for(int r=0; r<n; ++r){

            int candidate = random.nextInt((max - min) + 1) + min;

            if(touched.contains(candidate)){
                continue;
            }
            result.add(dataSet.getRow(candidate));
            touched.add(candidate);
        }

        return result;
    }
}
