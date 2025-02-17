import java.util.Stack;


public class Solution {
    public static String infixToPostfix(String exp) {
        // Write your code here
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<exp.length();i++){
            char curr= exp.charAt(i);

            if(isOpe(curr)) sb.append(curr);
            else if(curr == '(') st.push(curr);
            else if(curr == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    sb.append(st.pop());
                }
                st.pop();
            }
            else if( curr == '-' || curr == '+' || curr == '/' || curr == '*' || curr == '^'){
                while(!st.isEmpty() && precedence(st.peek()) >= precedence(curr)){
                    sb.append(st.pop());
                }
                st.push(curr);
            }
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.toString();
    }

    public static boolean isOpe(char ch){
        return Character.isLetterOrDigit(ch);
    }

    public static int precedence(char op){
        if(op == '-' || op == '+') return 1;
        if(op == '*' || op == '/') return 2;
        if (op == '^') return 3;
        return 0;
        
    }
}
