package AndersEksempel;

public class AbcdeState implements State {
    private final int index;
    private final boolean isFinal;

    public AbcdeState(int index, boolean isFinal) {
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
