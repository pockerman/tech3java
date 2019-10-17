package applications.rl;


import rl.*;
import static base.CommonConstants.getTol;
import java.util.ArrayList;


public class GridWorldWithiterativePolicyEvaluation {

    class Action implements IAction
    {
        public Action(String actionType, IState state){

            this.actionType = actionType;
            this.state = state;

        }

        /**
         * The state that the action leads to
         */
        @Override
        public void addTransitionToState(IState state){
            this.state = state;
        }

        @Override
        public String toString(){

            return this.actionType;
        }

        /**
         * Returns the state to transition to
         */
        public IState getTransitionToState(){
            return this.state;
        }

        private String actionType;
        private IState state;
    }

    class State implements IState
    {

        public State(int id){

            this.id = id;
            this.actions = new ArrayList<IAction>();
        }

        /**
         * Returns the id of the state
         */
        @Override
        public int getId(){return this.id;}


        /**
         * Add an action to be executed when at this state
         */
        @Override
        public void addAction(IAction action){
            actions.add(action);
        }

        /**
         * Returns the i-th action that is possible when at this state
         * @param i
         * @return IAction The i-th action when at this state
         */
        @Override
        public IAction getAction(int i){
            return this.actions.get(i);
        }

        /**
         * Number of actions for this IState
         */
        @Override
        public int nActions(){
            return this.actions.size();
        }


        @Override
        public boolean equals(Object other){

            if(this == other){
                return true;
            }

            if(!(other instanceof State)){
                return false;
            }

            return this.getId() == ((State)other).getId();
        }

        @Override
        public int hashCode(){
            return this.getId();
        }


        /**
         * Returns the state that this state transitions to when the action with the given local id is apllied
         * @param actionId Action local id
         * @return IState
         */
        public IState applyAction(int actionId){
            return this.actions.get(actionId).getTransitionToState();
        }


        /**
         * Return the probability of taking the action with the given name
         * whilst at this state
         */
        @Override
        public double getActionProbability(int actionIdx){
            return 0.25;
        }

        @Override
        public double getReward(){
            return -1.0;
        }

        /**
         * Returns true if the state is a terminal state
         */
        @Override
        public boolean isTerminal(){
            return this.isTerminalState;
        }


        /**
         * Set a state that this state can transition to
         */
        public void makeTerminalState(){
            this.isTerminalState = true;
        }

        int id;
        ArrayList<IAction> actions;
        boolean isTerminalState = false;
    }

    /**
     * The state space
     */
    private StateSpaceImpl<State> stateSpace;

    /**
     * An object that performs value function evaluation using iterative policy
     */
    private ValueFunctionIterativePolicyEvaluation valueFunction;

    /**
     * The object that holds the optimal policy
     */
    ValueFunctionOptimalPolicyBuilder<StateSpaceImpl<State>, PolicyImpl> policyBuilder;

    public void createStateSpace(){

        stateSpace = new StateSpaceImpl<>(16, new ConstantTransitionDynamics(1.0));

        // populate with states
        for(int s=0; s<16; s++) {

            State state = new State(s);
            stateSpace.addState(state);
        }


        for(int s=0; s<16; s++) {

            IState state = stateSpace.getState(s);

            if(s == 0){

                state.addAction(new Action("RIGHT", stateSpace.getState(1)) );
                state.addAction(new Action("TOP",   stateSpace.getState(4)));
                state.addAction(new Action("LEFT",  stateSpace.getState(0)));
                state.addAction(new Action("BOTTOM",  stateSpace.getState(0)));

            }

            else if(s == 1){

                state.addAction(new Action("RIGHT", stateSpace.getState(2)) );
                state.addAction(new Action("TOP",   stateSpace.getState(5)));
                state.addAction(new Action("LEFT",  stateSpace.getState(0)));
                state.addAction(new Action("BOTTOM",  stateSpace.getState(1)));

                
            }
            else if(s  == 2){

                state.addAction(new Action("RIGHT", stateSpace.getState(3)));
                state.addAction(new Action("TOP",   stateSpace.getState(6)));
                state.addAction(new Action("LEFT",  stateSpace.getState(1)));
                state.addAction(new Action("BOTTOM",  stateSpace.getState(2)));

            }
            /*else if( s == 3){

                state.addAction(new Action("TOP",  stateSpace.getState(7)));
                state.addAction(new Action("LEFT", stateSpace.getState(2)));
                state.addAction(new Action("BOTTOM",  stateSpace.getState(3)));
                state.addAction(new Action("RIGHT",  stateSpace.getState(3)));
            }*/
            else if(s == 4){

                state.addAction(new Action("BOTTOM",stateSpace.getState(0) ));
                state.addAction(new Action("RIGHT" ,stateSpace.getState(5) ));
                state.addAction(new Action("TOP"   ,stateSpace.getState(8) ));
                state.addAction(new Action("LEFT",  stateSpace.getState(4)));
               
            }
            else if(s == 5){

                state.addAction(new Action("BOTTOM",stateSpace.getState(1) ));
                state.addAction(new Action("RIGHT" ,stateSpace.getState(6) ));
                state.addAction(new Action("TOP"   ,stateSpace.getState(9) ));
                state.addAction(new Action("LEFT"  ,stateSpace.getState(4) ));
            }
            else if(s == 6){

                state.addAction(new Action("BOTTOM", stateSpace.getState(2) ));
                state.addAction(new Action("RIGHT" , stateSpace.getState(7) ));
                state.addAction(new Action("TOP"   , stateSpace.getState(10)));
                state.addAction(new Action("LEFT"  , stateSpace.getState(5) ));
      
            }
            else if(s  == 7){

                state.addAction(new Action("BOTTOM",stateSpace.getState(3)  ));
                state.addAction(new Action("TOP"   ,stateSpace.getState(11) ));
                state.addAction(new Action("LEFT"  ,stateSpace.getState(6)  ));
                state.addAction(new Action("RIGHT",  stateSpace.getState(7)));
            }
            else if( s ==  8){

                state.addAction(new Action("BOTTOM",stateSpace.getState(4)  ));
                state.addAction(new Action("RIGHT" ,stateSpace.getState(9)  ));
                state.addAction(new Action("TOP"   ,stateSpace.getState(12) ));
                state.addAction(new Action("LEFT",  stateSpace.getState(8)));
            }
            else if(s == 9){

                state.addAction(new Action("BOTTOM",stateSpace.getState(5)  ));
                state.addAction(new Action("RIGHT" ,stateSpace.getState(10) ));
                state.addAction(new Action("TOP"   ,stateSpace.getState(13) ));
                state.addAction(new Action("LEFT"  ,stateSpace.getState(8)  ));
            }
            else if(s == 10){

                state.addAction(new Action("BOTTOM",stateSpace.getState(6)  ));
                state.addAction(new Action("RIGHT" ,stateSpace.getState(11) ));
                state.addAction(new Action("TOP"   ,stateSpace.getState(14) ));
                state.addAction(new Action("LEFT"  ,stateSpace.getState(9)  ));
            }
            else if(s == 11){

                state.addAction(new Action("BOTTOM",stateSpace.getState(7)  ));
                state.addAction(new Action("TOP"   ,stateSpace.getState(15) ));
                state.addAction(new Action("LEFT"  ,stateSpace.getState(10) ));
                state.addAction(new Action("RIGHT",  stateSpace.getState(11)));
            }
            /*else if(s  == 12){

                state.addAction(new Action("BOTTOM",stateSpace.getState(8)  ));
                state.addAction(new Action("RIGHT" ,stateSpace.getState(13) ));

            }*/
            else if( s == 13){

                state.addAction(new Action("BOTTOM",stateSpace.getState(9)   ));
                state.addAction(new Action("RIGHT" ,stateSpace.getState(14)  ));
                state.addAction(new Action("LEFT"  ,stateSpace.getState(12)  ));
                state.addAction(new Action("TOP",  stateSpace.getState(13)));
            }
            else if(s == 14){

                state.addAction(new Action("BOTTOM", stateSpace.getState(10) ));
                state.addAction(new Action("RIGHT" , stateSpace.getState(15) ));
                state.addAction(new Action("LEFT"  , stateSpace.getState(13) ));
                state.addAction(new Action("TOP",  stateSpace.getState(14)));

            }
            else if(s == 15){

                state.addAction(new Action("BOTTOM", stateSpace.getState(11) ));
                state.addAction(new Action("LEFT"  , stateSpace.getState(14) ));
                state.addAction(new Action("TOP",  stateSpace.getState(15)));
                state.addAction(new Action("RIGHT",  stateSpace.getState(15)));
            }


            if(state.getId() == 3 || state.getId() == 12){
                ((State) state).makeTerminalState();
            }
        }
    }

    public void createGame(IterativePolicyEvaluationParams params){

        createStateSpace();
        valueFunction = new ValueFunctionIterativePolicyEvaluation(params);

        IPolicyBuilder<PolicyImpl> builder = ()->{return new PolicyImpl();};
        policyBuilder = new ValueFunctionOptimalPolicyBuilder<>(builder, -(Double.MAX_VALUE - 1));
    }


    public void play(){

        valueFunction.evaluate(this.stateSpace, new UniformPolicyValue(0.25));

        double[] values = valueFunction.getValues();

        // we now have Vstar available. We want to calculate the
        // optimal policy pi star from it
        policyBuilder.buildFrom(this.stateSpace, valueFunction);

        // let's check the policy
        IPolicy policy = policyBuilder.getPolicy();

        for(int s=0; s<this.stateSpace.nStates(); ++s){

            IState state = this.stateSpace.getState(s);

            if(!state.isTerminal()){

                IAction action = policy.getAction(state);
                System.out.println("For state: "+state.getId()+" Action is: "+action);

            }
        }
    }

    public static void main(String[] args){

        System.out.println("Playing GridWorld...");
        IterativePolicyEvaluationParams params = new IterativePolicyEvaluationParams();
        params.tol = getTol();
        params.gamma = 1.0;
        params.reward = -1.0;
        params.showItrs = false;

        GridWorldWithiterativePolicyEvaluation game = new GridWorldWithiterativePolicyEvaluation();
        game.createGame(params);
        game.play();
        System.out.println("Done...");

    }
}
