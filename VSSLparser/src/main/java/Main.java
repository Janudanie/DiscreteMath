import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import main.java.TestLexer;
import main.java.TestParser;

public class Main {

    public static void main(String[] args) {
        TestLexer lexer = new TestLexer(CharStreams.fromString("Hello Alex!"));
        TestParser parser = new TestParser(new CommonTokenStream(lexer));

        String name = parser.main().name().getText();
        System.out.println(name);
    }
}


