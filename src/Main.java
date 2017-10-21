import resources.JVM;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Compiler.compile(args[0]);
            JVM.execute(args[0].substring(0, args[0].indexOf(".")) + ".myClass");
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}
