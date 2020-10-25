package LogGenerator;

public class State implements iState{
    private final int index;
    private final boolean isFinal;


    public State(int index, boolean isFinal) {
        this.index = index;
        this.isFinal = isFinal;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public boolean isFinal() {
        return isFinal;
    }
}
