package list_stacks_queue.pluralsight_stack_deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by liuyufei on 27/10/16.
 */
public class Calculator {

    public int evalute(final String input){

        final Deque<String> stack = new ArrayDeque<>();
        final String[] tokens =  input.split(" ");
        for(String token:tokens){
            stack.add(token);
        }

        while (stack.size()>1){
            int left = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int right = Integer.parseInt(stack.pop());

            int result = 0;
            switch (operator){
                case "+":
                    result = left+right;
                    break;
                case "-":
                    result = left-right;
                    break;
            }
            stack.push(String.valueOf(result));

        }

        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.evalute("1 + 2"));
    }
}
