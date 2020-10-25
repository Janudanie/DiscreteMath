package AndersEksempel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AbcdeAutomaton implements Automaton {
    private final Alphabet alphabet = new AbcdeAlphabet();
    private final List<State> states = new ArrayList<>();
    private final State[][] table;
    private final State initialState;

    public AbcdeAutomaton() {
        states.add(initialState = new AbcdeState(0, false));
        for (int index = 1; index < 4; index++) {
            if (index == 3) states.add(new AbcdeState(index, true));
            else states.add(new AbcdeState(index, false));
        }
        table = new State[states.size()][alphabet.size()];
        // Actual automaton:
        table[0][0] = states.get(1);

        table[1][1] = states.get(1);
        table[1][alphabet.indexOf('c')] = states.get(2);
        table[1][4] = states.get(3);

        table[2][3] = states.get(1);
    }

    @Override
    public Alphabet getAlphabet() { return alphabet; }

    @Override
    public List<State> getStates() { return states; }

    @Override
    public State getInitialState() { return initialState; }

    @Override
    public State nextState(State state, char symbol) {
        return table[state.getIndex()][alphabet.indexOf(symbol)];
    }

}
