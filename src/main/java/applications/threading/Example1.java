package applications.threading;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Category: Threading
 * ID: Example1
 * Description: Get the sum of the elements of an array
 * Taken From: Code from the book Modern Java in Action 2nd Edition
 *
 * Details:
 *
 *
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs={"-Xms4G", "-Xmx4G"})
public class Example1 {

    @Benchmark
    public long seqSum(long n){
        return Stream.iterate(1L, i->i+1)
                     .limit(n)
                     .reduce(0L, Long::sum);
    }

    @Benchmark
    public long parSum(long n){
        return Stream.iterate(1L, i->i+1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    @Benchmark
    public long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    @Benchmark
    public long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }



    @TearDown(Level.Invocation)
    public void tearDown() {
        System.gc();
    }


    public static  void main(String[] args){

        Example1 sumArrayElements = new Example1();
        final long N =  10000000L;

        sumArrayElements.seqSum(N);
        sumArrayElements.parSum(N);
        sumArrayElements.rangedSum(N);
        sumArrayElements.parallelRangedSum(N);
    }
}
