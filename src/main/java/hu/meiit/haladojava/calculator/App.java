package hu.meiit.haladojava.calculator;
import java.security.PrivateKey;
import java.util.Scanner;


public class App 
{

    private static final String errorResponse = "-";
    private static String [] parse(String expression){
        String[] returnValue = expression.split(" ");
        return returnValue;
    }


    private static String getExpressionFromStdin(){
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        return  expression;
    }


    public static void assertExpression(String[] parts ) throws Exception{

        if (parts.length != 3) {
            throw new Exception("wrong input");
        }
    }
    private static Expression getAsExpression(String[] parts) {
        return new Expression(
                Integer.parseInt(parts[0]),
                parts[1],
                Integer.parseInt(parts[2]));
    }

    public static String executeExpression(Expression expression){
        Executor executor = new Executor();

        String result = errorResponse;
        if (expression.getOperator().equals("+")) {
            result = String.valueOf(expression.getOperand1() + expression.getOperand2());
        }else if (expression.getOperator().equals("-")) {
            result = String.valueOf(expression.getOperand1() - expression.getOperand2());
        } else if (expression.getOperator().equals("/")) {
            result = String.valueOf(executor.div(expression.getOperand1(), expression.getOperand2()));
        } else if (expression.getOperator().equals("*")) {
            result = String.valueOf(executor.multip(expression.getOperand1(), expression.getOperand2()));
        }
        return result;
    }


    ////////// start main ////////////
    public static void main( String[] args ) {
        String result = errorResponse;
        try {
            String exprFromStdin = getExpressionFromStdin();
            String[] parts = parse(exprFromStdin);
            assertExpression(parts);
            Expression expression = getAsExpression(parts);
            result = executeExpression(expression);
        }catch(Exception ex ){}
            System.out.print(result);


    }
}
