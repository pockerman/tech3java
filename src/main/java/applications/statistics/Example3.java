package applications.statistics;

import it.unimi.dsi.fastutil.doubles.AbstractDoubleList;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import utils.ListMaths;
import utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

/** Category: Statistics
 * ID: Example1
 * Description: Simulate the standard error for the mean is 1/sqrt(n)
 * Taken From:
 * Details:
 * TODO
 */
public class Example3 {


    public static List<Double> getNormalSample(double mu, double sd, int n){

        List<Double> sample = new ArrayList<>(n);
        NormalDistribution dist = new NormalDistribution(mu, sd);

        for(int i=0; i<n; ++i){
            sample.add(dist.density(i));
        }

        return sample;
    }

    public static void main(String[] args){


        final double N_SIM = 1000;
        final int N = 10;
        final  double MU = 0.0;
        final double SIGMA = 1.0;
        List<Double> means = new ArrayList<Double>();

        for( int itr=0; itr < N_SIM; ++itr){
            List<Double> sample = Example3.getNormalSample(MU, SIGMA, N);

            double mean = ListMaths.sum(sample)/((double)sample.size());
            System.out.println(mean);
            means.add(mean);
        }

        double[] vals = ListUtils.toDoubleArray(means); //ArrayUtils.toPrimitive((Double[])means.toArray());
        DescriptiveStatistics stats = new DescriptiveStatistics(vals );

        System.out.println("Standard deviation  of means is: "+stats.getStandardDeviation());
        System.out.println("1/sqrt(N) is: " + 1.0/Math.sqrt(N));

    }
}
