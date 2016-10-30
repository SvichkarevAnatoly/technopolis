package other;

import collections.ArrayStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Считаем, что операции деления на ноль отсутствуют
 */
public class SolverExt {

    private static final String QUIT = "q";

    private static final char LEFT_PAREN   = '(';
    private static final char RIGHT_PAREN  = ')';
    private static final char PLUS         = '+';
    private static final char MINUS        = '-';
    private static final char TIMES        = '*';
    private static final char DIVISION     = '/';

    public static double evaluate(String[] values) {
        final ArrayStack<String> tokenStack = new ArrayStack<>();
        tokenStack.push(String.valueOf(LEFT_PAREN)); // обернём всё выражение в скобки
        for (String token : values) {
            if (!token.equals(String.valueOf(RIGHT_PAREN))) {
                tokenStack.push(token);
            } else { // RIGHT_PAREN
                final double resultInParen = calculateExpressionInParen(tokenStack);
                tokenStack.push(String.valueOf(resultInParen));
            }
        }
        return calculateExpressionInParen(tokenStack);
    }

    // вычисление выражения внутри скобок
    private static double calculateExpressionInParen(ArrayStack<String> tokenStack) {
        final ArrayStack<String> tokenInParenStack = getInParenExpression(tokenStack);
        final ArrayStack<String> afterTimesAndDivisionReversedStack = calculateTimesAndDivision(tokenInParenStack);
        final ArrayStack<String> afterTimesAndDivisionStack = reverseStack(afterTimesAndDivisionReversedStack);

        return calculatePlusAndMinus(afterTimesAndDivisionStack);
    }

    // переложить содержимое скобок в другой стек в прямом порядке
    private static ArrayStack<String> getInParenExpression(ArrayStack<String> tokenStack) {
        final ArrayStack<String> tokenInParenStack = new ArrayStack<>();
        String token = tokenStack.pop();
        while (!token.equals(String.valueOf(LEFT_PAREN))) {
            tokenInParenStack.push(token);
            token = tokenStack.pop();
        }
        return tokenInParenStack;
    }

    // вычислить все умножения и деления
    private static ArrayStack<String> calculateTimesAndDivision(ArrayStack<String> tokenStack) {
        String token;
        final ArrayStack<String> afterTimesAndDivisionStack = new ArrayStack<>();
        while (!tokenStack.isEmpty()) {
            token = tokenStack.pop();
            final char operation = token.charAt(0);
            if (operation == TIMES || operation == DIVISION) {
                double first = Double.parseDouble(afterTimesAndDivisionStack.pop());
                final double second = Double.parseDouble(tokenStack.pop());
                switch (operation) {
                    case TIMES:
                        first *= second;
                        break;
                    case DIVISION:
                        first /= second;
                        break;
                }
                afterTimesAndDivisionStack.push(String.valueOf(first));
            } else {
                afterTimesAndDivisionStack.push(token);
            }
        }
        return afterTimesAndDivisionStack;
    }

    // перевернуть порядок выражения
    private static ArrayStack<String> reverseStack(ArrayStack<String> tokenStack) {
        final ArrayStack<String> reversedStack = new ArrayStack<>();
        while (!tokenStack.isEmpty()) {
            reversedStack.push(tokenStack.pop());
        }
        return reversedStack;
    }

    private static double calculatePlusAndMinus(ArrayStack<String> tokenStack) {
        // получить итоговое число, вычислив суммы и разности
        double result = Double.parseDouble(tokenStack.pop());
        while (!tokenStack.isEmpty()) {
            final char operation = tokenStack.pop().charAt(0);
            final double second = Double.parseDouble(tokenStack.pop());
            switch (operation) {
                case PLUS:
                    result += second;
                    break;
                case MINUS:
                    result -= second;
                    break;
            }
        }
        return result;
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
