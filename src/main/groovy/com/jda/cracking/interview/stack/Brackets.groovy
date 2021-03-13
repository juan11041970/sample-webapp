package com.jda.cracking.interview.stack

class Brackets {

    static void main(String[] args) {
//        String parens = "(((((())))))"
        String parens = "((()(())))"
        Brackets brackets = new Brackets()

        println brackets.isValidBracket(parens)
    }

    private boolean isValidBracket(String brackets) {

        char[] chars = brackets.toCharArray()
        int left, right

//        chars.eachWithIndex { char entry, int i ->
            for (int i = 0; i < chars.length; i++) {
                String entryStr = chars[i].toString()
                if (i == 0 && entryStr.equals(")")) {
                    println "i is zero with closing bracket"
                    return false
                } else if (i == 0 && entryStr.equals("(")) {
                    left++
                } else if (entryStr.equals("(")) {
                    left++
                } else if (entryStr.equals(")")) {
                    right++
                }
            }
//        }
        println left + "--" + right

        if (left == right) {
            return true
        }

        return false
    }
}
