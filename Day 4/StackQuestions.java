import java.util.Stack;
public class StackQuestions{
    public static void reverseString(String str){
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            String word = "";
            while(i < str.length() && str.charAt(i) != ' '){
                word += str.charAt(i);
                i++;
            }
            stack.push(word);
        }
        while(!stack.empty()){
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
    }
    public static int prefix(String s){
        Stack<Integer> stack = new Stack<>();
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '^'){
                int op1 = stack.pop();
                int op2 = stack.pop();
                int result = 0;
                switch(s.charAt(i)){
                    case '+' -> result = op1 + op2;
                    case '-' -> result = op1 - op2;
                    case '*' -> result = op1 * op2;
                    case '/' -> result = op1 / op2;
                    case '^' -> result = (int) Math.pow(op1, op2);
                }
                stack.push(result);
            }
            else{
                stack.push(Character.getNumericValue(s.charAt(i)));
            }
        }
        return stack.peek();
    }
    public static int postfix(String s){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '^'){
                int op2 = stack.pop();
                int op1 = stack.pop();
                int result = 0;
                switch(s.charAt(i)){
                    case '+' -> result = op1 + op2;
                    case '-' -> result = op1 - op2;
                    case '*' -> result = op1 * op2;
                    case '/' -> result = op1 / op2;
                    case '^' -> result = (int) Math.pow(op1, op2);
                }
                stack.push(result);
            }
            else{
                stack.push(Character.getNumericValue(s.charAt(i)));
            }
        }
        return stack.peek();
    }


    public static void main(String[] args) {
        reverseString("Hey, how are you doing?");
        System.out.println();
        System.out.println(prefix("-+7*45+20"));
        System.out.println(postfix("46+2/5*7+"));
    }
}