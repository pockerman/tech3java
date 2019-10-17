package rl;

public interface IPolicyBuilder<PolicyType> {

    /**
     * Build a PolicyType
     * @return
     */
    PolicyType build();
}
