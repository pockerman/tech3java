package plotting;

import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.ScatterPlot;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.components.Figure;

public class PlotScatter {

    public static void plot(PlotOptions options, DoubleColumn x, DoubleColumn y){

        Table table = Table.create(x, y);
        Plot.show(ScatterPlot.create(options.plotTitle, table, options.xAxisName, options.yAxisName));
    }

    public static Figure buildPlot(PlotOptions options, DoubleColumn x, DoubleColumn y){

        Table table = Table.create(x, y);
        return ScatterPlot.create(options.plotTitle, table, options.xAxisName, options.yAxisName);
    }

}
