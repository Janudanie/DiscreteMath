package AndersEksempel;

public class Main {

    public static void main(String... args) {
        Automaton automaton = new AbcdeAutomaton();
        String word = "abce";
        State state = automaton.getInitialState();
        System.out.println("state"+state.getIndex());

        for (char symbol : word.toCharArray()) {
            if (state == null) System.out.println(word+" does not match");
            state = automaton.nextState(state, symbol);
            System.out.println("State"+state.getIndex());
        }
        if (state == null) System.out.println(word+" does not match");
        else if (state.isFinal()) System.out.println("You had a match");
        else System.out.println("Partially match");
    }
}
