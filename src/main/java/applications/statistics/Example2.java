package applications.statistics;

import org.python.util.PythonInterpreter;
import plotting.PlotLine;
import plotting.PlotOptions;
import plotting.PlotScatter;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.components.Figure;
import utils.TableDataSetLoader;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/** Category: Statistics
 * ID: Example2
 * Description: Scatter plot
 * Taken From:
 * Details:
 * TODO
 */
public class Example2 {

    public static void main(String[] args) throws IOException {

        // load the data
        Table dataSet = TableDataSetLoader.loadDataSet(new File("src/main/resources/datasets/iris_data.csv"));

        DoubleColumn sepalLength = dataSet.doubleColumn("sepal_length");
        sepalLength.setName("Sepal Length (cm)");
        DoubleColumn sepalWidth = dataSet.doubleColumn("sepal_width");
        sepalWidth.setName("Sepal Width (cm)");

        PlotOptions options = new PlotOptions();
        options.plotTitle = "Sepal Length vs Width";

        Figure scatter = PlotScatter.buildPlot(options, sepalLength, sepalWidth);

        DoubleColumn x = dataSet.doubleColumn("petal_length");
        x.setName("Petal Length (cm)");
        DoubleColumn y = dataSet.doubleColumn("petal_width");
        y.setName("Petal Width (cm)");

        PlotOptions petalOptions = new PlotOptions();
        petalOptions.plotTitle = "Petal Length vs Width";


        Figure line = PlotLine.buildPlot(petalOptions, x, y);

        Plot.show(scatter);
        Plot.show(line);


    }
}
