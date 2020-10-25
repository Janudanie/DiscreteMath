package AndersEksempel;

import java.util.List;

public interface Automaton {
    Alphabet getAlphabet();
    List<State> getStates();
    State getInitialState();
    // Dependent of impl.
    // Set<State> getFinalStates();
    State nextState(State state, char symbol);
}
