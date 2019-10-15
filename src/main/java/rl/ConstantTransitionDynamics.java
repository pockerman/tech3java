package rl;

public class ConstantTransitionDynamics implements ITransitionDynamics {

    public ConstantTransitionDynamics(double value){
        this.value = value;
    }

    /**
     * Returns the value that represents the value of the probability
     * @return
     */
    public double getValue() {
        return value;
    }

    /**
     * Set the value that represents the transition probability
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Returns the probability getting at state sprime with reward r
     * when at state s and executing action a
     * @param sprime The state to get to
     * @param r The reward anticipated
     * @param s the state currently on
     * @param a The action required from s to sprime
     * @return probability estimate
     */
    public double pr(IState sprime, double r, IState s, IAction a){
        return this.value;
    }

    private double value;
}
