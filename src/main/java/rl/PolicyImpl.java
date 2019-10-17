package rl;

import java.util.HashMap;
import java.util.Map;

public class PolicyImpl  {

    public PolicyImpl(){
        this.policy = new HashMap<>();
    }

    public void addAction(IState state, IAction action){
        policy.put(state, action);
    }

    public IAction getAction(IState state){
        return policy.get(state);
    }


    Map<IState, IAction> policy;
}
