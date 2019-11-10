package applications.ml;

import datastructs.maths.DenseMatrix;
import tech.tablesaw.api.Table;
import tech.tablesaw.io.csv.CsvReadOptions;

import java.io.File;
import java.io.IOException;

/** Category: Machine Learning
 * ID: Example1
 * Description: Apply regression on an energy efficiency dataset
 * Taken From:
 * Details:
 * Dataset taken from: https://archive.ics.uci.edu/ml/datasets/Energy+efficiency.
 * TODO
 */
public class Example2 {

    public static Table loadDataSet(File csvFile) throws IOException {

        CsvReadOptions options = CsvReadOptions.builder(csvFile).missingValueIndicator("null").build();
        Table dataSet = Table.read().usingOptions(options);
        return dataSet;
    }

    public static void main(String[] args){

        try {

            // load the dataset
            Table dataSet = Example2.loadDataSet(new File("src/main/resources/datasets/ENB2012_data.csv"));
            System.out.println(dataSet.rowCount());
            System.out.println(dataSet.columnCount());

            //DenseMatrix denseMatrix = new DenseMatrix();
            //denseMatrix.initializeFrom(dataSet);
        }
        catch(IOException e)
        {

        }
    }
}
