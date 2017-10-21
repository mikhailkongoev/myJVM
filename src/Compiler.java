import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.ArrayList;

public class Compiler {
    public static void compile(String sourcePath) throws IOException {
        String targetPath = sourcePath.substring(0, sourcePath.indexOf(".myJava")) + ".myClass";

        ANTLRInputStream input = new ANTLRInputStream(new FileReader(sourcePath));
        JavaGrammarLexer lexer = new JavaGrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaGrammarParser parser = new JavaGrammarParser(tokens);
        ParseTree tree = parser.code();
        ParseTreeWalker walker = new ParseTreeWalker();
        myCodeListener myCodeListener = new myCodeListener();
        walker.walk(myCodeListener, tree);

        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(targetPath));

        ArrayList<String> byteCode = myCodeListener.getAnswer();
        int size = byteCode.size();
        for (int i = 0; i < size; i++) {
            out.write(i + ": " + byteCode.get(i) + '\n');
        }

        out.close();
    }
}
