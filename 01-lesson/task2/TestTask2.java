package task2;

import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestTask2 {
    class StringNextReader implements NextReader {
        private Scanner scanner;

        public StringNextReader(String in) {
            scanner = new Scanner(in);
        }

        @Override
        public String next() {
            return scanner.next();
        }

        @Override
        public int nextInt() {
            return scanner.nextInt();
        }
    }

    @Test
    public void test1() {
        final String input = "7\n" +
                "10 47 50 63 89 90 99\n" +
                "4\n" +
                "84 33 10 82";
        final NextReader reader = new StringNextReader(input);
        final Parser parser = new Parser(reader);

        final StringWriter stringWriter = new StringWriter();
        final PrintWriter out = new PrintWriter(stringWriter);

        new Solver(parser, out).solve();

        assertEquals("NO\nNO\nYES\nNO\n", stringWriter.toString());
    }
}