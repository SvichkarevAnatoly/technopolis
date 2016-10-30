package other;

import collections.ArrayStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Считаем, что операции деления на ноль отсутствуют
 */
public class Solver {
    private static final String QUIT = "q";

    private static final char RIGHT_PAREN  = ')';
    private static final char PLUS         = '+';
    private static final char MINUS        = '-';
    private static final char TIMES        = '*';
    private static final char DIVISION     = '/';

    public static double evaluate(String[] values) {
        final ArrayStack<String> tokenStack = new ArrayStack<>();
        for (String token : values) {
            if (!token.equals(String.valueOf(RIGHT_PAREN))) {
                tokenStack.push(token);
            } else {
                final double second = Double.valueOf(tokenStack.pop());
                final char operation = tokenStack.pop().charAt(0);
                double first = Double.valueOf(tokenStack.pop());
                tokenStack.pop(); // LEFT_PAREN
                switch (operation) {
                    case PLUS:
                        first += second;
                        break;
                    case MINUS:
                        first -= second;
                        break;
                    case TIMES:
                        first *= second;
                        break;
                    case DIVISION:
                        first /= second;
                        break;
                }
                tokenStack.push(String.valueOf(first));
            }
        }
        return Double.parseDouble(tokenStack.pop());
    }

    public static void main(String[] args) {
        try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
            String sequence;
            while (!QUIT.equals(sequence = lineReader.readLine())) {
                System.out.println(evaluate(sequence.split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
