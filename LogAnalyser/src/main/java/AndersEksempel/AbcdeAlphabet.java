package AndersEksempel;

public class AbcdeAlphabet implements Alphabet {

    @Override
    public int indexOf(char symbol) {
//    if (symbol == 'a') return 0;
//    if (symbol == 'b') return 1;
//    if (symbol == 'c') return 2;
//    if (symbol == 'd') return 3;
//    if (symbol == 'e') return 4;
//    throw new IllegalArgumentException();
        if (symbol < 'a' || 'e' < symbol) throw new IllegalArgumentException();
        return symbol - 'a';
    }

    @Override
    public char symbolOf(int index) {
        if (index < 0 || 4 < index) throw new IllegalArgumentException();
        return (char)('a' + index);
    }

    @Override
    public int size() { return 5; }

}
