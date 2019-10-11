package applications.rl;


import rl.*;
import static base.CommonConstants.getTol;

import java.util.ArrayList;
import java.util.Map;

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

        public State(String name, int id){

            this.name = name;
            this.id = id;
            this.actions = new ArrayList<IAction>();
            this.transitionStates = new ArrayList<IState>();
        }

        /**
         * Returns the name of the state
         */
        @Override
        public String getName(){return this.name;}


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
         * Number of actions for this IState
         */
        @Override
        public int nActions(){
            return this.actions.size();
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
        public double getActionProbability(String actionName){
            return 0.25;
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
        public double getStateSumValue(double reward, double discount, double[] previousStates){

            double rslt = 0.0;
            for (int i = 0; i < transitionStates.size() ; i++) {

                rslt += 0.25*(reward + discount*previousStates[i]);
            }

            return rslt;
        }


        @Override
        public double getReward(){
            return -1.0;
        }

        /**
         * Returns the number of states this state can transition to
         */
        @Override
        public int nStateToTransitions(){
            return transitionStates.size();
        }


        /**
         * Returns the i-th IState this IState can transition to
         */
        @Override
        public IState getStateToTransition(int i){
            return transitionStates.get(i);
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
        public void setStateToTransition(IState state){
            this.transitionStates.add(state);
        }

        /**
         * Set a state that this state can transition to
         */
        public void makeTerminalState(){
            this.isTerminalState = true;
        }

        String name;
        int id;
        ArrayList<IAction> actions;
        ArrayList<IState> transitionStates;
        boolean isTerminalState = false;
    }

    private IStateSpace<State> stateSpace;
    private IterativePolicyEvaluation iterativePolicyEvaluation;

    public void createStateSpace(){

        stateSpace = new StateSpaceImpl<>(16);

        // populate with states
        for(int s=0; s<16; s++) {

            State state = new State("State", s);
            stateSpace.addState(state);
        }


        for(int s=0; s<16; s++) {

            IState state = stateSpace.getState(s);
            if(s == 1){

                state.addAction(new Action("RIGHT", stateSpace.getState(0)) );
                state.addAction(new Action("TOP",   stateSpace.getState(2)));
                state.addAction(new Action("LEFT",  stateSpace.getState(5)));

                
            }
            else if(s  == 2){

                state.addAction(new Action("RIGHT", stateSpace.getState(1)));
                state.addAction(new Action("TOP",   stateSpace.getState(3)));
                state.addAction(new Action("LEFT",  stateSpace.getState(6)));

            }
            else if( s == 3){

                state.addAction(new Action("TOP",  stateSpace.getState(7)));
                state.addAction(new Action("LEFT", stateSpace.getState(2)));
            }
            else if(s == 4){

                state.addAction(new Action("BOTTOM",stateSpace.getState(0) ));
                state.addAction(new Action("RIGHT" ,stateSpace.getState(5) ));
                state.addAction(new Action("TOP"   ,stateSpace.getState(8) ));
               
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
            }
            else if( s ==  8){

                state.addAction(new Action("BOTTOM",stateSpace.getState(4)  ));
                state.addAction(new Action("RIGHT" ,stateSpace.getState(9)  ));
                state.addAction(new Action("TOP"   ,stateSpace.getState(12) ));
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
            }
            else if(s  == 12){

                state.addAction(new Action("BOTTOM",stateSpace.getState(8)  ));
                state.addAction(new Action("RIGHT" ,stateSpace.getState(13) ));

            }
            else if( s == 13){

                state.addAction(new Action("BOTTOM",stateSpace.getState(9)   ));
                state.addAction(new Action("RIGHT" ,stateSpace.getState(14)  ));
                state.addAction(new Action("LEFT"  ,stateSpace.getState(12)  ));
            }
            else if(s == 14){

                state.addAction(new Action("BOTTOM", stateSpace.getState(10) ));
                state.addAction(new Action("RIGHT" , stateSpace.getState(15) ));
                state.addAction(new Action("LEFT"  , stateSpace.getState(13) ));

            }
            else if(s == 15){

                state.addAction(new Action("BOTTOM", stateSpace.getState(11) ));
                state.addAction(new Action("LEFT"  , stateSpace.getState(14) ));
            }


            if(state.getId() == 0 || state.getId() == 15){
                ((State) state).makeTerminalState();
            }
        }
    }

    public void createGame(IterativePolicyEvaluationParams params){

        createStateSpace();
        iterativePolicyEvaluation = new IterativePolicyEvaluation(params);
    }


    public void play(){

        iterativePolicyEvaluation.evaluate(this.stateSpace);
    }

    public static void main(String[] args){

        System.out.println("Playing GridWorld...");
        IterativePolicyEvaluationParams params = new IterativePolicyEvaluationParams();
        params.tol = getTol();
        params.gamma = 1.0;
        params.reward = -1.0;

        GridWorldWithiterativePolicyEvaluation game = new GridWorldWithiterativePolicyEvaluation();
        game.createGame(params);
        game.play();
        System.out.println("Done...");

    }
}
