package rl;

public interface IPolicy {

    void addAction(IState state, IAction action);

    IAction getAction(IState state);
}
