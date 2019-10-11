package rl;



import java.util.ArrayList;

public class StateSpaceImpl<T extends IState> implements IStateSpace<T> {

    public StateSpaceImpl(int nStates){
        this.states = new ArrayList<IState>(nStates);
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
     * The states
     */
    private ArrayList<IState> states;
}
