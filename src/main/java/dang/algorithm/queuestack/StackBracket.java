package dang.algorithm.queuestack;

public class StackBracket {
    private StackX stack;

    public StackBracket(int maxSize) {
        stack = new StackX(maxSize);
    }

    /**
     * string matching
     *
     * @param the string you want to test
     */
    public boolean isMatching(String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {

                stack.push(c);
            }
            if (c == ')' || c == ']' || c == '}') {

                if (stack.isEmpty()) {
                    System.out.println("Not matching.");
                    return false;
                }
                char cc = stack.pop();

                if ((c == '(' && cc != ')') || (c == '[' && cc != ']') || (c == '{' && cc != '}')) {
                    System.out.println("Not matching.");
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public boolean isMatching2(String str) {
        int i;
        for (i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if (!stack.isEmpty()) {
                        char cc = stack.pop();
                        if ((c == ')' && cc != '(') || (c == ']' && cc != '[') || (c == '}' && cc != '{')) {
                            System.out.println("Not matching because there is no right bracket matchint left.");
                            System.out.println("check the char " + i);
                            return false;
                        }
                    } else {
                        System.out.println("Not matching because there is no left bracket.");
                        return false;
                    }
                    break;
                default:
                    break;

            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Not matching because there are more left brackets which can't matched.");
            return false;
        }
        return true;
    }

}