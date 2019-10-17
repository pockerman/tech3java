package rl;

public class UniformPolicy implements IPolicy {


    public UniformPolicy(double value){
        this.value = value;
    }

     /**
     * Returns the value of the policy for the given action when at the given state
     * @param action The action to be performed
     * @param state The state at which the action takes place
     * @return
     */
     public double value(IAction action, IState state){
         return  this.value;
     }

     private double value;
}
