package rl;



import java.util.ArrayList;

public class StateSpaceImpl<T extends IState> implements IStateSpace<T> {

    public StateSpaceImpl(int nStates, ITransitionDynamics dynamics){

        this.states = new ArrayList<IState>(nStates);
        this.dynamics = dynamics;
    }

    /**
     * Returns the number of states the space has
     */
    @Override
    public int nStates(){
        return this.states.size();
    }


    /**
     * Returns the i-th state
     */
    @Override
    public IState getState(int i){
        return this.states.get(i);
    }


    /**
     * Add a state in the space
     */
    @Override
    public void addState(IState state){
        this.states.add(state);
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
    @Override
    public double transitionDynamics(IState sprime, double r, IState s, IAction a){
        return this.dynamics.pr(sprime, r, s, a);
    }


    /**
     * The states
     */
    private ArrayList<IState> states;

    /**
     * the object that describes the dynamics
     */
    ITransitionDynamics dynamics;
}
