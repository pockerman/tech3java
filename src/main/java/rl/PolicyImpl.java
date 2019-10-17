package rl;

import java.util.HashMap;
import java.util.Map;

/**
 * Map-based Policy implementation. This implementation assumes
 * that for each state only one action is possible
 */
public class PolicyImpl implements IPolicy  {

    /**
     * constructor. Constructs and empty policy
     */
    public PolicyImpl(){
        this.policy = new HashMap<>();
    }


    /**
     * Returns the size of the policy
     * @return
     */
    public int size(){
        return this.policy.size();
    }

    /**
     * Add a state-action
     * @param state The state
     * @param action The action
     */
    @Override
    public void addAction(IState state, IAction action){
        policy.put(state, action);
    }

    /**
     * Returns the action associated with the given state
     * @param state The state
     * @return IAction
     */
    @Override
    public IAction getAction(IState state){
        return policy.get(state);
    }


    /**
     * The mapping state-action
     */
    Map<IState, IAction> policy;
}
