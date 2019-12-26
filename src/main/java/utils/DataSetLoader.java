package utils;

import datastructs.maths.DenseMatrixSet;
import datastructs.maths.RowBuilder;
import datastructs.utils.RowType;
import parallel.partitioners.MatrixRowPartitionPolicy;
import parallel.partitioners.RangePartitioner;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataSetLoader {

    public static Pair<DenseMatrixSet<Double>, List<Integer>> loadIrisDataSet() throws IOException, IllegalArgumentException {

        // load the data
        Table dataSetTable = TableDataSetLoader.loadDataSet(new File("src/main/resources/datasets/iris_data.csv"));

        List<Integer> labels = new ArrayList<>();

        Column species  = dataSetTable.column("species");

        for (int i = 0; i < species.size(); i++) {

            String label = (String) species.get(i);

            if(label.equals("Iris-setosa")){

                labels.add(0);
            }
            else if(label.equals("Iris-versicolor")){

                labels.add(1);
            }
            else if(label.equals("Iris-virginica")){

                labels.add(2);
            }
            else{
                throw new IllegalArgumentException("Unknown class");
            }
        }

        Table reducedDataSet = dataSetTable.removeColumns("species").first(dataSetTable.rowCount());
        DenseMatrixSet dataSet = new DenseMatrixSet(RowType.Type.VECTOR, new RowBuilder());
        dataSet.initializeFrom(reducedDataSet);

        return PairBuilder.makePair(dataSet, labels);
    }
}
