package parallel.tasks;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class SumSqrTask<ContainerType extends List> extends TaskBase<Double> {

    public SumSqrTask(final List data){
        super();
        this.data = data;
        this.result = 0.0;

    }

    public SumSqrTask(final List data, CyclicBarrier barrier){
        super(barrier);
        this.data = data;
        this.result = 0.0;

    }

    @Override
    public  Double call(){

        this.run();
        return this.result;

    }

    @Override
    public void run(){

        for (Object item: this.data) {
            Double val = (Double) item;
            this.result += val*val;
        }

        this.finished = true;

        if(this.barrier != null){
            this.waitOnBarrier();
        }
    }

    public Double getResult(){
        return this.result;
    }

    private Double result;
    private List data;

}
