package com.jda

import java.util.regex.Matcher
import java.util.regex.Pattern

class ParseJdkUtilMultiline {

    static void main(String... args) {
        println 'Beginning read...'

        ParseJdkUtilMultiline parser = new ParseJdkUtilMultiline()

        parser.readAllJavaFiles()

        println 'Done processing files'
    }

    def readAllJavaFiles() {


//        File javaFiles = new File('/Users/juaalvarado/Documents/GitHub/csapimigration/SharedBillingDomain/src/main/java')
//        javaFiles.eachDirRecurse { dir ->
//
//            dir.eachFileMatch(~/.*.java/) { file ->
//
//                processFile(file)
//
//            }
//        }
        processFile()
    }

    def processFile() {

        Pattern pattern = Pattern.compile('JdkUtil(?s).forceInit\\(([a-zA-Z_0-9]*.class)\\)');
        def source = 'jdkUtil\n' +
                '.forceInit(PaymentEventEnum.class)'
        Matcher matcher = pattern.matcher(source);

        //String regexpPattern = '(?s)JdkUtil\\s.forceInit\\(([a-zA-Z_0-9]*.class)\\)'


//        def replaced = source.replaceFirst(regexpPattern, '$1')
//
//        println "Replaced is ${replaced}"
        println 'Done!!'

    }
}
