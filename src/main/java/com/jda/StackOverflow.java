package com.jda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StackOverflow {
    public static void main(String[] args) {
        String source = "Logger.getInstance(JdkUtil.forceInit(RtpRuleEngineCompiledImpl.class));";
        String regexpPattern = "JdkUtil.forceInit\\(([a-zA-Z_0-9]*.class)\\)";

        Pattern pattern = Pattern.compile(regexpPattern, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(source);

        while(matcher.find() == true) {
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.replaceAll("$1"));
        }


        //System.out.println("The group count is: " + matcher.groupCount());
//        Pattern newPattern = Pattern.compile("([a-z]{1,1})([0-9]{2,2})");
//        Matcher newMatcher = newPattern.matcher("a38 d45");
//
//        System.out.println(newMatcher.find());
//        System.out.println(newMatcher.groupCount());
//        System.out.println(newMatcher.replaceAll("$2$1"));
//        System.out.println("DONE!!!");

//        String newStr = Pattern.compile("([a-z]{1,1})([0-9]{2,2})")
//                .matcher("a38 d45")
//                .replaceAll("$2$1");

//        System.out.println(newStr);


//        String replaced = source.replaceFirst(regexpPattern, "$1");

//        System.out.println(replaced);
    }
}
