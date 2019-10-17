package rl;

public class UniformPolicyValue implements IPolicyValue {


    public UniformPolicyValue(double value){
        this.value = value;
    }

     /**
     * Returns the value of the policy for the given action when at the given state
     * @param action The action to be performed
     * @param state The state at which the action takes place
     * @return
     */
     @Override
     public double value(IAction action, IState state){
         return  this.value;
     }

     private double value;
}
