package AndersEksempel;

public interface State {
    int getIndex();
    // Depending on impl.
    boolean isFinal();
}
