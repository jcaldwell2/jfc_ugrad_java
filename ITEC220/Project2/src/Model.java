/**
 * @author James Caldwell
 * @version 3/5/2015
 *
 * Model - Creates a stack, evaluates, and returns a postfix value
 *
 * Uses code created by Lewis and Chase to evaluate a stack
 * As well as my own to check for valid input
 */

import java.util.Stack;
import java.util.Scanner;


public class Model
{
    private final static char ADD = '+';
    private final static char SUBTRACT = '-';
    private final static char MULTIPLY = '*';
    private final static char DIVIDE = '/';



    private Stack<Integer> stack;

    /**
     * Sets up this evaluator by creating a new stack.
     */
    public Model()    {
        stack = new Stack<Integer>();
    }

    /**
     * Evaluates the specified postfix expression. If an operand is
     * encountered, it is pushed onto the stack. If an operator is
     * encountered, two operands are popped, the operation is
     * evaluated, and the result is pushed onto the stack.
     * @param expr string representation of a postfix expression
     * @return value of the given expression
     */
    public int evaluate(String expr)
    {
        int op1, op2, result = 0;
        String token;
        Scanner parser = new Scanner(expr);


        while (parser.hasNext() )
        {
            token = parser.next();



            if (isOperator(token))
            {
                op2 = (stack.pop()).intValue();
                op1 = (stack.pop()).intValue();
                result = evaluateSingleOperator(token.charAt(0), op1, op2);
                stack.push(new Integer(result));
            }
            else
                stack.push(new Integer(Integer.parseInt(token)));


        }

        return result;
    }

    /**
     * isValid - checks the string for valid input for postfix expressions
     * @param test is the parsed portion of the string that is evaluated
     * first
     * @return "Valid" or an error message with the error
    */
    public String isValid(String test){

        Scanner parser = new Scanner(test);


        int nums = 0;
        int ops = 0;
        int total = 0;

        while (parser.hasNext() ){

            String token;
            token = parser.next();

            if(!token.matches("[0-9]+") && !token.matches("[+\\-*/]") )
                return "Error: Check input for mistyping";

            if(token.matches("[0-9]+"))
                nums += 1;

            if(token.matches("[+\\-*/]"))
                ops += 1;




        }

        if(nums < 2 )
            return "You need 2 or more numbers" ;
        if(ops < 1)
            return "You need 1 or more operators";

        if(nums - ops == 1)

            return "Valid";


        if(ops >= nums) {

            total = (ops - nums) + 1 ;
            return "There are " + total + " more operands than you need";

        }

        if(ops < nums - 1) {

            total = (nums - 1) - ops;
            return "You need " + total + " more operators";

        }




        return "Valid";
    }


    /**
     * Determines if the specified token is an operator.
     * @param token the token to be evaluated
     * @return true if token is operator
     */

    private boolean isOperator(String token)
    {
        return ( token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/") );
    }

    /**
     * Peforms integer evaluation on a single expression consisting of
     * the specified operator and operands.
     * @param operation operation to be performed
     * @param op1 the first operand
     * @param op2 the second operand
     * @return value of the expression
     */
    private int evaluateSingleOperator(char operation, int op1, int op2)
    {
        int result = 0;

        switch (operation)
        {
            case ADD:
                result = op1 + op2;
                break;
            case SUBTRACT:
                result = op1 - op2;
                break;
            case MULTIPLY:
                result = op1 * op2;
                break;
            case DIVIDE:
                result = op1 / op2;
        }

        return result;
    }

    public int getPeek() {

        return stack.peek();
    }


}
