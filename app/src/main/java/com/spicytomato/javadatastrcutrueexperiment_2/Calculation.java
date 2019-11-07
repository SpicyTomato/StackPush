package com.spicytomato.javadatastrcutrueexperiment_2;

public class Calculation extends Stack {
    public static StringBuffer toPostfix(String infix){
        Stack<String> stack = new Stack<>();
        StringBuffer postfix = new StringBuffer(infix.length() * 2);
        int i = 0;
        while (i < infix.length()){
            char ch = infix.charAt(i);
            switch (ch){
                case '+': case '-':
                    while (!stack.isEmpty() && !stack.StackPeek().equals("(")){
                        postfix.append(stack.StackPop());
                    }
                    stack.StackPush(ch + "");
                    i++;
                    break;
                case '*': case '/':
                    while (!stack.isEmpty() && (stack.StackPeek().equals("*") || stack.StackPeek().equals("/"))){
                        postfix.append(stack.StackPop());
                    }
                    i++;
                    break;
                case '(':
                    stack.StackPush(ch+"");
                    i++;
                    break;
                case ')':
                    String out = stack.StackPop();
                    while(out != null && out.equals("(")){
                        postfix.append(out);
                        out = stack.StackPop();
                    }
                    i++;
                    break;
                default:
                    while (i < infix.length() && ch >= '0' && ch <= '9'){
                        postfix.append(ch);
                        i++;
                        if(i < infix.length()){
                            ch = infix.charAt(i);
                        }
                    }
                    postfix.append(" ");
            }
        }
        while (!stack.isEmpty()){
            postfix.append(stack.StackPop());
        }
        return postfix;
    }

    public static int toValue(StringBuffer postfix){
        Stack<Integer> stack = new Stack<Integer>();
        int value = 0;
        for(int i = 0; i < postfix.length() ;i++){
            char ch = postfix.charAt(i);
            if(ch >= '0' && ch <= '9'){
                value = 0;
                while (ch != ' '){
                    value = value * 10 + ch - '0';
                    ch = postfix.charAt(++i);
                }
                stack.StackPush(value);
            }else {
                if (ch != ' '){
                    int y = stack.StackPop() , x = stack.StackPop();

                    switch (ch){
                        case '+':value = x + y; break;
                        case '-':value = x - y; break;
                        case '*':value = x * y; break;
                        case '/':value = x / y; break;
                    }

                    System.out.printf(x + (ch+ "") + y + "=" + value + ", ");
                    stack.StackPush(value);
                }
            }
        }
        return stack.StackPop();
    }
}

