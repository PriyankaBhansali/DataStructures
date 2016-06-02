//import java.util.Scanner;
import java.util.*;

class InfixEvaluation
{
    public static int evaluate(String expression)
    {
        char[] a = expression.toCharArray();
        for (int i = 0; i < a.length; i++)     
 System.out.println("a = " +a[i]);
         // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<Integer>();
 
        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();
 
        for (int i = 0; i < a.length; i++)
        {
             // Current token is a whitespace, skip it
            if (a[i] == ' ')
                continue;
 
            // Current token is a number, push it to stack for numbers
            if (a[i] >= '0' && a[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < a.length && a[i] >= '0' && a[i] <= '9')
                    {
                	System.out.println(".." +a[i]);
                	System.out.println("...." + sbuf.append(a[i++]));
                    }
                values.push(Integer.parseInt(sbuf.toString()));
            }
 
            // Current token is an opening brace, push it to 'ops'
            else if (a[i] == '(')
                ops.push(a[i]);
 
            // Closing brace encountered, solve entire brace
            else if (a[i] == ')')
            {
                while (ops.peek() != '(')
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }
 
            // Current token is an operator.
            else if (a[i] == '+' || a[i] == '-' || a[i] == '*' || a[i] == '/')
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && Precedence(a[i], ops.peek()))
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
 
                // Push current token to 'ops'.
                ops.push(a[i]);
            }
        }
 
        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
 
        // Top of 'values' contains result, return it
        return values.pop();
    }
 
    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean Precedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
 
    // A utility method to apply an operator 'op' on operands 'a' 
    // and 'b'. Return the result.
    public static int applyOp(char op, int y, int x)
    {
        switch (op)
        {
        case '+':
            return x + y;
        case '-':
            return x - y;
        case '*':
            return x * y;
        case '/':
            if (y == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return x / y;
        }
        return 0;
    }
 
    // Driver method to test above methods
    public static void main(String[] args)
    {
       //System.out.println(evaluate("10 + 2 * 6"));
        System.out.println(evaluate("100 * 2 + 12"));
        System.out.println(evaluate("100 * ( 2 + 12 )"));
        System.out.println(evaluate("100 * ( 2 + 12 ) / 14"));
    }
}

