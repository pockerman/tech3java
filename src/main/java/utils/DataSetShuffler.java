package utils;

import datastructs.interfaces.I2DDataSet;
import datastructs.interfaces.IVector;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DataSetShuffler {

    public static void shuffle(I2DDataSet dataSet){
        int min = 0;
        int max = dataSet.m();
        Random random = new Random();

        Set<Integer> touched = new HashSet<>();

        for(int r=0; r<max; ++r){

            if(touched.contains(r)){
                continue;
            }

            int candidate = random.nextInt((max - min) + 1) + min;

            if(touched.contains(candidate)){
                continue;
            }

            // exchange
            dataSet.excahngeRows(r , candidate);
            touched.add(r);
            touched.add(candidate);
        }
    }

    public static void shuffle(I2DDataSet dataSet, IVector labels){

        if(dataSet.m() != labels.size()){
            throw new IllegalArgumentException("Cannot shuffle sets of different size");
        }

        int min = 0;
        int max = labels.size();
        Random random = new Random();
        Set<Integer> touched = new HashSet<>();

        for (int i = 0; i < labels.size(); i++) {

            if(touched.contains(i)){
                continue;
            }

            int candidate = random.nextInt((max - min) + 1) + min;

            if(touched.contains(candidate)){
                continue;
            }

            dataSet.excahngeRows(i , candidate);
            labels.excahnge(i, candidate);
            touched.add(i);
            touched.add(candidate);
        }
    }
}
