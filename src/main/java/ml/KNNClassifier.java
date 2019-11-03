package ml;

import maths.DistanceCalculator;
import utils.IDataSetWrapper;
import utils.IVoter;

/**
 * KNNClassifier performs classification using the KNN algorithm
 */
public class KNNClassifier<DataSetType extends IDataSetWrapper,
                           DistanceType extends DistanceCalculator,
                           VoterType extends IVoter> {

    /**
     * Constructor
     */
    public KNNClassifier(int k, boolean copyDataset){
        this.k = k;
        this.copyDataset = copyDataset;
    }


    public void setDistanceCalculator(DistanceType distanceCalculator){
        this.distanceCalculator = distanceCalculator;
    }

    public void setMajorityVoter(VoterType voter){
        this.majorityVoter = voter;
    }

    /**
     * Train the model using the provided dataset
     */
    public void train(DataSetType dataSet){

        if(this.copyDataset){
            this.dataSet = (DataSetType) dataSet.copy();
        }
        else{
            this.dataSet = dataSet;
        }
    }

    /**
     * Predict the class of the given data point
     */
    public <PointType> Integer  predict(PointType point){

        // loop over the items in the dataset and compute distances
        for (int i = 0; i < this.dataSet.nRows(); i++) {

            this.majorityVoter.addItem(i, this.distanceCalculator.calculate(this.dataSet.getRow(i), point));
        }

        return (Integer) this.majorityVoter.getResult();
    }

    /**
     * Number of neighbors to consider
     */
    private int k;

    /**
     * flag indicating whether the dataset should be fully copied
     */
    boolean copyDataset;

    /**
     * The dataset
     */
    DataSetType dataSet;

    /**
     * The distance used
     */
    DistanceType distanceCalculator;

    /**
     * How to get the majority set
     */
    VoterType majorityVoter;
}
