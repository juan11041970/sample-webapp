package com.jda.cracking.interview.stack

class BalancedBracketsWithoutMap {

    public static void main (String[] args)
    {
        BalancedBracketsWithoutMap myStack = new BalancedBracketsWithoutMap()
        String input = "()[]{}"
        println  myStack.isValid(input)
    }

    boolean isValid(String input) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>()
        final def brackets = input.toCharArray()

        for (int i = 0; i < brackets.length; i++) {
            char currentBracket = brackets[i]

            if (isOpeningBracket(currentBracket)) {
                stack.push(currentBracket)
            } else if (stack.isEmpty()) {
                return false
            } else {
                //Closing bracket
                char top = stack.peek()
                char closingBracket = currentBracket

                if (closingBracket.toString() == ')' && top.toString() == '('
                 || closingBracket.toString() == '}' && top.toString() == '{'
                 || closingBracket.toString() == ']' && top.toString() == '[') {

                    stack.pop()
                } else {
                    return false
                }
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    boolean isClosedBracket(char c) {
        return c == ')' || c == '}' || c == ']'

    }

    def boolean isOpeningBracket(char bracket) {
        return bracket == '(' || bracket == '[' || bracket == '{'
    }
}
