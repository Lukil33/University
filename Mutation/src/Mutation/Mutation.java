package Mutation;

import Utility.Geraldo;

public interface Mutation{
    boolean isActive();
    void applyMutation(Geraldo g);
}
