package com.jda.cracking.interview.stack

class BalancedBracketsWithMap {

    public static void main (String[] args)
    {
        BalancedBracketsWithMap myStack = new BalancedBracketsWithMap()
        String input = "()[]{}"
        println  myStack.isValid(input)

    }

    boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (i == 0 && isClosedBracket(c)) {
                //Not valid
                return false
            } else if (mappings.containsKey(c.toString())) {
                char top = stack.peek()
                if (mappings.get(c.toString()) != top) {
                    return false
                }
                stack.pop()
            } else {
                stack.push(c)
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    boolean isClosedBracket(char c) {
        return c == ')' || c == '}' || c == ']'

    }
}
