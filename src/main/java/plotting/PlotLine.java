package plotting;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.LinePlot;
import tech.tablesaw.plotly.components.Figure;

public class PlotLine {

    /**
     * Plots a line given the chart options and two numeric columns
     */
    public static void plotLine(PlotOptions options, DoubleColumn x, DoubleColumn y){

        Table table = Table.create(x, y);
        Plot.show(LinePlot.create(options.plotTitle, table, x.name(), y.name()));
    }

    public static Figure buildPlot(PlotOptions options, DoubleColumn x, DoubleColumn y){

        Table table = Table.create(x, y);
        return LinePlot.create(options.plotTitle, table, x.name(), y.name());
    }
}
