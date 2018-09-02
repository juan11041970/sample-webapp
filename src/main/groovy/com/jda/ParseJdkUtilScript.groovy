package com.jda

class ParseJdkUtilScript {

    static void main(String... argss) {
        println "In main";

        ParseJdkUtilScript parser = new ParseJdkUtilScript()

        File javaCode = new File("/Users/juaalvarado/temp", "jdkreplace.txt")

        parser.readAllJavaFiles()
    }

    def modifyLine(String line) {

        StringBuilder newJavaCode = new StringBuilder()

        //Getr id of the jdkUtil force init call first
        String toReplace = "JdkUtil.forceInit\\(";
        String tempStr = line.replaceAll(toReplace, "")

        //Now get rid of the parentheses that closes the jdkUtil force init method call
        tempStr = tempStr.replaceFirst("\\)", "")

        newJavaCode.append(tempStr)

        println(newJavaCode.toString())
    }

    def readAllJavaFiles() {

        //        javaCode.eachLine { line ->
//            String temp = line
//            parser.modifyLine temp
//        }

        File javaFiles = new File('/Users/juaalvarado/Documents/GitHub/csapimigration/SharedBillingDomain/src/main/java')
        javaFiles.eachDirRecurse { dir ->

            dir.eachFileMatch(~/.*.java/) { file ->

                processFile(file)
            }
        }
    }

    def processFile(File file) {

        //private static final Logger m_logger = Logger.getInstance(JdkUtil.forceInit(RtpRuleEngineCompiledImpl.class));
        //JdkUtil.forceInit\([a-zA-Z_0-9]*.class\)\)
        String source = 'Logger.getInstance(JdkUtil.forceInit(RtpRuleEngineCompiledImpl.class))'
        String regexpPattern = 'JdkUtil.forceInit\\([a-zA-Z_0-9\\)]*.class\\)'

        String replaced = source.replaceFirst(regexpPattern, '$0')

        println replaced



//        println file.getPath()
//
//        File currentFile = new File(file.getPath())
//        StringBuilder builder = new StringBuilder()
//
//        def lines = currentFile.collect {it}
//
//        lines.each { line ->
//            println line
//        }


    }
}
